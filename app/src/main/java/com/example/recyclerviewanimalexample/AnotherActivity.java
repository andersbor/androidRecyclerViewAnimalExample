package com.example.recyclerviewanimalexample;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    public static final String ANIMAL = "animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anoter);

        Intent intent = getIntent();
        Animal animal = (Animal)intent.getSerializableExtra(ANIMAL);
        TextView animalView = findViewById(R.id.anotherAnimalTextView);
        animalView.setText(animal.toString());

    }
}
