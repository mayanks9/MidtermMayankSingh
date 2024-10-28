package com.example.midtermmayanksingh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText sideInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure layout name matches activity_main.xml

        // Initialize Views
        sideInput = findViewById(R.id.sideInput);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);

        // Set up button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea(); // Ensures area calculation happens on button press
            }
        });
    }

    private void calculateArea() {
        String sideText = sideInput.getText().toString();
        if (sideText.isEmpty()) { // Checks if input is empty
            Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            double side = Double.parseDouble(sideText); // Parses side length input
            double area = side * side; // Calculates area
            resultText.setText("Area: " + area); // Displays result
        } catch (NumberFormatException e) { // Handles non-numeric input
            Toast.makeText(MainActivity.this, "Invalid input. Please enter a number.", Toast.LENGTH_SHORT).show();
        }
    }
}
