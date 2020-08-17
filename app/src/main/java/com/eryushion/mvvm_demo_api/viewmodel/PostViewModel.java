package com.eryushion.mvvm_demo_api.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eryushion.mvvm_demo_api.network.ApiResponse;
import com.eryushion.mvvm_demo_api.repo.PostRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class PostViewModel extends ViewModel {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<ApiResponse> mutableLiveData = new MutableLiveData<>();
    private PostRepository postRepository;


    public PostViewModel(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public MutableLiveData<ApiResponse> getMutableLiveData() {
        getPosts();
        return mutableLiveData;
    }

    public void getPosts() {
        compositeDisposable.add(postRepository.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> mutableLiveData.setValue(ApiResponse.loading()))
                .subscribe(
                        result -> mutableLiveData.setValue(ApiResponse.success(result)),
                        throwable -> mutableLiveData.setValue(ApiResponse.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }



}
