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

import com.example.gh_application.Models.Employee_Model;

import com.example.gh_application.R;
import com.example.gh_application.Views.Dialogs.Employees_CRUD_dialog;


import java.util.ArrayList;

public class Employees_Adapter extends RecyclerView.Adapter<Employees_Adapter.Container> implements Employees_CRUD_dialog.DialogButtonClickListener_Emp {
    Context context;
    ArrayList<Employee_Model> list;

    public Employees_Adapter(Context context1,ArrayList<Employee_Model> list1){
        this.context=context1;
        this.list=list1;
    }

    @NonNull
    @Override
    public Employees_Adapter.Container onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_employees,parent,false);
        return new Container(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Employees_Adapter.Container holder, @SuppressLint("RecyclerView") int position) {
        holder.txtId.setText("Employee: "+String.valueOf(list.get(position).getId_Emp()));
        holder.txtNom.setText(list.get(position).getNom_Emp());
        holder.txtDpt.setText(list.get(position).getDepartement());
        holder.txtSalary.setText(String.valueOf(list.get(position).getSalary()));

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employees_CRUD_dialog customDialog = new Employees_CRUD_dialog(view.getContext(),Employees_Adapter.this);
                Employee_Model model=list.get(position);
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
        TextView txtId,txtNom,txtDpt,txtSalary;
        LinearLayout linearLayout;
        public Container(@NonNull View itemView) {
            super(itemView);
            txtId=itemView.findViewById(R.id.Employees_txt_id);
            txtNom=itemView.findViewById(R.id.Employees_txt_nom);
            txtDpt=itemView.findViewById(R.id.Employees_txt_Dept);
            txtSalary=itemView.findViewById(R.id.Employees_txt_Salary);
            linearLayout=itemView.findViewById(R.id.Employee_layout);

        }
    }


}
