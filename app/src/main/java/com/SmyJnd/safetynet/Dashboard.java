package com.SmyJnd.safetynet;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {
    CardView contactCard;
    CardView first_aidCard;
    CardView heartCard;
    CardView aboutCard;
    ImageView UserProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        contactCard = findViewById(R.id.contactCard);
        first_aidCard = findViewById(R.id.first_aidCard);
        heartCard = findViewById(R.id.heartCard);
        aboutCard = findViewById(R.id.aboutCard);
        UserProfile = findViewById(R.id.userProfileIcon);

        contactCard.setOnClickListener(view -> {
            Intent intent = new Intent(Dashboard.this, Contact_listActivity.class);
            startActivity(intent);
        });
        first_aidCard.setOnClickListener(view -> {
            Intent intent = new Intent(Dashboard.this, FirstAid.class);
            startActivity(intent);
        });
        heartCard.setOnClickListener(view -> {
            Intent intent = new Intent(Dashboard.this, HeartMonitorActivity.class);
            startActivity(intent);
        });
        aboutCard.setOnClickListener(view -> {
            Intent intent = new Intent(Dashboard.this, AboutUsActivity.class);
            startActivity(intent);
        });
        UserProfile.setOnClickListener(view ->{
           Intent intent = new Intent(Dashboard.this, UserProfile.class);
           startActivity(intent);
        });

        }
            }
