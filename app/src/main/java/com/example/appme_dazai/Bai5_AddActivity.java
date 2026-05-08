package com.example.appme_dazai;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Bai5_AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("TEST_FIREBASE", "onCreate da chay");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai5_add);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            v.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );

            return insets;
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance(
                "https://dazai-appme-default-rtdb.asia-southeast1.firebasedatabase.app"
        );

        DatabaseReference myRef = database.getReference("hello");

        myRef.setValue("Xin chao Firebase")
                .addOnSuccessListener(unused -> {
                    Log.d("TEST_FIREBASE", "Ghi thanh cong");
                })
                .addOnFailureListener(e -> {
                    Log.e("TEST_FIREBASE", "Loi Firebase: " + e.getMessage());
                });
    }
}