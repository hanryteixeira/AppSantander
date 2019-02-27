package com.ibm.hanryteixeira.projetodetreinamento6.activity_login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ibm.hanryteixeira.projetodetreinamento6.R;
import com.ibm.hanryteixeira.projetodetreinamento6.domain.LoginResponseBody;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    private LoginContract.Presenter mPresenter;
    private EditText etEmail, etPassword;
    private TextView tvResultado;
    private Button btEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadControls();
    }

    private void loadControls() {
        mPresenter = new LoginPresenter(this);
        loadUi();
        loadListeners();
    }

    private void loadListeners() {
        btEnter.setOnClickListener(this);
    }

    private void loadUi() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btEnter = findViewById(R.id.btEnter);
        tvResultado = findViewById(R.id.tvResposta);
    }

    @Override
    public void invalidEmail() {
        Toast.makeText(this,
                "E-mail inválido, por favor, insira um endereço de e-mail válido"
                , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void invalidPassword() {
        Toast.makeText(this,
                "Senha inválida, por favor, insira uma senha válida"
                , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void falhaRequesicao() {
        Toast.makeText(this,
                "Falha na Requisição"
                , Toast.LENGTH_SHORT).show();

    }

    @Override
    public void sucessoLogin(LoginResponseBody userAccount) {
        Toast.makeText(this,
                "Sucesso na Requisição"
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btEnter.getId()) {
            mPresenter.onLoginClicked(etEmail.getText().toString(), etPassword.getText().toString());
        }
    }
}
