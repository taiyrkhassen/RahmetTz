package com.example.rahmetapptz.interfaces_mvp;
public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
