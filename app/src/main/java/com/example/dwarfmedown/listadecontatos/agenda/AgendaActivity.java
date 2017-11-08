package com.example.dwarfmedown.listadecontatos.agenda;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dwarfmedown.listadecontatos.R;
import com.example.dwarfmedown.listadecontatos.add_contact.AddContactActivity;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AgendaActivity extends AppCompatActivity implements AgendaView{

    AgendaPresenter agendaPresenter;

    @BindView(R.id.lst_contact)
    ListView lstContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        ButterKnife.bind(this);

        agendaPresenter = new AgendaPresenter(this);
    }

    @OnClick(R.id.btn_add_contact)
    public void addContact(){
        Intent openAddContactActivity = new Intent(this, AddContactActivity.class);
        startActivityForResult(openAddContactActivity, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        agendaPresenter.addContactInList(requestCode,resultCode, data);
    }

    public void updateList(List<String> contactList) {
        ArrayAdapter<String> contactsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactList);
        lstContact.setAdapter(contactsAdapter);
    }
}
