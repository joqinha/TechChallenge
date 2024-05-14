package com.joaoferreira.techchallenge.allapps.domain.response

import com.google.gson.annotations.SerializedName

data class AppData(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("package") val packageName: String,
    @SerializedName("store_id") val storeId: Long,
    @SerializedName("store_name") val storeName: String,
    @SerializedName("vername") val versionName: String,
    @SerializedName("vercode") val versionCode: Int,
    @SerializedName("md5sum") val md5sum: String,
    @SerializedName("apk_tags") val apkTags: List<String>,
    @SerializedName("size") val size: Long,
    @SerializedName("downloads") val downloads: Long,
    @SerializedName("pdownloads") val pDownloads: Long,
    @SerializedName("added") val added: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("updated") val updated: String,
    @SerializedName("rating") val rating: Double,
    @SerializedName("icon") val iconUrl: String,
    @SerializedName("graphic") val graphicUrl: String,
    @SerializedName("uptype") val upType: String
)