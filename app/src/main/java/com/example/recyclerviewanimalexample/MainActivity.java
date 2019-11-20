package com.example.recyclerviewanimalexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

// https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal(101, "Horse"));
        animals.add(new Animal(102, "Cow"));
        animals.add(new Animal(103, "Camel"));
        animals.add(new Animal(104, "Sheep"));
        animals.add(new Animal(105, "Goat"));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animals);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Animal animal = adapter.getItem(position);
        // Toast.makeText(this, "You clicked " + animal + " on row number " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AnotherActivity.class);
        intent.putExtra(AnotherActivity.ANIMAL, animal);
        startActivity(intent);
    }
}