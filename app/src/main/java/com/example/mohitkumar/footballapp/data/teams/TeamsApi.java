package com.example.mohitkumar.footballapp.data.teams;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TeamsApi {

    @GET("/{id}/teams")
    Observable<TeamResponse> getTeams(@Path("id") int id);
}
