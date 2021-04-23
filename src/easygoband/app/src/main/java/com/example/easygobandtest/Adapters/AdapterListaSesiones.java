package com.example.easygobandtest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.easygobandtest.R;
import com.example.easygobandtest.Models.Session;

import java.util.ArrayList;

public class AdapterListaSesiones extends BaseAdapter {


    private Context context;
    private int layout;
    private ArrayList<Session> sessions;

    public AdapterListaSesiones(Context context, int layout, ArrayList<Session> sessions) {
        this.context = context;
        this.layout = layout;
        this.sessions = sessions;
    }

    @Override
    public int getCount() {
        return sessions.size();
    }

    @Override
    public Object getItem(int position) {
        return sessions.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        v= layoutInflater.inflate(R.layout.item_lista_sessions, null);

        // Valor actual según la posición
        Session session=sessions.get(position);

        String id = ""+session.getId();
        String session_name = session.getName();

        TextView item_session_id_txt = (TextView) v.findViewById(R.id.item_sessionID_txt);
        TextView item_session_name_txt = (TextView) v.findViewById(R.id.item_sessionName_txt);

        item_session_id_txt.setText(id);
        item_session_name_txt.setText(session_name);

        //Devolvemos la vista inflada
        return v;
    }
}
