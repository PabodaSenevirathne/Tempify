package com.example.pabodaassignment1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Toast;

import com.example.pabodaassignment1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // onClick listener for the button that converts to Celsius
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToCelsius();
            }
        });

        // onClick listener for the button that converts to Fahrenheit
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertToFahrenheit();
            }
        });

    }

    // convert to celsius
    private void convertToCelsius() {
        String input = binding.editTextNumber2.getText().toString();
        if (inputValidation(input)) {
            double fahrenheit = Double.parseDouble(input);
            double celsius = (fahrenheit - 32) * 5 / 9;
            binding.textView2.setText(String.format("%.2f °C", celsius));
        }
    }

    // convert to Fahrenheit
    private void convertToFahrenheit() {
        String input = binding.editTextNumber2.getText().toString();
        if (inputValidation(input)) {
            double celsius = Double.parseDouble(input);
            double fahrenheit = (celsius * 9 / 5) + 32;
            binding.textView2.setText(String.format("%.2f °F", fahrenheit));
        }
    }


    // validate the input of user
    private boolean inputValidation(String input) {
        // validate numeric numbers
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            double value = Double.parseDouble(input);
            // ensure a valid temperature range
            if (value < -273.15) {
                Toast.makeText(this, "Temperature cannot be below -273.15 °C)", Toast.LENGTH_SHORT).show();
                return false;
            } else if (value > 500) {
                Toast.makeText(this, "Please enter a temperature not exceeding 500 °C", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}