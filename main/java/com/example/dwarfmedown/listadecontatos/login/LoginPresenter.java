package com.example.dwarfmedown.listadecontatos.login;

import android.text.TextUtils;

/**
 * Created by lucas_000 on 08.11.2017.
 */

public class LoginPresenter {

    LoginView loginView;

    public LoginPresenter(LoginView loginView){

        this.loginView = loginView;
    }

    public void login(String username, String password){
        if(TextUtils.isEmpty(username)){
            //show user error msg
            loginView.setUserError();
        } else if (TextUtils.isEmpty(password)){
            //show pass error msg
            loginView.setPassError();
        } else{
            //open agendaActivity
            loginView.loginSuccessful();
        }
    }
}
