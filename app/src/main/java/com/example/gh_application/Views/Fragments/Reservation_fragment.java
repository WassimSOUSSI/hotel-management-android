package com.example.gh_application.Views.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gh_application.Adapters.Menu_Adapter;
import com.example.gh_application.Adapters.Resrvation_Adapter;
import com.example.gh_application.Controllers.Reservation_controller;
import com.example.gh_application.Models.Reservation_Model;
import com.example.gh_application.R;

import java.text.ParseException;
import java.util.ArrayList;


public class Reservation_fragment extends Fragment  {

    public static Resrvation_Adapter resrvation_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reservation, container, false);


        Reservation_controller reservation_controller;
        reservation_controller=new Reservation_controller(view.getContext());
        reservation_controller.selectReservations();
        Reservation_Model reservation_model;

        RecyclerView recyclerView;
        ArrayList<Reservation_Model> list;
        Menu_Adapter.SelectedMenu selectedMenu = (Menu_Adapter.SelectedMenu) view.getContext();


        try {
            reservation_model=new Reservation_Model();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //list=reservation_model.getList();

        list=new ArrayList<Reservation_Model>();
        list=reservation_controller.getReservations();
        resrvation_adapter =new Resrvation_Adapter(view.getContext(),list);

        recyclerView=view.findViewById(R.id.reservation_rcycler);
        recyclerView.setAdapter(resrvation_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(inflater.getContext(),1));
        ImageButton imageButton=view.findViewById(R.id.reservation_imgAdd);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Redirect to add fragment
                selectedMenu.changeFragment(3);
            }
        });

        return view;
    }



}