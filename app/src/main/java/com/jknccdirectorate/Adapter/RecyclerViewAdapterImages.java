package com.jknccdirectorate.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jknccdirectorate.Model.ImageModel;
import com.jknccdirectorate.Model.Notice;
import com.jknccdirectorate.R;

import java.util.List;

/**
 * Created by Balpreet on 09-Sep-17.
 */

public class RecyclerViewAdapterImages extends RecyclerView.Adapter<RecyclerViewAdapterImages.MyViewHolder> {

    List<ImageModel> imageModelList;

    public RecyclerViewAdapterImages(List<ImageModel> imageModelList) {
        this.imageModelList = imageModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_images, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageModel model = (ImageModel) this.imageModelList.get(position);
        holder.image.setImageBitmap(model.getBitmap());
    }

    @Override
    public int getItemCount() {
        return imageModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;

        private MyViewHolder(View itemView) {
            super(itemView);
            this.image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
