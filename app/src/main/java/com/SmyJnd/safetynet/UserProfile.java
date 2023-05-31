package com.SmyJnd.safetynet;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {
    TextView userProfileName, userProfileAddress, userProfileEmail;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        userProfileName = findViewById(R.id.user_profile_name);
        userProfileAddress = findViewById(R.id.user_profile_address);
        userProfileEmail = findViewById(R.id.user_profile_email);
        DB = new DBHelper(this);

        String email = getIntent().getStringExtra("email");

        if (email != null) {
            String name = DB.getUserName(email);

            if (!name.isEmpty()) {
                userProfileName.setText(name);
                userProfileAddress.setText(DB.getUserAddress(email));
                userProfileEmail.setText(email);
            } else {
                // Handle the case when the user doesn't exist in the database
            }
        } else {
            // Handle the case when the email value is null
        }
    }
}
