package com.example.counterdiceroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.counterdiceroller.databinding.ActivityDiceRollerBinding;

public class DiceRollerActivity extends AppCompatActivity {
    private ActivityDiceRollerBinding binding;

//    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiceRollerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        toolbar = findViewById(R.id.toolbar2);
//        setSupportActionBar(toolbar);
//        toolbar.setTitleTextAppearance(this, R.style.titleTextFont);
        setSupportActionBar(binding.toolbar2);
        binding.toolbar2.setTitleTextAppearance(this, R.style.titleTextFont);

        binding.roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll();
            }
        });
    }

    private void roll() {
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        binding.progressBar.setVisibility(View.VISIBLE);
        int randomNum = (int) (Math.random() * range) + 1;

        switch (randomNum) {
            case 1:
                binding.diceNumber.setText("1");
                binding.diceImage.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                binding.diceNumber.setText("2");
                binding.diceImage.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                binding.diceNumber.setText("3");
                binding.diceImage.setImageResource(R.drawable.dice_six_faces_three);
                break;
            case 4:
                binding.diceNumber.setText("4");
                binding.diceImage.setImageResource(R.drawable.dice_six_faces_four);
                break;
            case 5:
                binding.diceNumber.setText("5");
                binding.diceImage.setImageResource(R.drawable.dice_six_faces_five);
                break;
            case 6:
                binding.diceNumber.setText("6");
                binding.diceImage.setImageResource(R.drawable.dice_six_faces_six);
                break;
        }

        binding.progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.counterIcon || item.getItemId() == R.id.menuCounter) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "COUNTER OPENED", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.restart) {
            binding.diceNumber.setText("1");
            binding.diceImage.setImageResource(R.drawable.dice_1);
        }
        return true;
    }
}
