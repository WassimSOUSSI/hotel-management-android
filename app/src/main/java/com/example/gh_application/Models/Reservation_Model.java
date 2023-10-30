package com.example.gh_application.Models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Reservation_Model {
    private int Id_Res;
    private String Start_Date;
    private String End_Date;
    private String Nom_Clt;
    private int Id_R;

    static ArrayList<Reservation_Model> list;

    public Reservation_Model(int id_Res, String start_Date, String end_Date, String nom_Clt, int id_R) {
        Id_Res = id_Res;
        Start_Date = start_Date;
        End_Date = end_Date;
        Nom_Clt = nom_Clt;
        Id_R = id_R;
    }
    public Reservation_Model() throws ParseException {
        list=new ArrayList<Reservation_Model>();
        String startDate = formatDate(setDate("20/2/2022"));
        String endDate = formatDate(setDate("20/04/2022"));
        list.add(new Reservation_Model(1, startDate, endDate, "Wassim", 101));
        list.add(new Reservation_Model(2, startDate, endDate, "Wassim", 101));
        list.add(new Reservation_Model(3, startDate, endDate, "Wassim", 101));
        list.add(new Reservation_Model(4, startDate, endDate, "Wassim", 101));
    }

    public int getId_Res() {
        return Id_Res;
    }

    public void setId_Res(int id_Res) {
        Id_Res = id_Res;
    }

    public String getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(String start_Date) {
        Start_Date = start_Date;
    }

    public String getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(String end_Date) {
        End_Date = end_Date;
    }

    public String getNom_Clt() {
        return Nom_Clt;
    }

    public void setNom_Clt(String nom_Clt) {
        Nom_Clt = nom_Clt;
    }

    public int getId_R() {
        return Id_R;
    }

    public void setId_R(int id_R) {
        Id_R = id_R;
    }

    private Date setDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(dateString);
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public ArrayList<Reservation_Model> getList(){
        return this.list;
    }

    public static void delete_Item(int id){
        list.remove(id);
    }
    public static void modify_Item(int id,Reservation_Model model){
        list.get(id).setNom_Clt(model.getNom_Clt());
        list.get(id).setStart_Date(model.getStart_Date());
        list.get(id).setEnd_Date(model.getEnd_Date());
        list.get(id).setId_R(model.getId_R());
    }

    public static void add_Item(Reservation_Model model){
        list.add(model);
    }

}
