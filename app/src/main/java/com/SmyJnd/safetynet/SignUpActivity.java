package com.SmyJnd.safetynet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    TextView signupRedirectText;
    Button signup_button;
    EditText signup_name, signup_address, signup_email, signup_password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupRedirectText = findViewById(R.id.signupRedirectText);
        signup_button = findViewById(R.id.signup_button);
        DB = new DBHelper(this);

        signupRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        signup_name = findViewById(R.id.signup_name);
        signup_address = findViewById(R.id.signup_address);
        signup_email = findViewById(R.id.signup_email);
        signup_password = findViewById(R.id.signup_password);

        signup_button.setOnClickListener(view -> {
            String name = signup_name.getText().toString();
            String address = signup_address.getText().toString();
            String email = signup_email.getText().toString();
            String password = signup_password.getText().toString();


            if (name.equals("") || address.equals("") || email.equals("") || password.equals("")) {
                Toast.makeText(SignUpActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else if (DB.checkEmailExists(email)) {
                Toast.makeText(SignUpActivity.this, "Email already exists", Toast.LENGTH_SHORT).show();
            } else if (DB.checkNameAndAddressExists(name, address)) {
                Toast.makeText(SignUpActivity.this, "Name and address already exists", Toast.LENGTH_SHORT).show();
            } else {
                boolean success = DB.insertData(name, address, email, password);
                if (success) {
                    Toast.makeText(SignUpActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, Dashboard.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
