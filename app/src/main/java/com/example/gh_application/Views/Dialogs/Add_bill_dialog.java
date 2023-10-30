package com.example.gh_application.Views.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.gh_application.R;

public class Add_bill_dialog {
    private Context context;
    GradientDrawable drawable;
    Button btn_ajouter,btn_cancel;

    public Add_bill_dialog(Context context1){
        this.context = context1;
        //Dialog Design
        drawable= new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadius(50);
    }

    @SuppressLint("MissingInflatedId")
    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_add_bill, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(drawable);

        btn_ajouter=dialogView.findViewById(R.id.Add_bill_btnAjt);
        btn_ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add the bill plus notify the recycler
                Toast.makeText(dialogView.getContext(), "Add the bill plus notify the recycler", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        btn_cancel=dialogView.findViewById(R.id.Add_bill_btnCancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }


}
