package com.example.landmarkagain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.landmarkagain.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);


       landmarkArrayList=new ArrayList<>();
        Landmark mykeTyson= new Landmark("Myke Tyson","United States of America",R.drawable.myke);
        Landmark paulPogba=new Landmark("Paul Pogba","France",R.drawable.pogba);
        Landmark bafetimbiGomis=new Landmark("Bafetimbi Gomis","France",R.drawable.gomis);
        landmarkArrayList.add(mykeTyson);
        landmarkArrayList.add(paulPogba);
        landmarkArrayList.add(bafetimbiGomis);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter= new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);

/*
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);
        
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
            intent.putExtra("landmark",landmarkArrayList.get(position));
            startActivity(intent);
            }
        });
*/

    }
}