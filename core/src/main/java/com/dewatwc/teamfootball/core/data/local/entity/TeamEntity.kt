package com.dewatwc.teamfootball.core.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,

    @ColumnInfo(name = "strTeam")
    var name: String,

    @ColumnInfo(name = "strStadium")
    var stadium: String,

    @ColumnInfo(name = "strTeamBadge")
    var img: String,

    @ColumnInfo(name = "strStadiumDescription")
    var description: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

)