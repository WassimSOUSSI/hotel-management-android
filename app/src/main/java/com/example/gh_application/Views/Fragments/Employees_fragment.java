package com.example.gh_application.Views.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.gh_application.Adapters.Employees_Adapter;
import com.example.gh_application.Adapters.Menu_Adapter;
import com.example.gh_application.Models.Employee_Model;
import com.example.gh_application.R;

import java.util.ArrayList;


public class Employees_fragment extends Fragment {

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_employees, container, false);

        Employee_Model employee_model;
        Employees_Adapter employees_adapter;
        RecyclerView recyclerView;
        ArrayList<Employee_Model> list;
        Menu_Adapter.SelectedMenu selectedMenu = (Menu_Adapter.SelectedMenu) view.getContext();

        employee_model=new Employee_Model();

        list=employee_model.getList();
        employees_adapter =new Employees_Adapter(view.getContext(),list);
        recyclerView=view.findViewById(R.id.employee_rcycler);
        recyclerView.setAdapter(employees_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(),1));

        ImageButton imageButton=view.findViewById(R.id.employees_imgAdd);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Redirect to add fragment
                selectedMenu.changeFragment(4);
            }
        });

        return view;
    }
}