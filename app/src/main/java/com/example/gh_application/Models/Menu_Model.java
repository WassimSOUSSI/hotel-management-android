package com.example.gh_application.Models;

import java.util.ArrayList;
import java.util.Arrays;


public class Menu_Model {
    private static Menu_Model instance;
    private ArrayList<String> menu;

    private Menu_Model(){
        menu=new ArrayList<>(Arrays.asList("Reservation","Emploiyees","Factures"));
    }

    public static Menu_Model getInstance(){
        if (instance==null){
            instance=new Menu_Model();
        }
        return instance;
    }

    public ArrayList<String> getMenu(){
        return menu;
    }
}
