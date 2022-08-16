package com.example.networking.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networking.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterProduct extends BaseAdapter {
    Context context;
    ArrayList<Product> listProducts;
    public AdapterProduct(Context context, ArrayList<Product> listProducts)
    {
        this.context = context;
        this.listProducts = listProducts;
    }
    @Override
    public int getCount() {
        return listProducts.size();
    }
    @Override
    public Object getItem(int i) {
        return listProducts.get(i);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    public static class ViewHolder {
        TextView tvId, tvName,tvPrice;
        ImageView imgProduct;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.list_item_product, null);
            viewHolder.tvId = (TextView) view.findViewById(R.id.pid);
            viewHolder.tvName = (TextView) view.findViewById(R.id.name);
            viewHolder.tvPrice = (TextView) view.findViewById(R.id.price);
            viewHolder.imgProduct = view.findViewById(R.id.imgProduct);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)view.getTag();
        }
        Product product = listProducts.get(i);
        viewHolder.tvId.setText(product.getId()+"");
        viewHolder.tvName.setText(product.getName());
        viewHolder.tvPrice.setText("$"+product.getPrice());
        Picasso.get().load(product.getImg()).into(viewHolder.imgProduct);
        Animation animation;
        animation = new TranslateAnimation(300, 0, 0, 0);
        animation.setDuration(600);
        view.startAnimation(animation);

        return view;
    }
}
