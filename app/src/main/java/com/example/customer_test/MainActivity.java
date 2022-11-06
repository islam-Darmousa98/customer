package com.example.customer_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {
    EditText etEmpid,etEmpname,etEmpage,etEmpsalary;
    Button btnAdd,btnView,btnDelete,btnUpdate;
    TextView tvData;
    ListView lsData;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmpid=(EditText)findViewById(R.id.Emp_id);
        etEmpname=(EditText)findViewById(R.id.Emp__name);
        etEmpage=(EditText)findViewById(R.id.Emp_age);
        etEmpsalary=(EditText)findViewById(R.id.Emp_salary);
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
                String id=etEmpid.getText().toString();
                String name=etEmpname.getText().toString();
                String age=etEmpage.getText().toString();
                String salary=etEmpsalary.getText().toString();
                if(id.length()==0)
                {
                    etEmpid.setError("id is empty");
                    etEmpid.requestFocus();
                    return;
                }
                if(name.length()==0)
                {
                    etEmpname.setError("name is empty");
                    etEmpname.requestFocus();
                    return;
                }
                if(age.length()==0)
                {
                    etEmpage.setError("age is empty");
                    etEmpage.requestFocus();
                    return;
                }
                if(salary.length()==0)
                {
                    etEmpsalary.setError("salary is empty");
                    etEmpsalary.requestFocus();
                    return;
                }
                Employee b=new Employee(Integer.parseInt(id),name,Integer.parseInt(age),Integer.parseInt(salary));
                db.addEmployee(b);
                etEmpid.setText("");
                etEmpname.setText("");
                etEmpage.setText("");
                etEmpsalary.setText("");
                etEmpid.requestFocus();


            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=etEmpid.getText().toString();
                String name=etEmpname.getText().toString();
                String age=etEmpage.getText().toString();
                String salary=etEmpsalary.getText().toString();
                if(id.length()==0)
                {
                    etEmpid.setError("id is empty");
                    etEmpid.requestFocus();
                    return;
                }
                if(name.length()==0)
                {
                    etEmpname.setError("name is empty");
                    etEmpname.requestFocus();
                    return;
                }
                if(age.length()==0)
                {
                    etEmpage.setError("age is empty");
                    etEmpage.requestFocus();
                    return;
                }
                if(salary.length()==0)
                {
                    etEmpsalary.setError("salary is empty");
                    etEmpsalary.requestFocus();
                    return;
                }
                Employee b=new Employee(Integer.parseInt(id),name,Integer.parseInt(age),Integer.parseInt(salary));
                db.updateEmployee(b);
                etEmpid.setText("");
                etEmpname.setText("");
                etEmpid.requestFocus();

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=etEmpid.getText().toString();
                if(id.length()==0)
                {
                    etEmpid.setError("id is empty");
                    etEmpid.requestFocus();
                    return;
                }

                Employee b=new Employee(Integer.parseInt(id),"",0,0);
                db.deleteEmployee(b);
                etEmpid.setText("");
                etEmpid.requestFocus();


            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvData.setText("");
                ArrayList<Employee> a=new ArrayList();
                a=db.viewEmployee();
                if(a.size()==0)
                {
                    tvData.setText("no records");
                }
                else
                {
                    for( Employee m : a)
                    {
                        tvData.setText(tvData.getText()+"\n"+m.getId()+":"+m.getName()+":"+m.age+":"+m.salary);
                       //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,a);
                    }
                }
            }
        });
    }
}