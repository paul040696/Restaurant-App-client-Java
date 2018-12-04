package com.example.paul_.foodappv2.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paul_.foodappv2.Interface.ItemClickListener;
import com.example.paul_.foodappv2.R;

public class MeniuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

   public TextView txtMenuName;
   public ImageView imageView;

   private ItemClickListener itemClickListener;

    public MeniuViewHolder(View itemView) {
        super(itemView);

        txtMenuName = (TextView)itemView.findViewById(R.id.menu_name);
        imageView = (ImageView)itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {

        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}
