package com.example.gh_application.Views.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gh_application.Controllers.CRUD_dialog_controller;
import com.example.gh_application.Models.Reservation_Model;
import com.example.gh_application.R;

public class Reserv_CRUD_dialog {
    public interface DialogButtonClickListener {
        void onButtonClick();
    }

    private DialogButtonClickListener listener;
    CRUD_dialog_controller CRUDdialogcontroller;
    private Context context;
    GradientDrawable drawable;
    Button btn_Modify, btn_Delete, btn_Cancel;

    public Reserv_CRUD_dialog(Context context, DialogButtonClickListener listener1) {
        CRUDdialogcontroller =new CRUD_dialog_controller();
        this.context = context;
        //Dialog Design
        drawable= new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadius(50);
        listener=listener1;
    }

    public void showDialog(int item,Reservation_Model model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_reservation_crud, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(drawable);

        TextView txt_id, txt_clt,txt_start, txt_end, txt_room;
        txt_id=dialogView.findViewById(R.id.Reserv_CRUD_IdReser);
        txt_clt=dialogView.findViewById(R.id.Reserv_CRUD_Clt);
        txt_start=dialogView.findViewById(R.id.Reserv_CRUD_Start);
        txt_end=dialogView.findViewById(R.id.Reserv_CRUD_End);
        txt_room=dialogView.findViewById(R.id.Reserv_CRUD_Room);

        txt_id.setText("ID_Resrv: "+String.valueOf(model.getId_Res()));
        txt_clt.setText(model.getNom_Clt());
        txt_start.setText(model.getStart_Date());
        txt_end.setText(model.getEnd_Date());
        txt_room.setText(String.valueOf(model.getId_R()));



        btn_Cancel=dialogView.findViewById(R.id.Add_bill_btnCancel);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        btn_Delete =dialogView.findViewById(R.id.Add_bill_btnAjt);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDdialogcontroller.deleteReservation(item);
                if (listener != null) {
                    listener.onButtonClick();
                }
                alertDialog.dismiss();


            }
        });

        btn_Modify=dialogView.findViewById(R.id.Reserv_CRUD_Modify);
        btn_Modify.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onClick(View view) {
                TextView txt_id, txt_clt,txt_start, txt_end, txt_room;

                txt_id=dialogView.findViewById(R.id.Reserv_CRUD_IdReser);
                txt_clt=dialogView.findViewById(R.id.Reserv_CRUD_Clt);
                txt_start=dialogView.findViewById(R.id.Reserv_CRUD_Start);
                txt_end=dialogView.findViewById(R.id.Reserv_CRUD_End);
                txt_room=dialogView.findViewById(R.id.Reserv_CRUD_Room);

                if (txt_start != null && txt_end != null && txt_room != null){
                Reservation_Model reservationModel=new Reservation_Model(model.getId_Res(),
                        txt_start.getText().toString(),txt_end.getText().toString(),txt_clt.getText().toString(),
                        Integer.parseInt(txt_room.getText().toString()));

                CRUDdialogcontroller.modifyReservation(item,reservationModel);
                if (listener != null) {
                    listener.onButtonClick();
                }
                alertDialog.dismiss();}
            }
        });

        alertDialog.show();
    }

}
