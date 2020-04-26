package com.reflectwaresoftwares.cpncalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
   private EditText matric,inter,test;
    private TextView result;
    private Button calculate,reset;
    private ImageView toggle_btn;
    private LinearLayout layoutLand;
    private boolean isday=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UIintialize();

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCpn();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matric.setText("");
                inter.setText("");
                test.setText("");
                result.setText("Result");
            }
        });


////Switch to Dark or Light Mode Listner...
        toggle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                darkmode();  //// Dark Mode Switcher

            }
        });



    }

    private void UIintialize(){

        layoutLand= findViewById(R.id.main_layout_light_land);
        toggle_btn=(ImageView) findViewById(R.id.switcher_btn);
        matric=(EditText) findViewById(R.id.etmatric);
        inter=(EditText) findViewById(R.id.etinter);
        test=(EditText) findViewById(R.id.ettest);
        result=(TextView) findViewById(R.id.tvResult);
        reset=(Button) findViewById(R.id.btn_reset);
        calculate=(Button) findViewById(R.id.btn_calculate);
    }

    private void calculateCpn() {

        if (matric.getText().toString().trim().length() <= 0 || inter.getText().toString().trim().length() <= 0 || test.getText().toString().trim().length() <= 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter Correct Values of Marks ", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            double temp_matric, temp_inter, temp_test;

            temp_matric = Double.valueOf(matric.getText().toString());
            temp_inter = Double.valueOf(inter.getText().toString());
            temp_test = Double.valueOf(test.getText().toString());


            double res = (temp_matric * 0.1) + (temp_inter * 0.3) + (temp_test * 0.6);


            DecimalFormat format = new DecimalFormat("0.000");


            result.setText("Your CPN is :"+format.format(res));
        }

    }

    private void darkmode() {

        //// This Method Switch Dark Mode or Light Mode Settings...
        if (isday){
            layoutLand.setBackgroundResource(R.color.colorWhite);
            Toast.makeText(MainActivity.this,"Day Mode Enabled",Toast.LENGTH_SHORT).show();
            isday=false;
            toggle_btn.setImageDrawable(getResources().getDrawable(R.drawable.night));

        }else{

            layoutLand.setBackgroundResource(R.color.colorBlack);
            Toast.makeText(MainActivity.this,"Night Mode Enabled",Toast.LENGTH_SHORT).show();
            isday=true;
            toggle_btn.setImageDrawable(getResources().getDrawable(R.drawable.day));

        }

    }
}

/*
Designed and Developed By Ali Raza Abro
github: github.com/alirazaabro20
*/