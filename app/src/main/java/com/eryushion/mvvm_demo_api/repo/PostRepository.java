package com.eryushion.mvvm_demo_api.repo;

import com.eryushion.mvvm_demo_api.interfaces.UsersService;
import com.google.gson.JsonElement;

import javax.inject.Inject;

import io.reactivex.Observable;


public class PostRepository {

    private UsersService usersService;

    @Inject
    public PostRepository(UsersService usersService) {
        this.usersService = usersService;
    }

    public Observable<JsonElement> getPosts(){
        return  usersService.fetchPosts("posts/1");
    }
}
