package com.example.gh_application.Views.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


import com.example.gh_application.Adapters.Menu_Adapter;
import com.example.gh_application.R;

public class Add_succes_dialog {
    private Context context;
    GradientDrawable drawable;
    Button btn_Ok;

    public Add_succes_dialog(Context context1){
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
        View dialogView = inflater.inflate(R.layout.dialog_add_succes, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(drawable);

        btn_Ok=dialogView.findViewById(R.id.Add_succes_btnOK);
        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu_Adapter.SelectedMenu selectedMenu = (Menu_Adapter.SelectedMenu) view.getContext();
                selectedMenu.changeFragment(0);
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
