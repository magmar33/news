package com.example.news.data.remote.responses

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("hits") val hits: ArrayList<HitItemResponse>?,
    @SerializedName("nbHits") val nbHits : Long?,
    @SerializedName("page") val page : Int?,
    @SerializedName("nbPages") val nbPages : Int?,
    @SerializedName("hitsPerPage") val hitsPerPage : Int?,
    @SerializedName("exhaustiveNbHits") val exhaustiveNbHits : Boolean?,
    @SerializedName("exhaustiveTypo") val exhaustiveTypo : Boolean?,
    @SerializedName("query") val query : String?,
    @SerializedName("params") val params : String?,
    @SerializedName("processingTimeMS") val processingTimeMS : String?
)
