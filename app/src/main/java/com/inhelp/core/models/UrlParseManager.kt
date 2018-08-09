package com.inhelp.core.models

import io.reactivex.Observable
import org.jsoup.Jsoup
import java.util.concurrent.Callable


object UrlParseManager {
    fun getPhoto(url: String): Observable<String>{
        return Observable.fromCallable(CallableGetPhoto(url))
    }

    internal class CallableGetPhoto (private val data: String) : Callable<String> {

        override fun call(): String {
            return try {
                val doc = Jsoup.connect(data).get()
                doc.select("meta[property=og:image]")[0].attr("content")
            }catch (e: Exception){
                ""
            }
        }
    }
}