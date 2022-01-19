package com.example.todolist_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context context;
    private ArrayList<ModelList> modelListArrayList;

    public ListAdapter(Context context, ArrayList<ModelList> modelListArrayList) {
        this.context = context;
        this.modelListArrayList = modelListArrayList;

    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_list, parent, false);
        return new ListViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        ModelList model = modelListArrayList.get(position);

        holder.txt_daftar.setText(model.getDaftar());

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelListArrayList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelListArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        public Button btn_delete;
        public TextView txt_daftar;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_daftar = itemView.findViewById(R.id.txt_daftar);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
