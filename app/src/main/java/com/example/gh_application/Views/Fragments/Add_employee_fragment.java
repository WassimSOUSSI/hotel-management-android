package com.example.gh_application.Views.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gh_application.Controllers.Add_employee_controller;
import com.example.gh_application.Models.Employee_Model;
import com.example.gh_application.R;

import com.example.gh_application.Views.Dialogs.Add_succes_dialogE;

public class Add_employee_fragment extends Fragment {
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_employee, container, false);

        Add_employee_controller add_employee_controller=new Add_employee_controller();

        TextView txtNom,txtSal;
        txtNom=view.findViewById(R.id.Add_employee_ID);
        txtSal=view.findViewById(R.id.Add_employee_Sal);

        Button btn_Ajt;
        btn_Ajt=view.findViewById(R.id.Add_employee_btnAjouter);
        btn_Ajt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee_Model employee=new Employee_Model(10,txtNom.getText().toString(),"Dept",Double.valueOf(txtSal.getText().toString()));
                add_employee_controller.add_Employee(employee);
                Add_succes_dialogE dialog=new Add_succes_dialogE(view.getContext());
                dialog.showDialog();
            }
        });

        return view;
    }
}