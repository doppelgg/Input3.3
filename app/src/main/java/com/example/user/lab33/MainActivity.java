package com.example.user.lab33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textviewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner)findViewById(R.id.ageSpinner);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.maleRadioButton);
        radioButtonFemale = (RadioButton)findViewById(R.id.femaleRadioButton);
        checkBoxSmoker = (CheckBox)findViewById(R.id.smokerCheckBox);
        textviewPremium = (TextView)findViewById(R.id.premiumTextView);


        //set spinner dropdown value
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.age_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void CalculatePremium(View view)
    {
        int premiumCalculate = 0;
        int pos = 0;
        int idGender;
        boolean isSmoker;

        //calculate insurance premium

        pos = spinnerAge.getSelectedItemPosition();
        idGender = radioGroupGender.getCheckedRadioButtonId();
        isSmoker = checkBoxSmoker.isChecked();


        switch (pos)
        {
            case 0:
                premiumCalculate = 50;
                break;
            case 1:
                premiumCalculate = 55;
                break;
            case 2:
                premiumCalculate = 60;
                if(idGender == R.id.maleRadioButton)
                {
                    premiumCalculate += 50;
                }

                if(isSmoker)
                {
                    premiumCalculate += 100;
                }
                break;
            case 3:
                premiumCalculate = 70;
                if(idGender == R.id.maleRadioButton)
                {
                    premiumCalculate += 100;
                }
                if(isSmoker)
                {
                    premiumCalculate += 150;
                }

                break;
            case 4:
                premiumCalculate = 120;
               if(idGender == R.id.maleRadioButton)
                {
                    premiumCalculate += 100;
                }

                if(isSmoker)
                {
                    premiumCalculate += 150;
                }
                break;
            case 5:
                premiumCalculate = 160;
                if(idGender == R.id.maleRadioButton)
                {
                    premiumCalculate += 50;
                }

                if(isSmoker)
                {
                    premiumCalculate += 150;
                }
                break;
            case 6:
                premiumCalculate = 200;

                if(isSmoker)
                {
                    premiumCalculate += 250;
                }
                break;
            case 7:
                premiumCalculate = 250;

                if(isSmoker)
                {
                    premiumCalculate += 250;
                }
                break;

            default:
                break;
        }

        textviewPremium.setText(/*R.string.premium +*/ " RM " + premiumCalculate);
    }

    public void reset(View view)
    {
        textviewPremium.setText("Premium: ");
    }
}
