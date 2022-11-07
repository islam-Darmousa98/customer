package com.example.customer_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Incoming_order_activity extends AppCompatActivity {
    EditText etorderid,etordername,etorderdate,etorderprice;
    Button btnAdd,btnView,btnDelete,btnUpdate;
    TextView tvData;
    ListView lsData;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_order_activity);

        etorderid=(EditText)findViewById(R.id.Order_id);
        etordername=(EditText)findViewById(R.id.Order__name);
        etorderdate=(EditText)findViewById(R.id.Order_date);
        etorderprice=(EditText)findViewById(R.id.Order_price);
        btnAdd=(Button)findViewById(R.id.btn_add);
        btnUpdate=(Button)findViewById(R.id.btn_update);
        btnDelete=(Button)findViewById(R.id.btn_delete);
        btnView=(Button)findViewById(R.id.btn_read);
        tvData=(TextView)findViewById(R.id.tvData);
        lsData=findViewById(R.id.lvData);
        db=new DbHandler(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=etorderid.getText().toString();
                String name=etordername.getText().toString();
                String Date=etorderdate.getText().toString();
                String price=etorderprice.getText().toString();
                if(id.length()==0)
                {
                    etorderid.setError("id is empty");
                    etorderid.requestFocus();
                    return;
                }
                if(name.length()==0)
                {
                    etordername.setError("name is empty");
                    etordername.requestFocus();
                    return;
                }
                if(Date.length()==0)
                {
                    etorderdate.setError("Date is empty");
                    etorderdate.requestFocus();
                    return;
                }
                if(price.length()==0)
                {
                    etorderprice.setError("price is empty");
                    etorderprice.requestFocus();
                    return;
                }
                Incoming_order b=new Incoming_order(Integer.parseInt(id),name,Date,Double.parseDouble(price));
                db.add_Incoming_order(b);
                etorderid.setText("");
                etordername.setText("");
                etorderdate.setText("");
                etorderprice.setText("");
                etorderid.requestFocus();


            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=etorderid.getText().toString();
                String name=etordername.getText().toString();
                String Date=etorderdate.getText().toString();
                String price=etorderprice.getText().toString();
                if(id.length()==0)
                {
                    etorderid.setError("id is empty");
                    etorderid.requestFocus();
                    return;
                }
                if(name.length()==0)
                {
                    etordername.setError("name is empty");
                    etordername.requestFocus();
                    return;
                }
                if(Date.length()==0)
                {
                    etorderdate.setError("date is empty");
                    etorderdate.requestFocus();
                    return;
                }
                if(price.length()==0)
                {
                    etorderprice.setError("salary is empty");
                    etorderprice.requestFocus();
                    return;
                }
                Incoming_order b=new Incoming_order(Integer.parseInt(id),name,Date,Double.parseDouble(price));
                db.update_incomingorder(b);
                etorderid.setText("");
                etordername.setText("");
                etorderid.requestFocus();

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=etorderid.getText().toString();
                if(id.length()==0)
                {
                    etorderid.setError("id is empty");
                    etorderid.requestFocus();
                    return;
                }

                Incoming_order b=new Incoming_order(Integer.parseInt(id),"","",0);
                db.delete_Incoming_order(b);
                etorderid.setText("");
                etorderid.requestFocus();


            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvData.setText("");
                ArrayList<Incoming_order> a=new ArrayList();
                a=db.view_Incoming_order();
                if(a.size()==0)
                {
                    tvData.setText("no records");
                }
                else
                {
                    for( Incoming_order m : a)
                    {
                        tvData.setText(tvData.getText()+"\n"+m.getId()+":"+m.getNAME()+":"+m.Date+":"+m.price);
                        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,a);
                    }
                }
            }
        });
    }

}