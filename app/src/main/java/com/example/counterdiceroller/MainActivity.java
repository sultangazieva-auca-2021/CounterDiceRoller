package com.example.counterdiceroller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.counterdiceroller.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding.toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        binding.toolbar.setTitleTextAppearance(this, R.style.titleTextFont);

        binding.incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });

        binding.randomColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomColor();
            }
        });

        binding.switchVis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchVis();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.diceRoll || item.getItemId() == R.id.dice) {
            Intent intent = new Intent(getBaseContext(), MainActivity2.class);
            startActivity(intent);
            Toast.makeText(this, "DICE ROLLER OPENED", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.restart) {
            binding.counter.setText("0");
            binding.counter.setTextColor(Color.BLACK);
            binding.counter.setVisibility(View.VISIBLE);
            Toast.makeText(this, "RESTART", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private void increment() {
        int counter = Integer.parseInt(binding.counter.getText().toString());
        counter++;
        binding.counter.setText(String.valueOf(counter));
    }

    private void randomColor() {
        Random rand = new Random();
        int randomColor = Color.rgb(
                rand.nextInt(256),
                rand.nextInt(256),
                rand.nextInt(256)
        );

        binding.counter.setTextColor(randomColor);
    }

    private void switchVis() {
        if (binding.counter.getVisibility() == View.VISIBLE) {
            binding.counter.setVisibility(View.INVISIBLE);
        } else {
            binding.counter.setVisibility(View.VISIBLE);
        }
    }
}
