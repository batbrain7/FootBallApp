package com.example.mohitkumar.footballapp.data.teams;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class Competition {

//    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
//    @Expose(serialize = false, deserialize = false)
    public long idCompetition;

    @ColumnInfo(name = "name")
    public String leagueName;

    @ColumnInfo(name = "code")
    public String leagueCode;

    @ColumnInfo(name = "plan")
    public String leagueType;

    @ColumnInfo(name = "area")
    public Area area;

}
