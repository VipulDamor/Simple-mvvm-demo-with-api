package com.eryushion.mvvm_demo_api.model.postresponse;

import com.google.gson.annotations.SerializedName;

public class PostResponse{

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	public String title;

	@SerializedName("body")
	public String body;

	@SerializedName("userId")
	public int userId;


}