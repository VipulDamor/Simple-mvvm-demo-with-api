package com.eryushion.mvvm_demo_api;

import android.app.Application;
import android.content.Context;

import com.eryushion.mvvm_demo_api.interfaces.AppComponent;
import com.eryushion.mvvm_demo_api.interfaces.DaggerAppComponent;
import com.eryushion.mvvm_demo_api.utils.AppModule;
import com.eryushion.mvvm_demo_api.network.ApiModule;

public class App extends Application {

    AppComponent  appComponent;
    Context app;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).apiModule(new ApiModule()).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }




}
