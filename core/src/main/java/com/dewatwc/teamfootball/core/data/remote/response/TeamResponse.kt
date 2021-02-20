package com.dewatwc.teamfootball.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @field:SerializedName("idTeam")
    val idTeam: String,

    @field:SerializedName("strTeam")
    val name: String,

    @field:SerializedName("strStadium")
    val stadium: String,

    @field:SerializedName("strTeamBadge")
    val img: String,

    @field:SerializedName("strStadiumDescription")
    val description: String
)