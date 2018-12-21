package com.inhelp.core.models

import android.graphics.BitmapFactory
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.json.JSONObject
import org.jsoup.Jsoup
import java.net.URL
import java.util.regex.Pattern

data class InstagramSaveData(val image: String, val arrImages: ArrayList<String>)

class InstagramUrlData(private val url: String) {

    fun getPhoto() = GlobalScope.async {
        val doc = Jsoup.connect(url).get()
        val imageUrl = URL(doc.select("meta[property=og:image]")[0].attr("content"))
        BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream())
    }

    fun getPhotos() = GlobalScope.async {
        val first = "<script type=\"text/javascript\">window._sharedData = "
        val last = ";</script>"
        val p = Pattern.compile("$first.*?$last")
        val m = p.matcher(Jsoup.connect(url).get().html())
        m.find()
        val text = m.group(0).replace(first, "").replace(last, "")

        val shortcode_media = JSONObject(text)
                .getJSONObject("entry_data")
                .getJSONArray("PostPage")
                .getJSONObject(0)
                .getJSONObject("graphql")
                .getJSONObject("shortcode_media")

        val urlArray = arrayListOf<String>()

        try {
            val edges = shortcode_media
                    .getJSONObject("edge_sidecar_to_children")
                    .getJSONArray("edges")

            for (i in 0..(edges.length() - 1)) {
                urlArray.add(edges.getJSONObject(i).getJSONObject("node").getString("display_url"))
            }

        }catch (e: Exception){
            urlArray.add(shortcode_media.getString("display_url"))
        }
        urlArray
    }
}