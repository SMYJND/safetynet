package com.SmyJnd.safetynet;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        TextView aboutUsDescriptionTextView = findViewById(R.id.aboutUsDescriptionTextView);
        aboutUsDescriptionTextView.setText(R.string.aboutus_desc);

    }
}
