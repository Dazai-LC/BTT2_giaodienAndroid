package com.example.appme_dazai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private Context context;
    private ArrayList<Product> productList;

    //Constructor của Adapter
    public ProductAdapter(Context context,ArrayList<Product> productList){
        this.context = context;
        this.productList = productList;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        //Nạp layout item_product.xml
        View view = LayoutInflater.from(context).inflate(R.layout.item_product,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder,int position){
        //Lấy sản phẩm tại vị trí hiện tại
        Product currentProduct = productList.get(position);

        //Đổ dữ liệu vào UI
        holder.tvName.setText(currentProduct.getName());
        holder.tvPrice.setText("Giá: " +currentProduct.getPrice());
        holder.tvDesc.setText(currentProduct.getDescription());

        //Xử lý sự kiện click
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(context, "Bạn đã chọn: " + currentProduct.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return productList.size();
    }
    //Class ViewHolder
    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvPrice,tvDesc;
        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            //Ánh xạ UI
            tvName = itemView.findViewById(R.id.tvProductName);
            tvPrice = itemView.findViewById(R.id.tvProductPrice);
            tvDesc = itemView.findViewById(R.id.tvProductDesc);
        }
    }
}
