package com.dewatwc.teamfootball.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListTeamResponse(
    @field:SerializedName("teams")
    val teams: List<TeamResponse>
)
