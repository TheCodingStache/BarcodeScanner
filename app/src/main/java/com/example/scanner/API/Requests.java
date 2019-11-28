package com.example.scanner.API;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;



public interface Requests {
    ////    @POST("/bank")
////    Call<Warehouse> createPost(@Body Warehouse warehouse);
////
////    @FormUrlEncoded
////    @POST("/bank")
////    Call<Warehouse> createPost(
////            @Field("barcode") String code
//    );
//@GET(""http://35.223.118.133/api/getitemfindataviabarcode)
//Call<Warehouse> getWarehouse(@Query("warehouse") String code);
//    @POST("")
//    Call <Item> postBarcodeDetails(@Field("userID") String userID, @Field("token") String token);
//    @Headers("userID : 17E9817988718E7187E710E")
//    @GET("/data/2.1/user")
//    Call <Warehouse> fetchUserDetails();
    @POST("api/getitemfindataviabarcode")
    Call<Item[]> data(
            @Body JsonObject jsonObject);
}
