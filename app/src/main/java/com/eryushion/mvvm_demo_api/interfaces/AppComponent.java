package com.eryushion.mvvm_demo_api.interfaces;

import com.eryushion.mvvm_demo_api.utils.AppModule;
import com.eryushion.mvvm_demo_api.network.ApiModule;
import com.eryushion.mvvm_demo_api.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, ApiModule.class})
@Singleton
public interface AppComponent {

    void doInjection(MainActivity mainActivity);

}
