package com.example.appme_dazai;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DanhSachMonHoc_ListView extends AppCompatActivity{
    ListView lvMonHoc;
    EditText edtNhapMon;
    Button btnThemMon,btnClearAll;
    ArrayList<String> arlMonHoc;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_mon_hoc_list_view);

        //Ánh xạ
        lvMonHoc = findViewById(R.id.lvMonHoc);
        edtNhapMon = findViewById(R.id.edtNhapMon);
        btnThemMon = findViewById(R.id.btnThemMon);
        btnClearAll = findViewById(R.id.btnClearAll);

        //Tạo ArrayList
        arlMonHoc = new ArrayList<>();
        //Adapter
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arlMonHoc
        );

        //Gắn adapter cho ListView
        lvMonHoc.setAdapter(adapter);

        //Nút thêm môn học
        btnThemMon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String monHoc = edtNhapMon.getText().toString().trim();

                if(monHoc.isEmpty()){
                    Toast.makeText(
                            DanhSachMonHoc_ListView.this,
                            "Chưa nhập môn học",
                            Toast.LENGTH_SHORT
                    ).show();
                    return;
                }
                arlMonHoc.add(monHoc);
                adapter.notifyDataSetChanged();
                edtNhapMon.setText("");
            }
        });
        //Nút xóa tất cả
        btnClearAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                arlMonHoc.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(
                        DanhSachMonHoc_ListView.this,
                        "Đã óa tất cả",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}