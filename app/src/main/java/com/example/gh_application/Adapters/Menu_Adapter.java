package com.example.gh_application.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gh_application.R;

import java.util.ArrayList;

public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.Container> {

    Context context;
    ArrayList<String> list;

    int selectedPos = RecyclerView.NO_POSITION; //-1

    SelectedMenu selectedMenu;

    public Menu_Adapter(Context context1,ArrayList<String> strings){
        this.context=context1;
        this.list=strings;
    }


    @NonNull
    @Override
    public Menu_Adapter.Container onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_menu,parent,false);
        return new Container(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Menu_Adapter.Container holder, @SuppressLint("RecyclerView") int position) {
        holder.txtMenu.setText(list.get(position).toString());
        int color = position == selectedPos ? Color.parseColor("#263238") : Color.parseColor("#80263238");
        holder.txtMenu.setTextColor(color);
        holder.txtMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, holder.txtMenu.getText().toString()+" "+position, Toast.LENGTH_SHORT).show();
                selectedPos = position;
                selectedMenu=(SelectedMenu)view.getContext();
                selectedMenu.changeFragment(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Container extends RecyclerView.ViewHolder{
        TextView txtMenu;

        public Container(@NonNull View itemView) {
            super(itemView);
            txtMenu=itemView.findViewById(R.id.menu_txt_rcycle);
        }
    }

    public interface SelectedMenu{
        public void changeFragment(int pos);
    }

}
