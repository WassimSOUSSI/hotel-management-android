package com.example.gh_application.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gh_application.Controllers.Reservation_controller;
import com.example.gh_application.Models.Reservation_Model;
import com.example.gh_application.R;
import com.example.gh_application.Views.Dialogs.Reserv_CRUD_dialog;

import java.util.ArrayList;

public class Resrvation_Adapter extends RecyclerView.Adapter<Resrvation_Adapter.Container> implements Reserv_CRUD_dialog.DialogButtonClickListener{
    Context context;
    ArrayList<Reservation_Model> list;

    public Resrvation_Adapter(Context context1,ArrayList<Reservation_Model> list1){
        this.context=context1;
        this.list=list1;
    }

    @NonNull
    @Override
    public Resrvation_Adapter.Container onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_reservation,parent,false);
        return new Container(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Resrvation_Adapter.Container holder, @SuppressLint("RecyclerView") int position) {
        holder.txtId.setText("Reservation: "+String.valueOf(list.get(position).getId_Res()));
        holder.txtStart.setText(list.get(position).getStart_Date().toString());
        holder.txtEnd.setText(list.get(position).getEnd_Date().toString());
        holder.txtNom.setText(list.get(position).getNom_Clt());
        holder.txtRoom.setText(String.valueOf(list.get(position).getId_R()));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reserv_CRUD_dialog customDialog = new Reserv_CRUD_dialog(view.getContext(),Resrvation_Adapter.this);
                Reservation_Model model=list.get(position);
                customDialog.showDialog(position,model);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onButtonClick() {
        notifyDataSetChanged();
    }



    public class Container extends RecyclerView.ViewHolder {
        TextView txtId,txtStart,txtEnd,txtNom,txtRoom;
        LinearLayout linearLayout;
        public Container(@NonNull View itemView) {
            super(itemView);
            txtId=itemView.findViewById(R.id.Reservation_txt_id);
            txtStart=itemView.findViewById(R.id.Reservation_txt_start);
            txtEnd=itemView.findViewById(R.id.Reservation_txt_end);
            txtNom=itemView.findViewById(R.id.Reservation_txt_nom);
            txtRoom=itemView.findViewById(R.id.Reservation_txt_idRoom);
            linearLayout=itemView.findViewById(R.id.Reservation_layout);

        }

    }


    public void setData(ArrayList<Reservation_Model> data) {
        list = data;
    }
}
