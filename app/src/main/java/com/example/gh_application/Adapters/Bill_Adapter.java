package com.example.gh_application.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gh_application.Models.Bill_Model;

import com.example.gh_application.R;


import java.util.ArrayList;

public class Bill_Adapter extends RecyclerView.Adapter<Bill_Adapter.Container> {
    Context context;
    ArrayList<Bill_Model> list;

    public Bill_Adapter(Context context1,ArrayList<Bill_Model> list1){
        this.context=context1;
        this.list=list1;
    }

    @NonNull
    @Override
    public Bill_Adapter.Container onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_bill,parent,false);
        return new Container(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Bill_Adapter.Container holder, @SuppressLint("RecyclerView") int position) {
        holder.txtRef.setText("Ref: "+String.valueOf(list.get(position).getRef()));
        holder.txtDesc.setText(list.get(position).getDescription());
        holder.txtPrice.setText(String.valueOf(list.get(position).getMontant()));
        if (list.get(position).getStat()==false){
            int color=Color.parseColor("#505050");
            holder.view.setBackgroundColor(color);
        }else {
            int color=Color.parseColor("#192125");
            holder.view.setBackgroundColor(color);
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(position).getStat()==Boolean.TRUE){
                    Toast.makeText(view.getContext(), "Facture marque comme etant non-paye", Toast.LENGTH_LONG).show();
                    list.get(position).changeState(position);
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(view.getContext(), "Facture marque comme etant paye", Toast.LENGTH_LONG).show();
                    list.get(position).changeState(position);
                    notifyDataSetChanged();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Container extends RecyclerView.ViewHolder {
        TextView txtRef,txtDesc,txtPrice;
        View view;
        LinearLayout linearLayout;
        public Container(@NonNull View itemView) {
            super(itemView);
            txtRef=itemView.findViewById(R.id.Bill_card_txtRef);
            txtDesc=itemView.findViewById(R.id.Bill_card_txtDesc);
            txtPrice=itemView.findViewById(R.id.Bill_card_txtPrice);
            view=itemView.findViewById(R.id.viewState);
            linearLayout=itemView.findViewById(R.id.Bill_layout);

        }
    }


}
