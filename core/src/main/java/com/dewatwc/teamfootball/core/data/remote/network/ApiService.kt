package com.dewatwc.teamfootball.core.data.remote.network

import com.dewatwc.teamfootball.core.data.remote.response.ListTeamResponse
import retrofit2.http.GET

interface ApiService {
    @GET("lookup_all_teams.php?id=4328")
    suspend fun getList(): ListTeamResponse
}