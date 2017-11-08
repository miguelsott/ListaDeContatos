package com.example.dwarfmedown.listadecontatos.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.example.dwarfmedown.listadecontatos.agenda.AgendaActivity;
import com.example.dwarfmedown.listadecontatos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.text_input_layout_username) TextInputLayout usernameTextInputLayout;
    @BindView(R.id.edit_text_username) TextInputEditText usernameEditText;
    @BindView(R.id.text_input_layout_password) TextInputLayout passwordTextInputLayout;
    @BindView(R.id.edit_text_password) TextInputEditText passwordEditText;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(LoginActivity.this);
    }

    @OnTextChanged(R.id.edit_text_username)
    public void validateUser(){
        usernameTextInputLayout.setErrorEnabled(false);
        usernameTextInputLayout.setError("");

    }

    @OnTextChanged(R.id.edit_text_password)
    public void validatePassword(){
        passwordTextInputLayout.setErrorEnabled(false);
        passwordTextInputLayout.setError("");

    }

    @OnClick(R.id.button_login)
    public void doLogin(){

        loginPresenter.login(
                usernameEditText.getText().toString(),
                passwordEditText.getText().toString());

    }

    public void setUserError(){
        usernameTextInputLayout.setErrorEnabled(true);
        usernameTextInputLayout.setError(getString(R.string.invalid_username));
    }

    public void setPassError(){
        passwordTextInputLayout.setErrorEnabled(true);
        passwordTextInputLayout.setError(getString(R.string.invalid_password));
    }

    public void loginSuccessful(){
        Intent openAgendaActivity = new Intent(LoginActivity.this, AgendaActivity.class);
        startActivity(openAgendaActivity);
    }

}
