package com.example.ex4;

import static com.example.ex4.CustomData.Mode.ADD;
import static com.example.ex4.CustomData.Mode.MULTIPLY;
import static com.example.ex4.CustomData.Mode.SUBTRACT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivitys extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activitys);
        Button button = findViewById(R.id.button2);

        button.setOnClickListener(v ->{
            finish();
        });

        TextView resultView = findViewById(R.id.textView2);
        CustomData customData = getIntent().getSerializableExtra(MainActivity.DATA,CustomData.class);
        if(customData!=null)
        {
            int result = calculate(customData);
            resultView.setText(""+result);
        }

    }

    private int calculate(CustomData data)
    {
        switch(data.getMode())
        {
            case ADD: return data.getN1() + data.getN2();
            case MULTIPLY: return data.getN1() * data.getN2();
            case SUBTRACT: return data.getN1() - data.getN2();
            default: return 0;
        }
    }
}