package com.example.recyclerviewanimalexample;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

// https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
public class MainActivity extends AppCompatActivity {

    AnimalRecyclerViewAdapter adapter;

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
        adapter = new AnimalRecyclerViewAdapter(this, animals);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(new AnimalRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Animal animal) {
                Intent intent = new Intent(getBaseContext(), AnotherActivity.class);
                intent.putExtra(AnotherActivity.ANIMAL, animal);
                startActivity(intent);
            }
        });
    }
}