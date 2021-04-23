package com.example.easygobandtest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.easygobandtest.Models.Proveedor;
import com.example.easygobandtest.R;


import java.util.ArrayList;

public class InicioActivity extends AppCompatActivity {

    ArrayList<Proveedor> proveedores;

    TextView ayuda_txt;
    EditText searchIdTxt;
    Button buscarIdBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        proveedores=new ArrayList<>();
        ayuda_txt=(TextView) findViewById(R.id.ayuda_txt);
        searchIdTxt=(EditText)findViewById(R.id.IDtxt);
        buscarIdBtn=(Button) findViewById(R.id.buscarIDButton);

        buscarIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!searchIdTxt.getText().toString().equals("")){ //Contiene texto

                    //Carga pantalla listado de proveedores
                    Intent intent= new Intent(InicioActivity.this, ListaProveedoresActivity.class);
                    intent.putExtra("ID", searchIdTxt.getText().toString());
                    startActivity(intent);
                }
                else{
                    ayuda_txt.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}