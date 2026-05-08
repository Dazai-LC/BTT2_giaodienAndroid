package com.example.appme_dazai;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DoListView extends AppCompatActivity {

    ListView lvStudent;

    ArrayList<String> studentList;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_do_list_view);

        lvStudent = findViewById(R.id.lvStudent);

        studentList.add("Nguyễn Văn A");
        studentList.add("Nguyễn thị B");
        studentList.add("Lý Ngọc C");
        studentList.add("Chu văn D");
        studentList.add("Lăng Thị E");

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                studentList
        );
        lvStudent.setAdapter(adapter);

        lvStudent.setOnItemClickListener((parent,view,position,id)->{
            String name = studentList.get(position);

            Toast.makeText(
                    DoListView.this,
                    "Bạn chọn: " + name,
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}