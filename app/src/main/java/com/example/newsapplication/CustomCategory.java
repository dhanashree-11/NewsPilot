package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustomCategory extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_category);

        editText1 = (EditText) findViewById(R.id.CountryInput);
        editText2 = (EditText) findViewById(R.id.CategoryInput);
        editText3 = (EditText) findViewById(R.id.FromDateInput);
        button = (Button) findViewById(R.id.SubmitBtn);

        String country,category,date;

        country = editText1.getText().toString();
        category = editText2.getText().toString();
        date = editText3.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewsScreen.class);
                intent.putExtra("country", ""+editText1.getText().toString());
                intent.putExtra("category", ""+editText2.getText().toString());
                intent.putExtra("date", ""+editText3.getText().toString());
                Log.d("checking", "onClick: "+editText1.getText().toString()+editText2.getText().toString()+editText3.getText().toString());
                startActivity(intent);
            }
        });
    }
}