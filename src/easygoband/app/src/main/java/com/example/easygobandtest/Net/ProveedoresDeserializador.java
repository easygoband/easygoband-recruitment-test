package com.example.easygobandtest.Net;

import com.example.easygobandtest.Models.Proveedor;
import com.example.easygobandtest.Models.Session;
import com.example.easygobandtest.Net.ProveedoresResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProveedoresDeserializador implements JsonDeserializer<ProveedoresResponse> {


    @Override
    public ProveedoresResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray proveedoresResponseData = json.getAsJsonArray();
        ProveedoresResponse proveedoresResponse = new ProveedoresResponse();
        proveedoresResponse.setProveedores(desearilizadorProveedores(proveedoresResponseData));
        return proveedoresResponse;
    }

    private ArrayList<Proveedor> desearilizadorProveedores(JsonArray provResponseData) {

        ArrayList<Proveedor> proveedoresList = new ArrayList<>();

        //Generamos cada objeto proveedor con la información obtenida del JSON
        for (int i = 0; i < provResponseData.size(); i++) {
            JsonObject jsonObject = provResponseData.get(i).getAsJsonObject();

            Proveedor proveedor = new Proveedor();

            proveedor.setAccess_group_name(jsonObject.get("access_group_name").getAsString());
            proveedor.setAccess_group_id(jsonObject.get("access_group_id").getAsInt());
            proveedor.setTotaluses(jsonObject.get("total_uses").getAsInt());
            proveedor.setEvent_id(jsonObject.get("event_id").getAsInt());
            proveedor.setStructure_decode(jsonObject.get("structure_decode").getAsBoolean());
            proveedor.setName(jsonObject.get("name").getAsString());
            proveedor.setModified(jsonObject.get("modified").getAsString());
            proveedor.setId(jsonObject.get("id").getAsInt());
            proveedor.setBasic_product_id(jsonObject.get("basic_product_id").getAsInt());
            //Lista de sessiones del proveedor
            ArrayList<Session> sessions= new ArrayList<Session>();
            for(JsonElement s: jsonObject.get("sessions").getAsJsonArray()){
                String name = s.getAsJsonObject().get("name").getAsString();
                int id = s.getAsJsonObject().get("id").getAsInt();

                Session session= new Session(id, name);
                sessions.add(session);
            }
            proveedor.setSessions(sessions);

            //Añadimos a lista de proveesores al proveedor obtenido
            proveedoresList.add(proveedor);
        }
        //Devuelve lista final con todos los objetos Proveedor
        return proveedoresList;

    }
}
