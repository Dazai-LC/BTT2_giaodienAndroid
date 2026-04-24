package com.example.appme_dazai;

import android.os.Bundle;
import android.widget.Button; // bắt buộc phải import Button để không báo lỗi đỏ

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai4_profileActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //--- Phần code cốt lõi của máy tự sinh
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),(v,insets)->{
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom);
            return insets;
        });
        //========================================================
        //--Bắt đầu phần code xử lý fragment
        // =======================================================

        //1.Nhát InfoFragment vào hộp ngay lúc mới mở app (Đỡ b trắng màn hình)
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer,new InfoFragment())
                    .commit();
        }
        //2. Tìm các nút thông qua ID(Nhớ đảm bảo ID bên XML khớp với ở đây)
        Button btnInfo = findViewById(R.id.btnInfo);
        Button btnHistory = findViewById(R.id.btnHistory);
        Button btnSetting = findViewById(R.id.btnSetting);
        //3.Bắt sự kiện bấm nút "Thông tin"
        btnInfo.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer,new InfoFragment())
                    .commit();
        });

        //4. Bắt sự kiện bấm nút "Lịch sử"
        btnHistory.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer,new HistoryFlagment())
                    .commit();
        });

        //5. Bắt sự kiện bấm nút "Cài đặt"
        btnSetting.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer,new SettingFlagment())
                    .commit();
        });
    }
}