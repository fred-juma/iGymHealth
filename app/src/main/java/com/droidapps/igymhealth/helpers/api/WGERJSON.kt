package com.droidapps.igymhealth.helpers.api


import com.google.gson.annotations.SerializedName

data class WGERJSON(

    @SerializedName("count")
    val count: Int? = null,

    @SerializedName("next")
    val next: String? = null,

    @SerializedName("previous")
    val previous: Any? = null,

    @SerializedName("results")
    val results: List<ResultX>? = null


)