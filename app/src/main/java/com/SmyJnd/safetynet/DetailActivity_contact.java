package com.SmyJnd.safetynet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.SmyJnd.safetynet.databinding.ActivityDetailContactBinding;

public class DetailActivity_contact extends AppCompatActivity {

    TextView detailTitle, detailNo;
    ImageView detailImage, location;
    Button button;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        detailTitle = findViewById(R.id.detailTitle);
        detailNo = findViewById(R.id.detailNo);
        detailImage = findViewById(R.id.detailImage);

         Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailTitle.setText(bundle.getString("Title"));
            detailImage.setImageResource(bundle.getInt("Image"));
            detailNo.setText(bundle.getString("Number"));
        }

//        Button btn= findViewById(R.id.btnLocation);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DetailActivity_contact.this, MapActivity.class);
//                startActivity(intent);
//
//            }
//        });
         button = findViewById(R.id.btnCall);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String Number = getIntent().getStringExtra("Number");
                 Intent intent = new Intent(Intent.ACTION_DIAL);
                 intent.setData(Uri.parse("tel:"+Number ));
                 startActivity(intent);
             }
         });

    }

}