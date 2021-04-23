package com.example.easygobandtest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.easygobandtest.Adapters.AdapterListaSesiones;
import com.example.easygobandtest.R;
import com.example.easygobandtest.Models.Session;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaSesionesActivity extends AppCompatActivity {

    ArrayList<Session> sessions;

    ListView sessions_listView;

    AdapterListaSesiones adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sesiones);

        sessions_listView = (ListView) findViewById(R.id.sessions_listView);

        //Obtiene la lista de las sesiones del proveedor
        Serializable serializable = getIntent().getSerializableExtra("sessions");
        if(serializable!=null) {
            sessions = (ArrayList<Session>) serializable;

            adapter = new AdapterListaSesiones(ListaSesionesActivity.this, R.layout.item_lista_sessions, sessions);
            sessions_listView.setAdapter(adapter);

        }else{
            finish();
        }

    }

}