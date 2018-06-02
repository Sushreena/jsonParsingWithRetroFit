package com.sushinamu.dell.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String item_name = getIntent().getExtras().getString("Item Name");
        String item_price = getIntent().getExtras().getString("Item Price");

        Toast.makeText(this,"Price of "+item_name+" is "+item_price,Toast.LENGTH_SHORT).show();
    }
}
