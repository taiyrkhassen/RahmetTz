package com.example.rahmetapptz.net;

import android.util.Log;

import com.example.rahmetapptz.mvp.BranchInfo;
import com.example.rahmetapptz.pojo.MainObject;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebBranchInfo implements BranchInfo{
    private RahmetAPI mRahmetAPI;

    public WebBranchInfo(RahmetAPI mRahmetAPI) {
        this.mRahmetAPI = mRahmetAPI;
    }

    @Override
    public Observable<MainObject> getInfo(int id) {
        return mRahmetAPI.getBranchesInfo(id);

    }
}
