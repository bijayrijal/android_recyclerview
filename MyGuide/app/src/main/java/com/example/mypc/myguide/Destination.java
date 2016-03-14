package com.example.mypc.myguide;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class Destination extends AppCompatActivity {
    private Toolbar toolbar;

    TextView textView;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] nameList, description;

    int[] image_id = {R.drawable.ktm, R.drawable.pokhara, R.drawable.bardiya, R.drawable.chitwan, R.drawable.annapurna,
            R.drawable.lumbini, R.drawable.janakpur};

    ArrayList<DestinationData> destArray = new ArrayList<DestinationData>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameList = getResources().getStringArray(R.array.destinationArray);
        description = getResources().getStringArray(R.array.descriptionArray);

        int count = 0;

        for (String name : nameList) {
            DestinationData dData = new DestinationData(image_id[count], name, description[count]);
            count++;
            destArray.add(dData);
        }

        recyclerView = (RecyclerView) findViewById(R.id.destination_id);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new DestinationAdapter(destArray, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_destination,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
