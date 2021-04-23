package com.example.easygobandtest.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.easygobandtest.Activity.ListaProveedoresActivity;
import com.example.easygobandtest.Models.Proveedor;
import com.example.easygobandtest.R;
import com.example.easygobandtest.Models.Session;

import java.util.ArrayList;

public class AdapterListaProveedores extends BaseAdapter implements Filterable {

    private ListaProveedoresActivity activity;
    private int layout;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Proveedor> filteredData;

    public AdapterListaProveedores(ListaProveedoresActivity activity, int layout, ArrayList<Proveedor> proveedores){
        this.activity = activity;
        this.layout = layout;
        this.proveedores = proveedores;
        filteredData=proveedores;
    }

    @Override
    public int getCount() {

       /*//Limitar tamaño Listview a 10 items
       if(filteredData.size()<10){ return filteredData.size(); }
        else{ return 10; }*/
       return filteredData.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredData.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(activity);

        v= layoutInflater.inflate(R.layout.item_lista_proveedores, null);
        // Valor actual según la posición
        Proveedor proveedor= filteredData.get(position);

        String name =proveedor.getName();
        String session_names = "";
        //Juntamos los nombres de las sesiones del proveedor en un string
        for(Session s:proveedor.getSessions()){
            session_names+=s.getName()+", ";
        }
        if(session_names.length()>2){
            session_names = session_names.substring(0, session_names.length()-2);
        }

        TextView item_name_textView=(TextView) v.findViewById(R.id.item_name_txt);
        TextView item_session_name_txt=(TextView) v.findViewById(R.id.item_sessions_names_txt);


        item_name_textView.setText(name);
        item_session_name_txt.setText(activity.getString(R.string.item_lista_all_sess_name, session_names));

        //Devolvemos la vista inflada
        return v;
    }


    //Funcion filtrado del ListView
    @Override
    public Filter getFilter() {
        return new Filter()
        {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence)
            {
                FilterResults results = new FilterResults();

                //Si no hay ningun valor para filtrar, devuelve la lista original
                if(charSequence == null || charSequence.length() == 0)
                {
                    results.values = proveedores;
                    results.count = proveedores.size();
                }
                else
                {
                    ArrayList<Proveedor> filterResultsData = new ArrayList<Proveedor>();

                    for(Proveedor data : proveedores)
                    {
                        for(Session s:data.getSessions()){
                        //Se busca coincidencias del valor de filtro con cada valor de la lista original, para incluir en la lista filtrada
                            if(s.getName().toLowerCase().contains(charSequence.toString().toLowerCase()))
                            {
                                filterResultsData.add(data);
                            }
                        }
                    }

                    results.values = filterResultsData;
                    results.count = filterResultsData.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults)
            {
                filteredData = (ArrayList<Proveedor>)filterResults.values;
                activity.actualizarInfoFiltrado(filteredData.size());
                notifyDataSetChanged();
            }
        };
    }
}
