package com.example.scanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView results = findViewById(R.id.results);
        Intent intent = getIntent();
        String warehouse = getIntent().getStringExtra("result");
        results.setText(warehouse);
        setTitle("Προιόντα στην αποθήκη");

    }
}
