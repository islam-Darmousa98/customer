package com.example.customer_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase db;

    public DbHandler(@Nullable Context context) {
        super(context,"empdb",null,1);
        this.context=context;
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Emp_sql="create table emp(id integer primary key,name text,age integer,salary integer)";
        String IO_sql="create table Incoming_order(id integer primary key,name text,Date text,price double)";
        String OO_sql="create table outgoing_order(id integer primary key,name text,Date text,price double)";
        db.execSQL(Emp_sql);
        db.execSQL(IO_sql);
        db.execSQL(OO_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void  addEmployee(Employee e)
    {
        ContentValues cv=new ContentValues();
        cv.put("id",e.getId());
        cv.put("name",e.getName());
        cv.put("age",e.getAge());
        cv.put("salary",e.getSalary());
        long rid=db.insert("emp",null,cv);
        if(rid<0)
            Toast.makeText(context, "insert issue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "1 record inserted", Toast.LENGTH_SHORT).show();

    }
    public void updateEmployee(Employee e)
    {
        ContentValues cv=new ContentValues();
        cv.put("id",e.getId());
        cv.put("name",e.getName());
        cv.put("age",e.getAge());
        cv.put("salary",e.getSalary());
        long nor=db.update("emp",cv,"id="+e.getId(),null); //number of records
        Toast.makeText(context, nor+"records updated", Toast.LENGTH_SHORT).show();

    }

    public void deleteEmployee(Employee e)
    {
        long nor=db.delete("emp","id="+e.getId(),null);
        Toast.makeText(context, nor+"records deleted", Toast.LENGTH_SHORT).show();

    }

    public ArrayList viewEmployee()
    {
        Cursor c=db.query("emp",null,null,null,null,null,null);
        c.moveToFirst();
        ArrayList a=new ArrayList<>();

        if(c.getCount()>0)
        {
            do {
                String id=c.getString(0);
                String name=c.getString(1);
                String age=c.getString(2);
                String salary=c.getString(3);
                Employee b=new Employee(Integer.parseInt(id),name,Integer.parseInt(age),Integer.parseInt(salary));
                a.add(b);

            }while (c.moveToNext());

        }
        return a;

    }
    ///////////////////////////////////////for Incoming orders
    public void  add_Incoming_order(Incoming_order io)
    {
        ContentValues cv=new ContentValues();
        cv.put("id",io.getId());
        cv.put("name",io.getNAME());
        cv.put("Date",io.getDate());
        cv.put("price",io.getPrice());
        long rid=db.insert("Incoming_order",null,cv);
        if(rid<0)
            Toast.makeText(context, "insert issue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "1 record inserted", Toast.LENGTH_SHORT).show();

    }
    public void update_incomingorder(Incoming_order e)
    {
        ContentValues cv=new ContentValues();
        cv.put("id",e.getId());
        cv.put("name",e.getNAME());
        cv.put("Date",e.getDate());
        cv.put("price",e.getPrice());
        long nor=db.update("Incoming_order",cv,"id="+e.getId(),null); //number of records
        Toast.makeText(context, nor+"records updated", Toast.LENGTH_SHORT).show();

    }

    public void delete_Incoming_order(Incoming_order e)
    {
        long nor=db.delete("Incoming_order","id="+e.getId(),null);
        Toast.makeText(context, nor+"records deleted", Toast.LENGTH_SHORT).show();

    }

    public ArrayList view_Incoming_order()
    {
        Cursor c=db.query("Incoming_order",null,null,null,null,null,null);
        c.moveToFirst();
        ArrayList a=new ArrayList<>();

        if(c.getCount()>0)
        {
            do {
                String id=c.getString(0);
                String name=c.getString(1);
                String Date=c.getString(2);
                String price=c.getString(3);
                Incoming_order b=new Incoming_order(Integer.parseInt(id),name,(Date),Double.parseDouble(price));
                a.add(b);

            }while (c.moveToNext());

        }
        return a;

    }
    /////////////////outgoing order
    public void  add_outging_order(Outgoing_order io)
    {
        ContentValues cv=new ContentValues();
        cv.put("id",io.getId());
        cv.put("name",io.getNAME());
        cv.put("Date",io.getDate());
        cv.put("price",io.getPrice());
        long rid=db.insert("outgoing_order",null,cv);
        if(rid<0)
            Toast.makeText(context, "insert issue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "1 record inserted", Toast.LENGTH_SHORT).show();

    }
    public void update_outgoingorder(Outgoing_order e)
    {
        ContentValues cv=new ContentValues();
        cv.put("id",e.getId());
        cv.put("name",e.getNAME());
        cv.put("Date",e.getDate());
        cv.put("price",e.getPrice());
        long nor=db.update("outgoing_order",cv,"id="+e.getId(),null); //number of records
        Toast.makeText(context, nor+"records updated", Toast.LENGTH_SHORT).show();

    }

    public void delete_outgoingorder(Outgoing_order e)
    {
        long nor=db.delete("outgoing_order","id="+e.getId(),null);
        Toast.makeText(context, nor+"records deleted", Toast.LENGTH_SHORT).show();

    }

    public ArrayList view_outgoing_order()
    {
        Cursor c=db.query("outgoing_order",null,null,null,null,null,null);
        c.moveToFirst();
        ArrayList a=new ArrayList<>();

        if(c.getCount()>0)
        {
            do {
                String id=c.getString(0);
                String name=c.getString(1);
                String Date=c.getString(2);
                String price=c.getString(3);
                Outgoing_order b=new Outgoing_order(Integer.parseInt(id),name,(Date),Double.parseDouble(price));
                a.add(b);

            }while (c.moveToNext());

        }
        return a;

    }

}
