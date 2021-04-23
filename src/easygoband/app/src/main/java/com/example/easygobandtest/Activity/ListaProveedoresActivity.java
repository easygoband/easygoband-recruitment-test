package com.example.easygobandtest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.easygobandtest.Adapters.AdapterListaProveedores;
import com.example.easygobandtest.Net.ApiService;
import com.example.easygobandtest.Models.Proveedor;
import com.example.easygobandtest.Net.ProveedoresResponse;
import com.example.easygobandtest.R;
import com.example.easygobandtest.Net.RestApiAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ListaProveedoresActivity extends AppCompatActivity {

    private String ID_EVENTO;

    ArrayList<Proveedor> proveedores;
    AdapterListaProveedores adapter;

    ListView proveedoresListView;
    SearchView barraFiltro;
    ProgressBar progressBar;
    TextView avisoTxt, aviso2Txt, avisoBtn, filtroInfo_txt,
            id_evento_Txt, num_resultados_Txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_proveedores);

        filtroInfo_txt=(TextView) findViewById(R.id.filtroInfo_Txt);
        id_evento_Txt=(TextView) findViewById(R.id.ID_EVENTO_txt);
        num_resultados_Txt=(TextView) findViewById(R.id.num_resultados_txt);
        avisoTxt=(TextView) findViewById(R.id.aviso_Txt);
        aviso2Txt = (TextView) findViewById(R.id.aviso2_Txt);
        avisoBtn=(Button) findViewById(R.id.aviso_Btn);
        proveedoresListView=(ListView) findViewById(R.id.proveedoresListView);
        barraFiltro=(SearchView) findViewById(R.id.barraFiltro);
        progressBar=(ProgressBar) findViewById(R.id.id_progressbar);

        //Obtiene la ID del evento seleccionado
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            ID_EVENTO=bundle.getString("ID");

            cargarProveedores(ID_EVENTO);

        }else{
            finish();
        }


        proveedoresListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Proveedor item=(Proveedor)proveedoresListView.getItemAtPosition(position);

                //Inicia Actividad con detalles del proveedor seleccionado de la lista
                Intent intent=new Intent(ListaProveedoresActivity.this,DetallesActivity.class);
                intent.putExtra("proveedor",item);
                startActivity(intent);

            }
        });

        //Barra de busqueda para filtrado de la lista
        barraFiltro.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ListaProveedoresActivity.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ListaProveedoresActivity.this.adapter.getFilter().filter(newText);
                return false;
            }
        });

        //Boton de vuelta a pantalla inicial tras un error
        avisoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //Funcion para la obtención del listado de proveedores de acceso desde la API
    private void cargarProveedores(String id){

        progressBar.setVisibility(View.VISIBLE);//Barra de progreso visible

        RestApiAdapter restApiAdapter=new RestApiAdapter();
        final Gson gson=restApiAdapter.convierteGsonDeserializadorProveedores();
        ApiService apiService= new RestApiAdapter().establecerConexionApiRest(gson);

        Call<ProveedoresResponse> call=apiService.find(id);

        call.enqueue(new Callback<ProveedoresResponse>() {
            @Override
            public void onResponse(Call<ProveedoresResponse> call, Response<ProveedoresResponse> response) {

                if(response.isSuccessful()) { //Peticion exitosa
                    ProveedoresResponse proveedoresResponse = response.body();

                    if (proveedoresResponse != null) {
                        //se obtiene arraylist con los proveedores
                        proveedores = proveedoresResponse.getProveedores();

                        id_evento_Txt.setText(getString(R.string.evento_seleccionado_ID, limitadorStringSize(ID_EVENTO, 10)));
                        num_resultados_Txt.setText(getString(R.string.resultados_evento, proveedores.size()));
                        id_evento_Txt.setVisibility(View.VISIBLE);
                        num_resultados_Txt.setVisibility(View.VISIBLE);
                        barraFiltro.setVisibility(View.VISIBLE);

                        adapter = new AdapterListaProveedores(ListaProveedoresActivity.this, R.layout.item_lista_proveedores, proveedores);
                        proveedoresListView.setAdapter(adapter);

                        progressBar.setVisibility(View.GONE); //Barra progreso invisible. Fin de carga
                    }
                }else { //En caso de error en la peticion

                    if(response.code()==404){ //Error 404. No encontrado

                        avisoTxt.setText(getString(R.string.error_404_1));
                        aviso2Txt.setText(getString(R.string.error_404_2, limitadorStringSize(ID_EVENTO, 10)));

                        aviso2Txt.setVisibility(View.VISIBLE);
                    }
                    else if(response.code()==401){ //Error 401. No autorizado
                        avisoTxt.setText(getString(R.string.error_401));
                    }
                    progressBar.setVisibility(View.GONE);
                    barraFiltro.setVisibility(View.INVISIBLE);
                    avisoTxt.setVisibility(View.VISIBLE);
                    avisoBtn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ProveedoresResponse> call, Throwable t) {
                Log.e("Error", t.toString());

                progressBar.setVisibility(View.GONE);
                avisoTxt.setText(getString(R.string.onFailed_peticion_1));
                aviso2Txt.setText(getString(R.string.onFailed_peticion_2));
                avisoTxt.setVisibility(View.VISIBLE); aviso2Txt.setVisibility(View.VISIBLE);
                avisoBtn.setVisibility(View.VISIBLE);
            }
        });
    }


    public void actualizarInfoFiltrado(int datosFiltrados){

        if(datosFiltrados < proveedores.size()){
            filtroInfo_txt.setText(getString(R.string.datos_filtrados, datosFiltrados));
            filtroInfo_txt.setVisibility(View.VISIBLE);
        }
        else{
            filtroInfo_txt.setVisibility(View.GONE);
        }
    }

    private String limitadorStringSize(String strOriginal, int limite){
        String stringFinal;
        if(strOriginal.length() > limite){
            stringFinal = strOriginal.substring(0,10)+"...";
        }
        else{
            stringFinal = strOriginal;
        }
        return stringFinal;
    }

}