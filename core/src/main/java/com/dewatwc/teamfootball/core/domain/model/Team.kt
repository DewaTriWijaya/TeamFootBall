package com.dewatwc.teamfootball.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team(
    val idTeam: String,
    val name: String,
    val stadium: String,
    val img: String,
    val description: String,
    val isFavorite: Boolean
) : Parcelable