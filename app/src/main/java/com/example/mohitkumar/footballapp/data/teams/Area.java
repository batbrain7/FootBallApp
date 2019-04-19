package com.example.mohitkumar.footballapp.data.teams;

import android.arch.persistence.room.ColumnInfo;

import lombok.Data;

@Data
public class Area {

    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String countryName;

}
