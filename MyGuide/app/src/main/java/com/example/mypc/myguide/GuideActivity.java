package com.example.mypc.myguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mypc.myguide.adapter.GuideAdapter;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {

    private Toolbar toolbar;
    TextView textView;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] nameList, emailList, numberList;

    int[] image_id = {R.drawable.arjun, R.drawable.bijay, R.drawable.hari, R.drawable.himal, R.drawable.kapil,
            R.drawable.narayan, R.drawable.shyam, R.drawable.nabin, R.drawable.karan, R.drawable.kiran};

    ArrayList<GuideData> guideArray = new ArrayList<GuideData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        nameList = getResources().getStringArray(R.array.nameArray);
        emailList = getResources().getStringArray(R.array.emailArray);
        numberList = getResources().getStringArray(R.array.numberArray);

        int count = 0;

        for (String name : nameList) {
            GuideData gData = new GuideData(image_id[count], name, emailList[count], numberList[count]);
            count++;
            guideArray.add(gData);
        }

        recyclerView = (RecyclerView) findViewById(R.id.guideList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new GuideAdapter(guideArray, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_guide,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_find){
            startActivity(new Intent(this,Destination.class));
        }
        return super.onOptionsItemSelected(item);
    }


}
