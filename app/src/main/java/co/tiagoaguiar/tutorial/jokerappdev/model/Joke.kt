package co.tiagoaguiar.tutorial.jokerappdev.model

import com.google.gson.annotations.SerializedName

data class Joke (
    @SerializedName("value") val textJoke: String,
    @SerializedName("icon_url") val iconUrl: String
    )