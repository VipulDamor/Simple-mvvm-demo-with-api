package com.eryushion.mvvm_demo_api.network;

import com.eryushion.mvvm_demo_api.interfaces.UsersService;
import com.eryushion.mvvm_demo_api.interfaces.AppConstant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class ApiFactory implements AppConstant {

    public static UsersService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(UsersService.class);
    }

}
