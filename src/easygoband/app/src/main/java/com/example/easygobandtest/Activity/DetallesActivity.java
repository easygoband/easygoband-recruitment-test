package com.example.easygobandtest.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.easygobandtest.Models.Proveedor;
import com.example.easygobandtest.R;

import java.io.Serializable;

public class DetallesActivity extends AppCompatActivity {

    Proveedor proveedor;

    TextView access_group_name_txt, access_group_id_txt,
            total_uses_txt, event_id_txt, structure_decode_txt,
            modified_txt, name_txt, id_txt,basic_product_txt;
    Button sessions_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        access_group_name_txt =(TextView) findViewById(R.id.group_name_txt);
        access_group_id_txt =(TextView) findViewById(R.id.group_id_txt);
        total_uses_txt =(TextView) findViewById(R.id.total_uses_txt);
        event_id_txt =(TextView) findViewById(R.id.event_id_txt);
        structure_decode_txt =(TextView) findViewById(R.id.structure_decode_txt);
        name_txt =(TextView) findViewById(R.id.name_txt);
        modified_txt =(TextView) findViewById(R.id.modified_txt);
        id_txt =(TextView) findViewById(R.id.id_txt);
        basic_product_txt =(TextView) findViewById(R.id.basic_product_id_txt);
        sessions_Btn = (Button) findViewById(R.id.sessions_btn);

        //Obtiene al proveedor seleccionado en la lista
        Serializable serializable = getIntent().getSerializableExtra("proveedor");
        if(serializable!=null){
            proveedor=(Proveedor) serializable;

            access_group_name_txt.setText(proveedor.getAccess_group_name());
            access_group_id_txt.setText(String.valueOf(proveedor.getAccess_group_id()));
            total_uses_txt.setText(String.valueOf(proveedor.getTotaluses()));
            event_id_txt.setText(String.valueOf(proveedor.getEvent_id()));
            structure_decode_txt.setText(String.valueOf(proveedor.isStructure_decode()));
            name_txt.setText(proveedor.getName());
            modified_txt.setText(proveedor.getModified());
            id_txt.setText(String.valueOf(proveedor.getId()));
            basic_product_txt.setText(String.valueOf(proveedor.getBasic_product_id()));

        }else{
            finish();
        }

        sessions_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Carga pantalla listado de sesiones del proveedor
                Intent intent=new Intent(DetallesActivity.this,ListaSesionesActivity.class);
                intent.putExtra("sessions",proveedor.getSessions());
                startActivity(intent);
            }
        });
    }
}