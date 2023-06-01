package com.SmyJnd.safetynet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView loginRedirectText;
    Button login_button;
    EditText login_email, login_password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        login_button = findViewById(R.id.login_button);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        DB = new DBHelper(this);

        loginRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        login_button.setOnClickListener(view -> {
            String email = login_email.getText().toString();
            String password = login_password.getText().toString();

            if(email.equals("") || password.equals("")) {
                Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            }
            else {
                Boolean checkEmailPassword = DB.checkUserExists(email, password);
                if(checkEmailPassword) {
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
