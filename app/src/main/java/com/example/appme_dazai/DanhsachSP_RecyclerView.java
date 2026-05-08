package com.example.appme_dazai;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DanhsachSP_RecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danhsach_sp_recycler_view);
        //Ánh xạ RecyclerView và set LayoutManager
        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         // Khởi tạo ArrayList và nạp dữ liệu giả
        productList = new ArrayList<>();
        productList.add(new Product("Điện thoại iPhone 15", "25.000.000 VNĐ", "Mới ra mắt, siêu mượt"));
        productList.add(new Product("Laptop Dell XPS", "30.000.000 VNĐ", "Màn hình 4K, mỏng nhẹ"));
        productList.add(new Product("Bàn phím cơ RK68", "1.000.000 VNĐ", "Gõ cực êm, có LED RGB"));
        productList.add(new Product("Chuột Logitech G102", "400.000 VNĐ", "Quốc dân cho game thủ"));

        //Khởi tạo Adapter và gắn vào RecyclerView
        productAdapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(productAdapter);
    }
}