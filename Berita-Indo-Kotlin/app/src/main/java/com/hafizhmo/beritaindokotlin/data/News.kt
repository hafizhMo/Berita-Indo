package com.hafizhmo.beritaindokotlin.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    @SerializedName("data")
    val datas: Data
) : Parcelable {

    @Parcelize
    data class Data(
        @SerializedName("posts")
        val posts: List<Post>
    ) : Parcelable {

        @Parcelize
        data class Post(
            @SerializedName("title")
            val title: String?,
            @SerializedName("pubDate")
            val pubDate: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("thumbnail")
            val thumbnail: String?,
            @SerializedName("link")
            val link: String?
        ) : Parcelable
    }
}


