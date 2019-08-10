package com.ricoapps.fitfriend

import androidx.room.ColumnInfo

data class CurrentSet (
    @ColumnInfo(name = "weight")
    var weight: Double,
    @ColumnInfo(name = "rep_count")
    var repCount: Double
)