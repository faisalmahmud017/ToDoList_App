package com.example.todolist_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView ic_AddList;
    public ArrayList<ListAdapter> listAdapters;
    private ArrayList<ModelList> modelListArrayList;
    ListAdapter listAdapter;
    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = (RecyclerView) findViewById(R.id.rv_list);

        modelListArrayList = new ArrayList<>();



        ic_AddList = findViewById(R.id.ic_addList);
        ic_AddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialogAddList = new Dialog(MainActivity.this);

                dialogAddList.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogAddList.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogAddList.setContentView(R.layout.add_list);
                dialogAddList.setCancelable(true);

                dialogAddList.show();
                TextView txt_addList = dialogAddList.findViewById(R.id.txt_addList);

                ImageView ic_cancel = dialogAddList.findViewById(R.id.ic_cancel_dialog);
                ic_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogAddList.dismiss();
                    }
                });


                Button btn_addList = dialogAddList.findViewById(R.id.btn_addList);
                btn_addList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ModelList modelList = new ModelList(
                                txt_addList.getText().toString()
                        );
                        modelListArrayList.add(modelList);
                        listAdapter.notifyDataSetChanged();
                        dialogAddList.dismiss();
                    }


                });
                
                Button btn_clear = dialogAddList.findViewById(R.id.btn_clear);
                btn_clear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txt_addList.setText("");
                    }
                });
                
            }
        });

        rvList.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
        listAdapter = new ListAdapter(this, modelListArrayList);
        rvList.setAdapter(listAdapter);
        rvList.setHasFixedSize(true);

    }
}