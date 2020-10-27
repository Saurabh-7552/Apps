package com.example.testdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, List<Student> studentList)
    {
        super(context,0,studentList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if(listView == null)
        {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.student_item, parent, false);
        }
        Student currentStudent = getItem(position);
        TextView mName =listView.findViewById(R.id.name);
        mName.setText(currentStudent.getName());
        TextView mSurname =listView.findViewById(R.id.surname);
        mSurname.setText(currentStudent.getSurname());
        TextView mMarks =listView.findViewById(R.id.marks);
        mMarks.setText(currentStudent.getMarks().toString());

        return listView;
    }
}
