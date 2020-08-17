package com.eryushion.mvvm_demo_api.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.eryushion.mvvm_demo_api.App;
import com.eryushion.mvvm_demo_api.R;
import com.eryushion.mvvm_demo_api.databinding.ActivityMainBinding;
import com.eryushion.mvvm_demo_api.model.postresponse.PostResponse;
import com.eryushion.mvvm_demo_api.network.ApiResponse;
import com.eryushion.mvvm_demo_api.utils.ViewModelFactory;
import com.eryushion.mvvm_demo_api.viewmodel.PostViewModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    PostViewModel postViewModel;
    ActivityMainBinding activityMainBinding;

    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        ((App) getApplication()).getAppComponent().doInjection(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading please wait....!!!!");
        postViewModel = ViewModelProviders.of(this,viewModelFactory).get(PostViewModel.class);
        postViewModel.getMutableLiveData().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                setdata(apiResponse);

            }
        });
    }

    private void setdata(ApiResponse apiResponse) {
        switch (apiResponse.status){
            case ERROR:
                progressDialog.dismiss();
                break;
            case LOADING:
                progressDialog.show();

                break;
            case SUCCESS:
                progressDialog.dismiss();
                assert apiResponse.data != null;
                setDataToView(apiResponse.data);
                break;
        }
    }

    private void setDataToView(JsonElement data) {
        PostResponse postResponse = new Gson().fromJson(data.toString(),PostResponse.class);
        activityMainBinding.setPost(postResponse);
    }
}