package com.example.easygobandtest.Models;

import com.example.easygobandtest.Models.Session;

import java.io.Serializable;
import java.util.ArrayList;

public class Proveedor implements Serializable {

    private String access_group_name;
    private int access_group_id;
    private int totaluses;
    private ArrayList<Session> sessions;
    private int event_id;
    private boolean structure_decode;
    private String name;
    private String modified;
    private int id;
    private int basic_product_id;


    public String getAccess_group_name() {
        return access_group_name;
    }

    public void setAccess_group_name(String access_group_name) {
        this.access_group_name = access_group_name;
    }

    public int getAccess_group_id() {
        return access_group_id;
    }

    public void setAccess_group_id(int access_group_id) {
        this.access_group_id = access_group_id;
    }

    public int getTotaluses() {
        return totaluses;
    }

    public void setTotaluses(int totaluses) {
        this.totaluses = totaluses;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public boolean isStructure_decode() {
        return structure_decode;
    }

    public void setStructure_decode(boolean structure_decode) {
        this.structure_decode = structure_decode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBasic_product_id() {
        return basic_product_id;
    }

    public void setBasic_product_id(int basic_product_id) {
        this.basic_product_id = basic_product_id;
    }
}
