package com.example.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OpenedClasses extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    TextView question , tvTest;
    RadioGroup radioGroup;
    RadioButton r1,r2,r3;
    Button btReturn;
    String gotBread , setData ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();
        Bundle gotBasket = getIntent().getExtras();
        gotBread = gotBasket.getString("key");
        question.setText(gotBread);



    }
    private void initialize(){
        question= (TextView)findViewById(R.id.tvQuestion);
        tvTest = (TextView)findViewById(R.id.tvTest);
        radioGroup = (RadioGroup)findViewById(R.id.rgAnswers);
        r1 = (RadioButton)findViewById(R.id.rb1);
        r2 = (RadioButton)findViewById(R.id.rb2);
        r3 = (RadioButton)findViewById(R.id.rb3);
        btReturn= (Button)findViewById(R.id.btReturn);

        btReturn.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer",setData);
        person.putExtras(backpack);
        setResult(RESULT_OK,person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb1:
                setData = "probably right!!";
                break;

            case R.id.rb2:

                setData = "definitely right!!";
                break;

            case R.id.rb3:

                setData = "spot on";
                break;
        }

        tvTest.setText(setData);
    }
}
