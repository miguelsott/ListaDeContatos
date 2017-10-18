package com.example.dwarfmedown.listadecontatos;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.view.View;
import android.text.TextUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    TextInputLayout usernameTextInputLayout;
    TextInputEditText usernameEditText;
    TextInputLayout passwordTextInputLayout;
    TextInputEditText passwordEditText;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTextInputLayout = (TextInputLayout) findViewById(R.id.text_input_layout_username);
        usernameEditText = (TextInputEditText) findViewById(R.id.edit_text_username);
        passwordTextInputLayout = (TextInputLayout) findViewById(R.id.text_input_layout_password);
        passwordEditText = (TextInputEditText) findViewById(R.id.edit_text_password);
        buttonLogin = (Button) findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(usernameEditText.getText().toString())) {
                    usernameTextInputLayout.setErrorEnabled(true);
                    usernameTextInputLayout.setError(getString(R.string.invalid_username));
                    return;
                }

                if (TextUtils.isEmpty(passwordEditText.getText().toString())) {
                    passwordTextInputLayout.setErrorEnabled(true);
                    passwordTextInputLayout.setError(getString(R.string.invalid_password));
                    return;
                }

                Intent abrirLoginActivity = new Intent(MainActivity.this, Login.class);
                startActivity(abrirLoginActivity);
            }
        });

        usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //vazio
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                usernameTextInputLayout.setErrorEnabled(false);
                usernameTextInputLayout.setError("");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //vazio
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //vazio
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                passwordTextInputLayout.setErrorEnabled(false);
                passwordTextInputLayout.setError("");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //vazio
            }
        });
    }
}