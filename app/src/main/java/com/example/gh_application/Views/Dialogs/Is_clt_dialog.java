package com.example.gh_application.Views.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;


import com.example.gh_application.R;

public class Is_clt_dialog {
    private Context context;
    GradientDrawable drawable;
    Button btn_Oui, btn_Non;
    private OnInputListener mListener;

    public interface OnInputListener {
        void hideComponents();
        void hideSpinner();
    }


    public Is_clt_dialog(Context context1){
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
        View dialogView = inflater.inflate(R.layout.dialog_is_clt, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(drawable);

        btn_Non=dialogView.findViewById(R.id.Is_clt_btnNon);
        btn_Non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener=(OnInputListener)dialogView.getContext();
                mListener.hideSpinner();
                alertDialog.dismiss();
            }
        });

        btn_Oui=dialogView.findViewById(R.id.Is_clt_btnOui);
        btn_Oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show the Add Resrv fragment in the container
                mListener=(OnInputListener)dialogView.getContext();
                mListener.hideComponents();
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
