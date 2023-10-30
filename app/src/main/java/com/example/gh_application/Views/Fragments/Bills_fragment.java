package com.example.gh_application.Views.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.gh_application.Adapters.Bill_Adapter;;
import com.example.gh_application.Adapters.Menu_Adapter;
import com.example.gh_application.Models.Bill_Model;
import com.example.gh_application.R;
import com.example.gh_application.Views.Dialogs.Add_bill_dialog;

import java.util.ArrayList;

public class Bills_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bills, container, false);

        Bill_Model bill_model;
        Bill_Adapter bill_adapter;
        RecyclerView recyclerView;
        ArrayList<Bill_Model> list;
        Menu_Adapter.SelectedMenu selectedMenu = (Menu_Adapter.SelectedMenu) view.getContext();


        bill_model=new Bill_Model();

        list=bill_model.getList();
        bill_adapter =new Bill_Adapter(view.getContext(),list);
        recyclerView=view.findViewById(R.id.bill_rcycler);
        recyclerView.setAdapter(bill_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(),1));

        ImageButton imageButton=view.findViewById(R.id.bill_imgAdd);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Redirect to add fragment
                Add_bill_dialog add_bill_dialog=new Add_bill_dialog(view.getContext());
                add_bill_dialog.showDialog();
            }
        });


        return view;
    }
}