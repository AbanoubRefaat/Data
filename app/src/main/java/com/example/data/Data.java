package com.example.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements View.OnClickListener {

    Button btStart , btSartForResult;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initalize ();

    }
    private void initalize (){

        btStart = (Button)findViewById(R.id.btStart);
        btSartForResult = (Button)findViewById(R.id.btSAFR);
        editText = (EditText)findViewById(R.id.etSend);
        textView = (TextView)findViewById(R.id.tvGot);

        btSartForResult.setOnClickListener(this);
        btStart.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSAFR:
                Intent i = new Intent(Data.this,OpenedClasses.class);
                startActivityForResult(i,0);

                break;

            case R.id.btStart:

                String bread = editText.getText().toString();
                Bundle basket = new Bundle();
                basket.putString("key",bread);
                Intent a = new Intent(Data.this,OpenedClasses.class);
                a.putExtras(basket);
                startActivity(a);
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Bundle basket = data.getExtras();
            String s = basket.getString("answer");
            textView.setText(s);
        }
    }

}
