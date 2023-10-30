package com.example.gh_application.Views.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gh_application.Controllers.Reservation_controller;
import com.example.gh_application.Models.Reservation_Model;
import com.example.gh_application.R;
import com.example.gh_application.Views.Dialogs.Add_succes_dialog;
import com.example.gh_application.Views.Dialogs.Is_clt_dialog;


public class Add_reservation_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_reservation, container, false);
        Is_clt_dialog is_clt_dialog=new Is_clt_dialog(view.getContext());
        is_clt_dialog.showDialog();

        Reservation_controller reservation_controller =new Reservation_controller(view.getContext());

        TextView txt_start, txt_end;
        Spinner sp_Clt, sp_Room;
        Button btn_Reserver;

        txt_start=view.findViewById(R.id.Add_reservation_end);
        txt_end=view.findViewById(R.id.Add_reservation_start);
        sp_Clt=view.findViewById(R.id.Add_reservation_spClt);
        sp_Room=view.findViewById(R.id.Add_reservation_spRoom);

        btn_Reserver=view.findViewById(R.id.Add_reservation_btnReserver);
        btn_Reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add new reservation
                reservation_controller.addReservation("20/20/2020","20/20/2020","1",1);

                //Show the confirmation dialog
                Add_succes_dialog add_succes_dialog=new Add_succes_dialog(view.getContext());
                add_succes_dialog.showDialog();
            }
        });

        return view;
    }



}