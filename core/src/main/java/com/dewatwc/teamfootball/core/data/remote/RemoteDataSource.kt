package com.dewatwc.teamfootball.core.data.remote

import android.util.Log
import com.dewatwc.teamfootball.core.data.remote.network.ApiResponse
import com.dewatwc.teamfootball.core.data.remote.network.ApiService
import com.dewatwc.teamfootball.core.data.remote.response.TeamResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllTeam(): Flow<ApiResponse<List<TeamResponse>>> {
        return flow{
            try{
                val response = apiService.getList()
                val dataArray = response.teams
                if(dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.teams))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}