package com.ibm.hanryteixeira.projetodetreinamento6.activity_login;

import com.ibm.hanryteixeira.projetodetreinamento6.domain.LoginResponseBody;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitData {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponseBody> buscarUser(
            @Field("user") String userAccount,
            @Field("password") String userPassword);
}
