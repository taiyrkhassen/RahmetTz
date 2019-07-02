package com.example.rahmetapptz.mvp;

import android.nfc.Tag;
import android.util.Log;

import com.example.rahmetapptz.DateUtils;
import com.example.rahmetapptz.days.WeekDay;
import com.example.rahmetapptz.interfaces_mvp.BaseView;
import com.example.rahmetapptz.pojo.Data;
import com.example.rahmetapptz.pojo.Hashtag;
import com.example.rahmetapptz.pojo.MainObject;
import com.example.rahmetapptz.pojo.Regime;
import com.example.rahmetapptz.pojo.SocialNetworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import rx.Scheduler;
import rx.Scheduler;
public class BranchesPresenter<V extends BranchesContract.View>
        implements BranchesContract.Presenter<V>{
    private V mView;
    private BranchesContract.Model mModel;

    public BranchesPresenter(V mView, BranchesContract.Model mModel) {
        this.mView = mView;
        this.mModel = mModel;
    }
    SocialNetworks socialNetworks;
    MainObject mainObject;

    @Override
    public void getBranchInfo(int branchId) {
        mModel.getBranchInfo(branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    this::getThisBranch, // this  ssylka na danny metod
                        error -> Log.d("Error", error.getLocalizedMessage() + " " + error.getCause()),
                        () -> Log.d("success", "completed")
                );   /* new DisposableObserver<MainObject>() {  // tak kak observable prinimaet objects MainObject
                        @Override public void onNext(MainObject mainObject) { … }
                        @Override public void onComplete() { … }   // argumenta net
                        @Override public void onError(Throwable t) { … }*/ // oshibka peredaetsya
    }


    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    private void getThisBranch(MainObject mainObject){
        Data data = mainObject.getData();
        String name     = data.getName();
        String cashback = "Кэшбэк " + data.getRule().getCashback() + "%";
        String address  = data.getAddress().getAddress();
        String webSite  = data.getPartner().getWebsiteUrl();
        String logoUrl  = data.getPartner().getLogotypeUrl();
        float rating                  = data.getRating().getMark();
        List<Regime> listRegime       = data.getRegime();
        List<String> weekWorkingHours = weekWorkHours(data.getRegime());
        List<String> phoneNumbers     = data.getPhones();
        List<String> imagesUrl        = data.getImages();
        String todaysWorkingHours     = TodaysWorkingHours(data.getRegime());
        boolean isBranchOpen          = CurrentRegimeMode(listRegime);
        List<Hashtag> listTag         = data.getHashtags();
        List<String> tags             = TitleToTag(listTag);
        int branchesCounter           = data.getPartner().getFilials().size();
        int reviewsCounter            = 4; // no reviews in backend
        WeekDay currentDay             = WeekDay.values()[DateUtils.getCurrentDayOfWeek()-1];
        SocialNetworks socialNetworks         = data.getPartner().getSocialNetworks();
        Map<String, String> mapSocialNetworks = new HashMap<>();
        if(socialNetworks != null)
            mapSocialNetworks = mapToSocialNetworks();
        webSite = webSite == null ? "Веб сайт не указан" : webSite;

        mView.showBranchImages(imagesUrl);
        mView.showBranchName(name);
        mView.showBranchCashback(cashback);
        mView.showBranchAddress(address);
        mView.showBranchTodaysWorkingHours(todaysWorkingHours);
        mView.showBranchPhoneNumbers(phoneNumbers);
        mView.showBranchWebSite(webSite);
        mView.showBranchRating(rating);
        mView.showBranchLogo(logoUrl);
        mView.showBranchWeekWorkingHours(weekWorkingHours);
        mView.setBranchRegime(isBranchOpen);
        mView.showBranchTags(tags);
        mView.showBranchCounter(String.valueOf(branchesCounter));
        mView.showReviewsCounter(String.valueOf(reviewsCounter));
        mView.setSocialNetworks(mapSocialNetworks);
        mView.selectCurrentDay(currentDay);

    }


    private List<String> weekWorkHours(List<Regime> listRegime){
        List<String> mappedList = new ArrayList<>();
        for(Regime r : listRegime){
            mappedList.add(r.getStart() + " - " + r.getEnd());
        }
        return mappedList;
    }

    private List<String> TitleToTag(List<Hashtag> listTag){
        List<String> titles = new ArrayList<>();
        for(Hashtag h : listTag){
            titles.add(h.getName());
        }
        return titles;
    }

    private Regime CurrentDayRegime(List<Regime> listRegime){
        int currentDay = com.example.rahmetapptz.DateUtils.getCurrentDayOfWeek() - 1;
        for(Regime r : listRegime){
            if(r.getDay() == currentDay){
                return r;
            }
        }
        return null;
    }
    private String TodaysWorkingHours(List<Regime> regime) {
        Regime currentRegime = CurrentDayRegime(regime);
        String workingHours = "";
        if(currentRegime != null)
            workingHours = currentRegime.getStart() + " - " + currentRegime.getEnd();
        return workingHours;
    }
    private boolean CurrentRegimeMode(List<Regime> listRegime) {
        Regime regime = CurrentDayRegime(listRegime);
        if(regime == null)
            return false;
        return DateUtils.isCurrentDateInInterval(regime.getStart(), regime.getEnd());
    }

    private Map<String, String> mapToSocialNetworks() {
        Map<String, String> mapSocialNetworks = new HashMap<>();
        mapSocialNetworks.put("instagram", socialNetworks.getInstagram());
        mapSocialNetworks.put("vk", socialNetworks.getVk());
        mapSocialNetworks.put("youtube", socialNetworks.getYoutube());
        mapSocialNetworks.put("twitter", socialNetworks.getTwitter());
        mapSocialNetworks.put("facebook", socialNetworks.getFacebook());
        return mapSocialNetworks;
    }


}
