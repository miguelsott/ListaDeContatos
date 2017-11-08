package com.example.dwarfmedown.listadecontatos.agenda;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas_000 on 08.11.2017.
 */

public class AgendaPresenter {

    AgendaView agendaView;
    List<String> contactList = new ArrayList<>();

    public AgendaPresenter(AgendaView agendaView){
        this.agendaView = agendaView;
    }

    protected void addContactInList(int requestCode, int resultCode, Intent data){
        if(requestCode == 123 && resultCode == Activity.RESULT_OK){
            String contactName = data.getStringExtra("contact_name");

            //add new contact
            contactList.add(contactName);

            //update List visualization
            agendaView.updateList(contactList);
        }
    }
}
