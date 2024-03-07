package com.example.kisansarthi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LoginActivity extends AppCompatActivity {

    private RadioGroup roleRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        // Find views
        Button loginButton = findViewById(R.id.loginButton);
        roleRadioGroup = findViewById(R.id.roleRadioGroup);

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get selected role
                int selectedRoleId = roleRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRoleButton = findViewById(selectedRoleId);
                String selectedRole = selectedRoleButton.getText().toString();

                // Check selected role and navigate accordingly
                if (selectedRole.equals("Kisan")) {
                    Intent intent = new Intent(LoginActivity.this, FarmerActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Close LoginActivity if you don't want it to be accessible after login
                } else if (selectedRole.equals("Sarthi")) {
                    Intent intent = new Intent(LoginActivity.this, SarthiActivity.class);
                    startActivity(intent);
                    finish(); // Optional: Close LoginActivity if you don't want it to be accessible after login
                }
            }
        });
    }
}
