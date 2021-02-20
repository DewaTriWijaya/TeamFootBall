package com.dewatwc.teamfootball.core.data.local.room

import androidx.room.*
import com.dewatwc.teamfootball.core.data.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {

    @Query("SELECT * FROM team")
    fun getAllTeam(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM team where isFavorite = 1")
    fun getFavoriteTeam(): Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: List<TeamEntity>)

    @Update
    fun updateFavoriteTeam(team: TeamEntity)

}