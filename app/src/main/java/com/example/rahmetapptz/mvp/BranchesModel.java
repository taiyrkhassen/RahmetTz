package com.example.rahmetapptz.mvp;


import com.example.rahmetapptz.pojo.MainObject;

import io.reactivex.Observable;

public class BranchesModel implements BranchesContract.Model{
    private BranchInfo branchInfo;

    public BranchesModel(BranchInfo branchInfo){
        this.branchInfo = branchInfo;
    }


    @Override
    public Observable<MainObject> getBranchInfo(int branchId) {
        return branchInfo.getInfo(branchId);
    }
}
