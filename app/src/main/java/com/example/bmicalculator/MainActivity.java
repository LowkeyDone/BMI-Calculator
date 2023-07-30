package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result=findViewById(R.id.result);
        EditText weight=findViewById(R.id.editWeight);
        EditText heightFt=findViewById(R.id.editHeightFt);
        Button calculate=findViewById(R.id.button);
        EditText heightIn=findViewById(R.id.editHeightIn);
        LinearLayout main=findViewById(R.id.main);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(weight.getText().toString()); //normal get text takes input in editable form so first convert it into string and then parse it into integer
                int ft=Integer.parseInt(heightFt.getText().toString());
                int in=Integer.parseInt(heightIn.getText().toString());

                int totalin=ft*12+in;
                double cm=totalin*2.54;
                double ht=cm/100;

                double bmi=wt/(ht*ht);
                if(bmi<18.5) {
                    result.setText("You're underweight");
                    main.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else if (bmi > 25) {
                    result.setText("You're overweight");
                    main.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else {
                    result.setText("You're Healthy");
                    main.setBackgroundColor(getResources().getColor(R.color.green));
                }

            }
        });
    }
}