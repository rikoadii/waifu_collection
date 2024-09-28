package com.submissionandroid.waifucollection

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Waifu(
    val name: String,
    val anime: String,
    val description: String,
    val checkWiki: String,
    val photo: Int,
    val birthday: String,
    val age: String,
    val watchAnime: String,
) : Parcelable
