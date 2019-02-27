package com.ibm.hanryteixeira.projetodetreinamento6.activity_login;

import com.ibm.hanryteixeira.projetodetreinamento6.domain.LoginResponseBody;
import com.ibm.hanryteixeira.projetodetreinamento6.mvp.MvpView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter {
    public LoginContract.View mView;
    private final LoginContract.Interactor mInteractor;


    // todo, casos de uso vem aqui!
    public LoginPresenter(LoginContract.View view) {
        mView = view;
        mInteractor = new LoginInteractor();
    }

    @Override
    public void onLoginClicked(String email, String password) {

        EmailValidator emailValidator = new EmailValidator();
        PasswordValidator passwordValidator = new PasswordValidator();


        if (!emailValidator.validateEmail(email)) {
            mView.invalidEmail();
            return;
        }

        if (!passwordValidator.validate(password)) {
            mView.invalidPassword();
            return;
        }

        mInteractor.login(email, password, new Callback<LoginResponseBody>() {
            @Override
            public void onResponse(Call<LoginResponseBody> call, Response<LoginResponseBody> response) {

                LoginResponseBody userAccount = response.body();
//                assert userAccount != null;

                mView.sucessoLogin(userAccount);
            }

            @Override
            public void onFailure(Call<LoginResponseBody> call, Throwable t) {
                mView.falhaRequesicao();
            }
        });
    }
}
