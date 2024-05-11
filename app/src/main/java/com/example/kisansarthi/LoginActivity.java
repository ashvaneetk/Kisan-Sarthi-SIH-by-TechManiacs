package com.example.kisansarthi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private RadioGroup roleRadioGroup;
    private EditText emailEditText;
    private EditText passwordEditText;

    // Replace "expected_email" and "expected_password" with your actual credentials
    public final String expectedEmail = "expected_email@example.com";
    public final String expectedPassword = "your_password";

    // Initialize intent outside conditional blocks
    Intent intent = null;  // Initialize with null

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // Find views
        Button loginButton = findViewById(R.id.loginButton);
        roleRadioGroup = findViewById(R.id.roleRadioGroup);
        emailEditText = findViewById(R.id.emailEditText); // Assuming you have an EditText for email
        passwordEditText = findViewById(R.id.passwordEditText); // Assuming you have an EditText for password

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
                        intent = new Intent(LoginActivity.this, FarmerActivity.class);
                    } else if (selectedRoleId == R.id.sarthiRadioButton) {  // Handle Sarthi login
                        intent = new Intent(LoginActivity.this, SarthiActivity.class);  // Assuming you have SarthiActivity
                    }

                    startActivity(intent);  // intent is now accessible here
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
                Log.d("LoginActivity", "Login button clicked!");
            }
        });
    }

    private boolean isValidLogin(String email, String password) {
        Log.d("LoginActivity", "Validating login..."); // Add logging for validation start
        // Replace with actual credential validation or a more secure method
        return email.equals(expectedEmail) && password.equals(expectedPassword);
    }
}
