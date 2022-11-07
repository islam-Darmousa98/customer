package com.example.customer_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Page extends AppCompatActivity {
    Button btnEmplyee,btnIncoming_order,btn_outgoing_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page);

        btnEmplyee=findViewById(R.id.btn_Employee);
        btnIncoming_order=findViewById(R.id.btn_Incoming_order);
        btn_outgoing_order=findViewById(R.id.btn_Outgoing_order);

        btnEmplyee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main_Page.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnIncoming_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main_Page.this,Incoming_order_activity.class);
                startActivity(intent);
            }
        });
        btn_outgoing_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Main_Page.this,OutGoing_order_Activity.class);
                startActivity(intent);
            }
        });
    }
}