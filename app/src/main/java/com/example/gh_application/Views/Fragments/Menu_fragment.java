package com.example.gh_application.Views.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gh_application.Adapters.Menu_Adapter;
import com.example.gh_application.Models.Menu_Model;
import com.example.gh_application.R;

import java.util.ArrayList;


public class Menu_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_menu, container, false);

        Menu_Adapter menu_adapter;
        ArrayList<String> list;
        RecyclerView recyclerView;
        Menu_Model menuModel;

        menuModel=Menu_Model.getInstance();
        list=menuModel.getMenu();
        recyclerView=view.findViewById(R.id.menu_rcycler);
        menu_adapter=new Menu_Adapter(this.getContext(),list);
        recyclerView.setAdapter(menu_adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));


        return view;
    }
}