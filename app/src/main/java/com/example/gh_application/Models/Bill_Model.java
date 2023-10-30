package com.example.gh_application.Models;

import java.util.ArrayList;

public class Bill_Model {
    private int Ref;
    private String Description;
    private Double Montant;
    private Boolean Stat;

    public static ArrayList<Bill_Model> list;

    public Bill_Model(int ref, String description, Double montant, Boolean stat) {
        Ref = ref;
        Description = description;
        Montant = montant;
        Stat = stat;
    }
    public Bill_Model() {
        list=new ArrayList<Bill_Model>();
        list.add(new Bill_Model(1,"Description description decription",5000.0,false));
        list.add(new Bill_Model(2,"Description description decription",5000.0,true));
        list.add(new Bill_Model(3,"Description description decription",5000.0,false));
        list.add(new Bill_Model(4,"Description description decription",5000.0,true));
    }

    public int getRef() {
        return Ref;
    }

    public void setRef(int ref) {
        Ref = ref;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getMontant() {
        return Montant;
    }

    public void setMontant(Double montant) {
        Montant = montant;
    }

    public Boolean getStat() {
        return Stat;
    }

    public void setStat(Boolean stat) {
        Stat = stat;
    }

    public void changeState(int ref){
        list.get(ref).setStat(!this.Stat);
    }

    public ArrayList<Bill_Model> getList(){
        return this.list;
    }


    public void add_Item(Bill_Model model){
        list.add(model);
    }

    public void delete_Item(int ref){
        list.remove(ref);
    }

    public void modify_Item(){

    }
}
