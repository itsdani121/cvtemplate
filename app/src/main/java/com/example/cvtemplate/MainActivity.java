package com.example.cvtemplate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements recycleItemCLick,popupAdapt{

    private static final String TAG = "MainActivity";
    private List<details> newDetail = new ArrayList<>();
    private RecyclerView recyclerView;
    private myAdapt adapt;

    private ItemTouchHelper.SimpleCallback TouchHelper = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override

        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            int position = viewHolder.getAdapterPosition();

            if (direction == ItemTouchHelper.LEFT) {
                newDetail.remove(position);
                adapt.notifyItemRemoved(position);
                Snackbar snackbar = Snackbar.make(recyclerView, "item at position" + position + "is removed", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNdo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "item moved", Toast.LENGTH_SHORT).show();
                    }

                });
                snackbar.show();
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview11);

recycleAdapt();


    }

    private void recycleAdapt() {
        recyclerView.setHasFixedSize(true);
        details myDetails1 = new details(R.drawable.cute, 24, "Adnan", "google/res");
        details myDetails2 = new details(R.drawable.ic_launcher_foreground, 32, "home", "res/home");
        details myDetails3 = new details(R.drawable.ic_person_black_24dp, 12, "work", "res/string/depost");
        details myDetails4 = new details(R.drawable.ic_room_service_black_24dp, 16, "outside", "C/home/outside");
        details myDetails5 = new details(R.drawable.ic_user, 20, "pool", "C/file/pool");


        newDetail.add(myDetails1);
        newDetail.add(myDetails2);
        newDetail.add(myDetails3);
        newDetail.add(myDetails4);
        newDetail.add(myDetails5);
        adapt = new myAdapt(this, newDetail,this,this);
        recyclerView.setAdapter(adapt);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(TouchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);


    }


    public void onItemSingleClicked(Object obj, int position) {
        details Details = (details) obj;
        Toast.makeText(MainActivity.this, "Item Clicked on Position" + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onActionDeleteClicked(Object obj, int position) {

    }

    @Override
    public void onActionArchiveClicked(Object obj, int position) {

    }
}
