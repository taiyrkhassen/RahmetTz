package com.example.rahmetapptz.net;

import com.example.rahmetapptz.pojo.MainObject;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RahmetAPI {

    @GET("/partner/v2/filials/card/id/{id}")
    //Call<MainObject> getBranchesInfo(@Path("id") int branchId);
    Observable<MainObject> getBranchesInfo(@Path("id") int branchId);
}
