package com.example.rahmetapptz.mvp;



import com.example.rahmetapptz.pojo.MainObject;

import io.reactivex.Observable;

public interface BranchInfo  {
    Observable<MainObject> getInfo(int id);
}
