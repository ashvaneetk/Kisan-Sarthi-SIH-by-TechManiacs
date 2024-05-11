package com.example.kisansarthi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogViewHolder> {

    private List<Blog> blogs;

    public BlogAdapter(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_item_layout, parent, false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BlogViewHolder holder, int position) {
        Blog blog = blogs.get(position);
        holder.tvTitle.setText(blog.getTitle());
        holder.tvDescription.setText(blog.getDescription());
        Picasso.get().load(blog.getImageUrl()).into(holder.ivBlogImage);
    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }
}

public class CommunityPageActivity extends AppCompatActivity {

    private RecyclerView rvBlogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(Bundle.savedInstanceState);
        setContentView(R.layout.communitypageactivity);

        // Find the RecyclerView
        rvBlogs = findViewById(R.id.rvBlogs);

        // Set layout manager
        rvBlogs.setLayoutManager(new LinearLayoutManager(this));

        // Replace with your actual way to fetch blogs (API call, database, etc.)
        List<Blog> blogs = prepareBlogData(); // Replace with your data fetching logic
        BlogAdapter adapter = new BlogAdapter(blogs);
        rvBlogs.setAdapter(adapter);
    }

    // This method is for demonstration purposes (replace with your data fetching logic)
    private List<Blog> prepareBlogData() {
        List<Blog> blogs = new ArrayList<>();
        blogs.add(new Blog("Top Tips to Prevent Tomato Diseases",
                "Learn effective strategies to keep your tomato plants healthy and disease-free!",
                "https://via.placeholder.com/150"));
        blogs.add(new Blog("Identifying Early Signs of Tomato Blight",
                "Don't miss the early warnings! This blog helps you identify tomato blight symptoms.",
                "https://via.placeholder.com/150"));
        return blogs;
    }
}

