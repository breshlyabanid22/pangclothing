package com.example.pangclothing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private final Context context;
    private final List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getProductName());
        holder.description.setText(product.getDescription());
        holder.price.setText(String.valueOf(product.getPrice()));
        int imageResourceId = ResourceUtil.getResourceId(context, product.getImagePath(), "drawable");
        Glide.with(context)
                .load(imageResourceId)
                .error(R.drawable.wireless_earbuds)
                .into(holder.imagePath);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePath;
        TextView productName, description, price;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePath = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.prodName);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
        }
    }
}
