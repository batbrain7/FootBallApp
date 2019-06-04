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

  //  @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Expose(serialize = true, deserialize = false)
    public long idTeam;

    @ColumnInfo(name = "name")
    @Expose(serialize = true, deserialize = false)
    public String clubName;

    @ColumnInfo(name = "shortName")
    @Expose(serialize = true, deserialize = false)
    public String shortName;

    @ColumnInfo(name = "tla")
    @Expose(serialize = true, deserialize = false)
    public String scoreCardName;

    @ColumnInfo(name = "crestUrl")
    @Expose(serialize = true, deserialize = false)
    public String crestUrl;

    @ColumnInfo(name = "address")
    @Expose(serialize = true, deserialize = false)
    public String address;

    @ColumnInfo(name = "phone")
    @Expose(serialize = true, deserialize = false)
    public String phone;

    @ColumnInfo(name = "website")
    @Expose(serialize = true, deserialize = false)
    public String website;

    @ColumnInfo(name = "email")
    @Expose(serialize = true, deserialize = false)
    public String clubEmail;

    @ColumnInfo(name = "founded")
    @Expose(serialize = true, deserialize = false)
    public int clubFounded;

    @ColumnInfo(name = "clubColors")
    @Expose(serialize = true, deserialize = false)
    public String clubColors;

    @ColumnInfo(name = "venue")
    @Expose(serialize = true, deserialize = false)
    public String venue;

    @ColumnInfo(name = "area")
    @Expose(serialize = true, deserialize = false)
    public Area area;
}
