package com.eryushion.mvvm_demo_api.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.eryushion.mvvm_demo_api.repo.PostRepository;
import com.eryushion.mvvm_demo_api.viewmodel.PostViewModel;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {

    PostRepository postRepository;

    @Inject
    public ViewModelFactory(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PostViewModel.class)){
            return (T) new PostViewModel(postRepository);
        }
        throw new IllegalArgumentException("un known class");
    }
}
