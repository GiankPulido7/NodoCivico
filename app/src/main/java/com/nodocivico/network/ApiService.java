package com.nodocivico.network;

import com.nodocivico.models.Report;
import com.nodocivico.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * ApiService - Interfaz de servicios REST
 * Define los endpoints de la API
 * Lista para implementar en siguiente entregable
 */
public interface ApiService {

    // Endpoints de Usuario
    @POST("api/login")
    Call<User> login(@Body User user);

    @GET("api/users/{id}")
    Call<User> getUser(@Path("id") int userId);

    @PUT("api/users/{id}")
    Call<User> updateUser(@Path("id") int userId, @Body User user);

    // Endpoints de Reportes
    @GET("api/reports")
    Call<List<Report>> getAllReports();

    @GET("api/reports/{id}")
    Call<Report> getReport(@Path("id") int reportId);

    @POST("api/reports")
    Call<Report> createReport(@Body Report report);

    @PUT("api/reports/{id}")
    Call<Report> updateReport(@Path("id") int reportId, @Body Report report);
}