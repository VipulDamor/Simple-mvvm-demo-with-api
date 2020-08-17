package com.eryushion.mvvm_demo_api.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eryushion.mvvm_demo_api.enums.Status;
import com.google.gson.JsonElement;

import static com.eryushion.mvvm_demo_api.enums.Status.ERROR;
import static com.eryushion.mvvm_demo_api.enums.Status.LOADING;
import static com.eryushion.mvvm_demo_api.enums.Status.SUCCESS;

public class ApiResponse {

    public final Status status;

    @Nullable
    public final JsonElement data;

    @Nullable
    public final Throwable error;

    private ApiResponse(Status status, @Nullable JsonElement data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static ApiResponse loading() {
        return new ApiResponse(LOADING, null, null);
    }

    public static ApiResponse success(@NonNull JsonElement data) {
        return new ApiResponse(SUCCESS, data, null);
    }

    public static ApiResponse error(@NonNull Throwable error) {
        return new ApiResponse(ERROR, null, error);
    }
}
