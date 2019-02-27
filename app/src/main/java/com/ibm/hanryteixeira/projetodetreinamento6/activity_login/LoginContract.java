package com.ibm.hanryteixeira.projetodetreinamento6.activity_login;

import com.ibm.hanryteixeira.projetodetreinamento6.domain.LoginResponseBody;
import com.ibm.hanryteixeira.projetodetreinamento6.mvp.MvpView;

import retrofit2.Callback;

public interface LoginContract {
    interface View extends MvpView{

        void invalidEmail();

        void invalidPassword();

        void falhaRequesicao();

        void sucessoLogin(LoginResponseBody userAccount);
    }

    interface Presenter{

        void onLoginClicked(String email, String password);
    }

    interface Interactor {

        void login(String email, String password, Callback<LoginResponseBody> callbackLogin);
    }
}
