package com.example.ex4;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    public final static String DATA = "data";


    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        EditText t1 = findViewById(R.id.t1);
        EditText t2 = findViewById(R.id.t2);
        radioGroup= findViewById(R.id.radioGroup);

        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean valid = (t1.getText().length()!=0 && t2.getText().length()!=0);
                button.setEnabled(valid);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        t1.addTextChangedListener(tw);
        t2.addTextChangedListener(tw);

        button.setOnClickListener(view-> {
            int number1 = Integer.parseInt(t1.getText().toString());
            int number2 = Integer.parseInt(t2.getText().toString());
            CustomData.Mode mode = getMode();
            CustomData customData = new CustomData(number1,number2,mode);

            Intent i = new Intent(this, SecondActivitys.class);
            i.putExtra(DATA, customData);
            startActivity(i);
        });
    }

    private CustomData.Mode getMode(){


        int getCheckedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if(getCheckedRadioButtonId == R.id.rMul){
            return CustomData.Mode.MULTIPLY;
        }else if(getCheckedRadioButtonId == R.id.rAdd){
            return CustomData.Mode.ADD;
        }else if(getCheckedRadioButtonId == R.id.rSub){
            return CustomData.Mode.SUBTRACT;
        }
        return null;
    }
}