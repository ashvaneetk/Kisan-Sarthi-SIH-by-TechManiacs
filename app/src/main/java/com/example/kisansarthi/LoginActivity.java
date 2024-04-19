package com.example.kisansarthi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Import for logging
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast; // Import for toast messages

public class LoginActivity extends AppCompatActivity {

    private RadioGroup roleRadioGroup;
    private EditText emailEditText;
    private EditText passwordEditText;

    // Replace "expected_email" and "expected_password" with your actual credentials
    private final String expectedEmail = "expected_email@example.com";
    private final String expectedPassword = "your_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // Find views
        Button loginButton = findViewById(R.id.loginButton);
        roleRadioGroup = findViewById(R.id.roleRadioGroup2); // Corrected the ID here
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail = emailEditText.getText().toString().trim();
                String enteredPassword = passwordEditText.getText().toString().trim();

                // Check for empty fields
                if (enteredEmail.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (enteredPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validate email and password
                if (isValidLogin(enteredEmail, enteredPassword)) {
                    int selectedRoleId = roleRadioGroup.getCheckedRadioButtonId();

                    if (selectedRoleId == R.id.kisanRadioButton) {
                        Intent intent = new Intent(LoginActivity.this, FarmerActivity.class);
                        startActivity(intent);
                        finish(); // Optional: Close LoginActivity if you don't want it to be accessible after login
                    } else if (selectedRoleId == R.id.sarthiRadioButton) {
                        Intent intent = new Intent(LoginActivity.this, SarthiActivity.class);
                        startActivity(intent);
                        finish(); // Optional: Close LoginActivity if you don't want it to be accessible after login
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
                Log.d("LoginActivity", "Login button clicked!");
            }
        });
    }

    private boolean isValidLogin(String email, String password) {
        Log.d("LoginActivity", "Validating login...");
        // Replace with actual credential validation or a more secure method
        return email.equals(expectedEmail) && password.equals(expectedPassword);
    }
}
