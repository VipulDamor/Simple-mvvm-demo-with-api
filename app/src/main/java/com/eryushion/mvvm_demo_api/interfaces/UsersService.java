package com.eryushion.mvvm_demo_api.interfaces;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface UsersService {

    @GET
    Observable<JsonElement> fetchPosts(@Url String url);


}
