package com.mokhles.winpharmacy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Traitement extends AppCompatActivity {
EditText edt1,edt2,edt3,edt4,edt5,edt6;
Spinner sp1,sp2,sp3,sp4,sp5,sp6;
Button btnValider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traitement);
    edt1=findViewById(R.id.editText);
    edt2=findViewById(R.id.editText2);
    edt3=findViewById(R.id.editText3);
    edt4=findViewById(R.id.editText4);
    edt5=findViewById(R.id.editText5);
    edt6=findViewById(R.id.editText6);
    sp1=findViewById(R.id.spinner);
    sp2=findViewById(R.id.spinner2);
    sp3=findViewById(R.id.spinner3);
    sp4=findViewById(R.id.spinner4);
    sp5=findViewById(R.id.spinner5);
    sp6=findViewById(R.id.spinner6);
    btnValider=findViewById(R.id.button);



        // Spinner Drop down elements
        List<String> heures = new ArrayList<String>();
        heures.add("Choisir heure");
        heures.add("1");
        heures.add("2");
        heures.add("3");
        heures.add("4");
        heures.add("5");
        heures.add("6");
        heures.add("8");
        heures.add("9");
        heures.add("10");
        heures.add("11");
        heures.add("12");
        heures.add("13");
        heures.add("14");
        heures.add("15");
        heures.add("16");
        heures.add("17");
        heures.add("18");
        heures.add("19");
        heures.add("20");
        heures.add("21");
        heures.add("22");
        heures.add("23");
        heures.add("00");



        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, heures);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sp1.setAdapter(dataAdapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //item = adapterView.getItemAtPosition(position).toString();
           //     index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); sp2.setAdapter(dataAdapter);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //item = adapterView.getItemAtPosition(position).toString();
           //     index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); sp3.setAdapter(dataAdapter);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //item = adapterView.getItemAtPosition(position).toString();
           //     index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); sp4.setAdapter(dataAdapter);
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //item = adapterView.getItemAtPosition(position).toString();
           //     index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); sp5.setAdapter(dataAdapter);
        sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //item = adapterView.getItemAtPosition(position).toString();
           //     index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }); sp6.setAdapter(dataAdapter);
        sp6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                //item = adapterView.getItemAtPosition(position).toString();
           //     index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }
}
