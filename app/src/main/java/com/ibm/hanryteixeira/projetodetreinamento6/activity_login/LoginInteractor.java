package com.ibm.hanryteixeira.projetodetreinamento6.activity_login;


import com.ibm.hanryteixeira.projetodetreinamento6.domain.LoginResponseBody;
import com.ibm.hanryteixeira.projetodetreinamento6.domain.UserAccount;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class LoginInteractor extends LoginActivity implements LoginContract.Interactor {
    final Retrofit retrofit;

    public LoginInteractor() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://bank-app-test.herokuapp.com/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public RetrofitData getUserAccountService() {
        return this.retrofit.create(RetrofitData.class);
    }


    @Override
    public void login(String email, String password, Callback<LoginResponseBody> callbackLogin) {

        Call<LoginResponseBody> call = new LoginInteractor().getUserAccountService()
                .buscarUser(email, password);
        call.enqueue(callbackLogin);

    }


}
