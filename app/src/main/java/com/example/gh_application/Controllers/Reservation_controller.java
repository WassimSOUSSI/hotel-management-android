package com.example.gh_application.Controllers;



import android.content.Context;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.gh_application.Adapters.Resrvation_Adapter;
import com.example.gh_application.Models.Reservation_Model;
import com.android.volley.toolbox.Volley;
import com.example.gh_application.Views.Fragments.Reservation_fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reservation_controller {

    private Context context;
    private ArrayList<Reservation_Model> reservations;

    public Reservation_controller(Context context) {
        this.context = context;
        this.reservations=new ArrayList<Reservation_Model>();
    }
    public Reservation_controller(){}

    public void selectClient(){

    }

    public void selectReservations(){
        //Volley code
        String url="http://192.168.43.210:8008/script_gh/select_reservations.php";
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        JsonArrayRequest request= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject object=response.getJSONObject(i);
                        int id=object.getInt("Id_Res");
                        String start= object.getString("Start_Date");
                        String end= object.getString("End_Date");
                        String clt=object.getString("Full_Name");
                        int room=object.getInt("Id_R");
                        reservations.add(new Reservation_Model(id,start,end,clt,room));
                        Reservation_fragment.resrvation_adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }

    public void addReservation(String start,String end,String clt,int room){
        String url="http://192.168.43.210:8008/script_gh/add_reservation.php";
        RequestQueue requestQueue=Volley.newRequestQueue(context);
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, null){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parms=new HashMap<String,String>();
                parms.put("start",start);
                parms.put("end",end);
                parms.put("clt",clt);
                parms.put("room", String.valueOf(room).toString());
                return parms;
            }
        };
        requestQueue.add(request);
    }

    public ArrayList<Reservation_Model> getReservations(){
        return this.reservations;
    }



}
