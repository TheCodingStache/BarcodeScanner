package com.example.scanner.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrieveData {
//    @GET("http://35.223.118.133/api/getitemfindataviabarcode")
//    Call<Warehouse> getWarehouse(@Query("warehouse") String code);
//    @POST("")
//    Call <Item> postBarcodeDetails(@Field("userID") String userID, @Field("token") String token);
//    @Headers("userID : 17E9817988718E7187E710E")
//    @GET("/data/2.1/user")
//    Call <Warehouse> fetchUserDetails();
@FormUrlEncoded
@POST("/getitemfindataviabarcode")
    Call<List<Warehouse>> getWarehouse();
}