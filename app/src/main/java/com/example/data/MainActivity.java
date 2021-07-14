package com.example.data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button send ,get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btSend:
                Intent send = new Intent(this,OpenedClasses.class);
                startActivity(send);

                break;


            case R.id.btGet:

                Intent get = new Intent(this,Data.class);
                startActivity(get);

                break;
        }
    }
}
