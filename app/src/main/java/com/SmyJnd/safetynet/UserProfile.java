package com.SmyJnd.safetynet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {
    TextView user_profile_name, user_profile_address, user_profile_email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        user_profile_name = (TextView) findViewById(R.id.user_profile_name);
        user_profile_address = (TextView) findViewById(R.id.user_profile_address);
        user_profile_email = (TextView) findViewById(R.id.user_profile_email);
        Intent intent = getIntent();
        String email = getIntent().getStringExtra("email");
        user_profile_email.setText(email);
    }
    public void logoutUser(View view){

    }
}
