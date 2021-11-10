package com.hafizhmo.beritaindojava.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hafizhmo.beritaindojava.R;
import com.hafizhmo.beritaindojava.data.News;
import com.squareup.picasso.Picasso;

import java.util.List;

//TO-DO 3: extend the class with 'RecyclerView.Adapter' & clear the error
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    //TO-DO 1: initial the attribute 'context' & 'List<E>'
    private final Context mContext;
    private final List<News.Data.Post> mPosts;

    //TO-DO 2: create constructor
    public NewsAdapter(Context mContext, List<News.Data.Post> mPosts) {
        this.mContext = mContext;
        this.mPosts = mPosts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(mPosts.get(position));
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(News.Data.Post post) {
            TextView title = itemView.findViewById(R.id.text_title);
            TextView pubDate = itemView.findViewById(R.id.text_pubdate);
            ImageView thumbnail = itemView.findViewById(R.id.image_thumbnail);

            title.setText(post.title);
            pubDate.setText(post.pubDate);
            Picasso.with(mContext).load(post.thumbnail).into(thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(post.link));

                    mContext.startActivity(i);
                }
            });
        }
    }


    //TO-DO 4: create layout item_news.xml to inflating the recyclerview
    //TO-DO 5: (onCreateViewHolder) give return value by LayoutInflater

    //TO-DO 6: create method 'onbind' inside class ViewHolder
    //TO-DO 7: (onBindViewHolder) call method 'onbind'

    //TO-DO 8: (getItemCount) give the return value by List<E>.size()

    //TO-DO 9: (ViewHolder) setup the Views of item_news.xml to the List<E>
}
