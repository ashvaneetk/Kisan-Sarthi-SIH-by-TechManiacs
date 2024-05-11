package com.example.kisansarthi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View; // Needed for Button and TextView
import android.widget.Button; // Optional for Button (already in androidx.appcompat)
import android.widget.TextView; // Optional for TextView (already in androidx.appcompat)


public class SarthiActivity extends AppCompatActivity {

    private Button btnGoBack;
    private Button btnCommunity;
    private Button btnProfile;
    private TextView tvGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sarthi);  // Set the layout for this activity

        // Find views by their IDs
        btnGoBack = findViewById(R.id.btnGoBack);
        Button btnBlog = findViewById(R.id.btnBlog);
        btnCommunity = findViewById(R.id.btnCommunity);
        btnProfile = findViewById(R.id.btnProfile);
        tvGreeting = findViewById(R.id.tvGreeting);

        // Set click listeners for buttons
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SarthiActivity.this, FarmerActivity.class);
                startActivity(intent);
                // Handle "Go Back" button click (e.g., navigate back to previous screen)
                finish(); // For now, simply close the activity
            }
        });

        btnBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Blog" button click (e.g., navigate to blog section)
                // You can use Intents or Fragment transactions here
                // to switch between different activities or fragments
                // for displaying blog content
            }
        });

        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SarthiActivity.this, CommunityPageActivity.class);
                startActivity(intent);
                // Handle "Community" button click (e.g., navigate to community section)
                // You can use Intents or Fragment transactions here
                // to switch between different activities or fragments
                // for displaying community features
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Profile" button click (e.g., navigate to profile section)
                // You can use Intents or Fragment transactions here
                // to switch between different activities or fragments
                // for displaying user profile details
            }
        });
    }
}
