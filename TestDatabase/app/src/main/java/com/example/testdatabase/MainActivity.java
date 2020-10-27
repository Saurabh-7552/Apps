package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper mDB;
    EditText mName , mSurname, mMarks;
    Button mEnterData,mViewData,mDeleteData;
    List<Student> StudentList;
    StudentAdapter studentAdapter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentList =new ArrayList<>();
        mName =findViewById(R.id.enter_name);
        mSurname =findViewById(R.id.enter_Surname);
        mMarks=findViewById(R.id.enter_Marks);
        mEnterData=findViewById(R.id.Enter_Data);
        mDeleteData=findViewById(R.id.delete_item);
        mDB=new DataBaseHelper(MainActivity.this);
        mEnterData = findViewById(R.id.Enter_Data);
        mViewData=findViewById(R.id.View_all);
        studentAdapter =new StudentAdapter(MainActivity.this,StudentList);
        AddData();
        ViewData();
        DeleteData();
        mListView =findViewById(R.id.list_student);
        mListView.setAdapter(studentAdapter);
    }

    private void DeleteData() {
        mDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDB.deleteTable();
                StudentList.clear();
                studentAdapter.clear();
                studentAdapter.notifyDataSetChanged();
            }
        });
    }

    private void ViewData() {

        mViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentList.clear();
                studentAdapter.clear();
                studentAdapter.notifyDataSetChanged();
                Cursor mCursor =mDB.getData();
                if(mCursor.getCount()==0)
                    Toast.makeText(MainActivity.this,"No Result to Show ",Toast.LENGTH_SHORT).show();
                else
                {
                    while(mCursor.moveToNext())
                    {
                        StudentList.add(new Student(mCursor.getString(1),mCursor.getString(2),mCursor.getInt(3)));

                    }
                    studentAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    private void AddData()
    {
        mEnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString();
                if(name.isEmpty()) {
                    name="Empty";
                }
                String Surname=mSurname.getText().toString();
                if(Surname.isEmpty()) {
                    Surname="Empty";
                }
                String marks=mMarks.getText().toString();
                if(marks.isEmpty())
                {
                    marks="0";
                }
                Integer Marks=Integer.parseInt(marks);
                if(mDB.InsertData(name,Surname,Marks)) {
                    Toast.makeText(MainActivity.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Unsuccessful in Inserting Sorry!! ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}