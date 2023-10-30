package com.example.gh_application.Views.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gh_application.Controllers.CRUD_dialog_controller_Emp;
import com.example.gh_application.Models.Employee_Model;
import com.example.gh_application.R;

public class Employees_CRUD_dialog {
    public interface DialogButtonClickListener_Emp {
        void onButtonClick();
    }

    private DialogButtonClickListener_Emp listener;
    CRUD_dialog_controller_Emp CRUDdialogcontroller;
    private Context context;
    GradientDrawable drawable;
    Button btn_Modify, btn_Delete, btn_Cancel;

    public Employees_CRUD_dialog(Context context, DialogButtonClickListener_Emp listener1) {
        CRUDdialogcontroller =new CRUD_dialog_controller_Emp();
        this.context = context;
        //Dialog Design
        drawable= new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadius(50);
        listener=listener1;
    }

    public void showDialog(int item, Employee_Model model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_employee_crud, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(drawable);

        TextView txt_title, txt_id,txt_nom, txt_dept, txt_salary;
        txt_title=dialogView.findViewById(R.id.Employee_CRUD_Title);
        txt_id=dialogView.findViewById(R.id.Employee_CRUD_IdEmp);
        txt_nom=dialogView.findViewById(R.id.Employee_CRUD_Nom);
        txt_dept=dialogView.findViewById(R.id.Employee_CRUD_Departement);
        txt_salary=dialogView.findViewById(R.id.Employee_CRUD_Salary);

        txt_title.setText("ID_Employee: "+String.valueOf(model.getId_Emp()));
        txt_id.setText(String.valueOf(model.getId_Emp()));
        txt_nom.setText(model.getNom_Emp());
        txt_dept.setText(model.getDepartement());
        txt_salary.setText(String.valueOf(model.getSalary()));



        btn_Cancel=dialogView.findViewById(R.id.Employee_CRUD_Cancel);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        btn_Delete =dialogView.findViewById(R.id.Employee_CRUD_Delete);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDdialogcontroller.deleteEmployee(item);
                if (listener != null) {
                    listener.onButtonClick();
                }
                alertDialog.dismiss();


            }
        });

        btn_Modify=dialogView.findViewById(R.id.Employee_CRUD_Modify);
        btn_Modify.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onClick(View view) {
                TextView txt_title, txt_id,txt_nom, txt_dept, txt_salary;

                txt_title=dialogView.findViewById(R.id.Employee_CRUD_IdEmp);
                txt_id=dialogView.findViewById(R.id.Employee_CRUD_IdEmp);
                txt_nom=dialogView.findViewById(R.id.Employee_CRUD_Nom);
                txt_dept=dialogView.findViewById(R.id.Employee_CRUD_Departement);
                txt_salary=dialogView.findViewById(R.id.Employee_CRUD_Salary);

                if (txt_id != null && txt_nom != null && txt_dept != null && txt_salary!=null){
                    Employee_Model employee_model=new Employee_Model(model.getId_Emp(),
                            txt_nom.getText().toString(),txt_dept.getText().toString(),
                            Double.parseDouble(txt_salary.getText().toString()));

                    CRUDdialogcontroller.modifyEmployee(item,employee_model);
                    if (listener != null) {
                        listener.onButtonClick();
                    }
                    alertDialog.dismiss();}
            }
        });

        alertDialog.show();
    }

}
