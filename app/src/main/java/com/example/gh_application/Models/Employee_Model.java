package com.example.gh_application.Models;

import java.util.ArrayList;

public class Employee_Model {
    private int Id_Emp;
    private String Nom_Emp;
    private String Departement;
    private double Salary;

    static ArrayList<Employee_Model> list;

    public Employee_Model() {
        list=new ArrayList<Employee_Model>();

        list.add(new Employee_Model(1,"Nom","Departement",5000));
        list.add(new Employee_Model(1,"Nom","Departement",5000));
        list.add(new Employee_Model(1,"Nom","Departement",5000));
        list.add(new Employee_Model(1,"Nom","Departement",5000));

    }

    public Employee_Model(int id_Emp, String nom_Emp, String departement, double salary) {
        Id_Emp = id_Emp;
        Nom_Emp = nom_Emp;
        Departement = departement;
        Salary = salary;
    }

    public int getId_Emp() {
        return Id_Emp;
    }

    public void setId_Emp(int id_Emp) {
        Id_Emp = id_Emp;
    }

    public String getNom_Emp() {
        return Nom_Emp;
    }

    public void setNom_Emp(String nom_Emp) {
        Nom_Emp = nom_Emp;
    }

    public String getDepartement() {
        return Departement;
    }

    public void setDepartement(String departement) {
        Departement = departement;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public ArrayList<Employee_Model> getList(){
        return this.list;
    }

    public static void delete_Item(int id){
        list.remove(id);
    }
    public static void modify_Item(int id,Employee_Model model){
        list.get(id).setNom_Emp(model.getNom_Emp());
        list.get(id).setNom_Emp(model.getNom_Emp());
        list.get(id).setDepartement(model.getDepartement());
        list.get(id).setSalary(model.getSalary());
    }

    public static void add_Item(Employee_Model model){
        list.add(model);
    }
}
