package com.example.gh_application.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.LinearLayout;


import com.example.gh_application.Adapters.Menu_Adapter;
import com.example.gh_application.R;
import com.example.gh_application.Views.Dialogs.Is_clt_dialog;
import com.example.gh_application.Views.Fragments.Add_employee_fragment;
import com.example.gh_application.Views.Fragments.Add_reservation_fragment;
import com.example.gh_application.Views.Fragments.Bills_fragment;
import com.example.gh_application.Views.Fragments.Employees_fragment;
import com.example.gh_application.Views.Fragments.Reservation_fragment;
import com.example.gh_application.Views.Fragments.Menu_fragment;

public class Home_Activity extends AppCompatActivity implements Menu_Adapter.SelectedMenu,Is_clt_dialog.OnInputListener {

    public static final int RESERVATION_LIST=0;
    public static final int EMPLOYEES_LIST=1;

    public static final int BILLS_LIST=2;
    public static final int ADD_RESERVATION=3;
    public static final int ADD_EMPLOYEE=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.Menu,new Menu_fragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Reservation_fragment()).commit();
    }

    @Override
    public void changeFragment(int pos) {
        if (pos==RESERVATION_LIST){
            getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Reservation_fragment()).commit();
        }else if (pos==EMPLOYEES_LIST) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Employees_fragment()).commit();
        }else if (pos==ADD_RESERVATION) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Add_reservation_fragment()).commit();
        }else if (pos==ADD_EMPLOYEE) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Add_employee_fragment()).commit();
        }else if (pos==BILLS_LIST) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Container,new Bills_fragment()).commit();
        }
    }

    @Override
    public void hideComponents() {
            LinearLayout linearLayout=findViewById(R.id.linear_Client);
            linearLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideSpinner() {
        LinearLayout linearLayout=findViewById(R.id.linear_SpClt);
        linearLayout.setVisibility(View.GONE);
    }
}