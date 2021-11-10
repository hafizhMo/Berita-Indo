package com.hafizhmo.beritaindojava.data;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    //TO-D0 1: initial attribute 'title', 'puDate', 'thumb' and 'link' using SerializedName
    @SerializedName("data")
    public Data data;

    public static class Data {
        @SerializedName("posts")
        public List<Post> posts;

        public static class Post {
            @SerializedName("title")
            public String title;
            @SerializedName("pubDate")
            public String pubDate;
            @SerializedName("thumbnail")
            public String thumbnail;
            @SerializedName("link")
            public String link;
        }
    }
}
