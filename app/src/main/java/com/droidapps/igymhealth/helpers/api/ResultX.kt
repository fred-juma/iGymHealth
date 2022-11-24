package com.droidapps.igymhealth.helpers.api


import com.google.gson.annotations.SerializedName

data class ResultX(
    @SerializedName("author_history")
    val authorHistory: List<String>,
    @SerializedName("category")
    val category: Int,
    @SerializedName("creation_date")
    val creationDate: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("equipment")
    val equipment: List<Int>,
    @SerializedName("exercise_base")
    val exerciseBase: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("language")
    val language: Int,
    @SerializedName("license")
    val license: Int,
    @SerializedName("license_author")
    val licenseAuthor: String,
    @SerializedName("muscles")
    val muscles: List<Int>,
    @SerializedName("muscles_secondary")
    val musclesSecondary: List<Int>,
    @SerializedName("name")
    val name: String,
    @SerializedName("uuid")
    val uuid: String,
    @SerializedName("variations")
    val variations: List<Int>
)