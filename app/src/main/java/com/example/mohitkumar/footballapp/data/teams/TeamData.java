package com.example.mohitkumar.footballapp.data.teams;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
//@Entity(tableName = "teams")
public class TeamData {

//    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
//    @Expose(serialize = false, deserialize = false)
    public long idTeam;

    @ColumnInfo(name = "name")
    public String clubName;

    @ColumnInfo(name = "shortName")
    public String shortName;

    @ColumnInfo(name = "tla")
    public String scoreCardName;

    @ColumnInfo(name = "crestUrl")
    public String crestUrl;

    @ColumnInfo(name = "address")
    public String address;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "website")
    public String website;

    @ColumnInfo(name = "email")
    public String clubEmail;

    @ColumnInfo(name = "founded")
    public int clubFounded;

    @ColumnInfo(name = "clubColors")
    public String clubColors;

    @ColumnInfo(name = "venue")
    public String venue;

    @ColumnInfo(name = "area")
    public Area area;
}
