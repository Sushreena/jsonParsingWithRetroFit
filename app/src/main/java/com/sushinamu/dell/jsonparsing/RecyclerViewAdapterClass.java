package com.sushinamu.dell.jsonparsing;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.CharacterPickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import java.util.List;

public class RecyclerViewAdapterClass extends RecyclerView.Adapter<RecyclerViewAdapterClass.MyViewHolder>{

    Context context;
    List<MenuModalClass> menuModalClasses;

    public RecyclerViewAdapterClass(Context context, List<MenuModalClass> menuModalClasses) {
        this.context = context;
        this.menuModalClasses = menuModalClasses;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterClass.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterClass.MyViewHolder holder, int position) {
        final MenuModalClass menuModalClass = menuModalClasses.get(position);

        holder.txtItemPrice.setText(menuModalClass.getItem_Price());
        holder.txtItemName.setText(menuModalClass.getItem_Name());
        holder.txtItemDesc.setText(menuModalClass.getItem_Desc_English());

        //loading image in image view

        Glide.with(context)
                .load("http://vedisapp.berlin-webdesign-agentur.de/Image/"+menuModalClass.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.itemImage);
        // click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"You clicked "+menuModalClass.getItem_Name(),Toast.LENGTH_SHORT).show();
                System.out.println("name:"+menuModalClass.getItem_Name());

                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("Item Name",menuModalClass.getItem_Name());
                intent.putExtra("Item Price",menuModalClass.getItem_Price());
                context.startActivity(intent);

                //context.startActivity(new Intent(context,SecondActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuModalClasses.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtItemName, txtItemDesc, txtItemPrice;
        ImageView itemImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtItemDesc = itemView.findViewById(R.id.item_desc);
            txtItemName = itemView.findViewById(R.id.item_name);
            txtItemPrice = itemView.findViewById(R.id.item_Price);
            itemImage = itemView.findViewById(R.id.item_image);

        }
    }
}