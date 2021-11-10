package com.hafizhmo.beritaindojava.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hafizhmo.beritaindojava.R;
import com.hafizhmo.beritaindojava.data.Source;
import com.hafizhmo.beritaindojava.ui.NewsActivity;

import java.util.ArrayList;

//TO-DO 3: extend the class with 'RecyclerView.Adapter' & clear the error
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    //TO-DO 1: initial the attribute 'context' & 'arraylist'
    private final Context mCotext;
    private final ArrayList<Source> mSources;

    //TO-DO 2: create constructor
    public MainAdapter(Context mCotext, ArrayList<Source> mSources) {
        this.mCotext = mCotext;
        this.mSources = mSources;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(mSources.get(position));
    }

    @Override
    public int getItemCount() {
        return mSources.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(Source source){
            TextView name = itemView.findViewById(R.id.text_name);
            TextView website = itemView.findViewById(R.id.text_website);

            name.setText(source.getName());
            website.setText(source.getWebsite());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goNews = new Intent(mCotext, NewsActivity.class);
                    goNews.putExtra("KEY", source.getName());
                    mCotext.startActivity(goNews);
                }
            });
        }
    }


    //TO-DO 4: create layout item_main.xml to inflating the recyclerview
    //TO-DO 5: (onCreateViewHolder) give return value by LayoutInflater

    //TO-DO 6: create method 'onbind' inside class ViewHolder
    //TO-DO 7: (onBindViewHolder) call method 'onbind'

    //TO-DO 8: (getItemCount) give the return value by arraylist.size()

    //TO-DO 9: (ViewHolder) setup the TextViews of item_main.xml to the arraylist
}
