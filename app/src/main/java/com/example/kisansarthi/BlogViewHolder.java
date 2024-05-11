package com.example.kisansarthi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BlogViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitle;
    TextView tvDescription;
    ImageView ivBlogImage;

    public BlogViewHolder(View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tvBlogTitle);
        tvDescription = itemView.findViewById(R.id.tvBlogDescription);
        ivBlogImage = itemView.findViewById(R.id.ivBlogImage);
    }
}
