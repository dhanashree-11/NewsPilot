package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class CategoryScreen extends AppCompatActivity {

    CardView cardView1;
    CardView cardView2;
    CardView cardView3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_category_screen);

        cardView1 = (CardView) findViewById(R.id.CategoryCard1);
        cardView2 = (CardView) findViewById(R.id.CategoryCard2);
        cardView3 = (CardView) findViewById(R.id.CategoryCard3);
        button = (Button) findViewById(R.id.Custom);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsScreen.class);
                intent.putExtra("category", "business");
                intent.putExtra("country", "us");
                intent.putExtra("date", "2023-03-05");
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsScreen.class);
                intent.putExtra("category", "sports");
                intent.putExtra("country", "us");
                intent.putExtra("date", "2023-03-05");
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsScreen.class);
                intent.putExtra("category", "entertainment");
                intent.putExtra("country", "us");
                intent.putExtra("date", "2023-03-05");
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomCategory.class);
                startActivity(intent);
            }
        });

    }
}