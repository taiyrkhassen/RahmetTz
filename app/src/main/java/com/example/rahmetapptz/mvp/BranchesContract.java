package com.example.rahmetapptz.mvp;

import com.example.rahmetapptz.days.WeekDay;
import com.example.rahmetapptz.interfaces_mvp.BasePresenter;
import com.example.rahmetapptz.interfaces_mvp.BaseView;
import com.example.rahmetapptz.pojo.MainObject;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

public interface BranchesContract {
    interface View extends BaseView{
        void showBranchImages(List<String> imagesUrl);
        void showBranchName(String name);
        void showBranchCashback(String cashback);
        void showBranchAddress(String address);
        void showBranchTodaysWorkingHours(String todaysWorkingHours);
        void showBranchPhoneNumbers(List<String> phoneNumber);
        void showBranchWebSite(String webSite);
        void showBranchRating(float rating);
        void showBranchLogo(String urlLogo);
        void showBranchWeekWorkingHours(List<String> weekSchedule);
        void setBranchRegime(boolean isBranchOpen);
        void showBranchTags(List<String> tags);
        void showBranchCounter(String count);
        void showReviewsCounter(String count);
        void setSocialNetworks(Map<String, String> socialNetworksUrl);
        void selectCurrentDay(WeekDay currentDay);
    }

    interface Presenter<V extends BaseView> extends BasePresenter<V>{
        void getBranchInfo(int branchId);
    }

    interface Model{
        Observable<MainObject> getBranchInfo(int branchId);
    }
}
