package com.example.dwarfmedown.listadecontatos.add_contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dwarfmedown.listadecontatos.R;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddContactActivity extends AppCompatActivity {

    @BindView(R.id.edt_contact_name)
    EditText contactName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_contact_added)
    public void contactAdded(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("contact_name", contactName.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}