package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText NumberInput;
    TextView resultTextView1, resultTextView2, resultTextView3;
    Spinner spinner;
    String number;
    ImageButton lengthbutton,temperaturebutton,weightbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthbutton = findViewById(R.id.lengthbutton);
        temperaturebutton = findViewById(R.id.temperaturebutton);
        weightbutton = findViewById(R.id.weightbutton);

        NumberInput = findViewById(R.id.NumberInput);
        resultTextView1 = findViewById(R.id.resultTextView1);
        resultTextView2 = findViewById(R.id.resultTextView2);
        resultTextView3 = findViewById(R.id.resultTextView3);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        lengthbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                try {
                    if (Objects.equals(number, "Metre")) {
                        double result1 = Double.parseDouble(NumberInput.getText().toString()) * 100;
                        BigDecimal r1 = new BigDecimal(result1);
                        resultTextView1.setText(r1.setScale(2, 4).doubleValue() + " cm");
                        double result2 = Double.parseDouble(NumberInput.getText().toString()) * 39.37;
                        BigDecimal r2 = new BigDecimal(result2);
                        resultTextView2.setText(r2.setScale(2, 4).doubleValue() + " inch");
                        double result3 = Double.parseDouble(NumberInput.getText().toString()) * 3.28;
                        BigDecimal r3 = new BigDecimal(result3);
                        resultTextView3.setText(r3.setScale(2, 4).doubleValue() + " foot");


                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        temperaturebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                try {
                    if(Objects.equals(number, "℃")) {
                        double result1 = Double.parseDouble(NumberInput.getText().toString()) * 33.8;
                        BigDecimal r1 = new BigDecimal(result1);
                        resultTextView1.setText(r1.setScale(2, 4).doubleValue() + " ℉");
                        double result2 = Double.parseDouble(NumberInput.getText().toString()) * 274.15;
                        BigDecimal r2 = new BigDecimal(result2);
                        resultTextView2.setText(r2.setScale(2, 4).doubleValue() + " K");
                        resultTextView3.setText("");
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        weightbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                try {
                    if(Objects.equals(number, "Kilogram")) {
                        double result1 = Double.parseDouble(NumberInput.getText().toString()) * 1000;
                        BigDecimal r1 = new BigDecimal(result1);
                        resultTextView1.setText(r1.setScale(2, 4).doubleValue() + "  gram");

                        double result2 = Double.parseDouble(NumberInput.getText().toString()) * 35.27;
                        BigDecimal r2 = new BigDecimal(result2);
                        resultTextView2.setText(r2.setScale(2, 4).doubleValue()+ "  ounce");

                        double result3 = Double.parseDouble(NumberInput.getText().toString()) * 2.20;
                        BigDecimal r3 = new BigDecimal(result3);
                        resultTextView3.setText(r3.setScale(2, 4).doubleValue() + "  pound");
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        number = parent.getItemAtPosition(position).toString();
    }


    public void onNothingSelected(AdapterView<?> parent) {

    }


}