package com.example.alexr.ideamanager.services;

import com.example.alexr.ideamanager.models.Idea;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IdeaService {
    //@Headers("Accept-Language: en-US")
    @GET("ideas")
    Call<List<Idea>> getIdeas();

    @GET("ideas/{id}")
    Call<Idea> getIdea(@Path("id")int id);

    @POST("ideas")
    Call<Idea> createIdea(@Body Idea newIdea);

    @FormUrlEncoded
    @PUT("ideas/{id}")
    Call<Idea> updateIdea(
            @Path("id") int id,
            @Field("name")String name,
            @Field("description")String desc,
            @Field("owner")String owner,
            @Field("status")String status
    );

    @DELETE("ideas/{id}")
    Call<Void> deleteIdea(@Path("id")int id);
}
