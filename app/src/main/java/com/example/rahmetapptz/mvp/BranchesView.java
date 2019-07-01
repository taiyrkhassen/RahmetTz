package com.example.rahmetapptz.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rahmetapptz.ImageSliderAdapter;
import com.example.rahmetapptz.R;
import com.example.rahmetapptz.days.WeekDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BranchesView extends AppCompatActivity implements BranchesContract.View {
    // textviews
    @BindView(R.id.text_branch_name)
    TextView mTxtBranchName;
    @BindView(R.id.text_branch_cashback) TextView mTxtBranchCashbackInfo;
    @BindView(R.id.text_address) TextView mTxtBranchAddress;
    @BindView(R.id.text_working_hours)TextView mTxtBranchWorkingHours;
    @BindView(R.id.text_website) TextView mTxtBranchWebSite;
    @BindView(R.id.text_rating) TextView mTxtBranchRating;
    @BindView(R.id.text_branch_mode) TextView mTxtBranchMode;
    @BindView(R.id.text_count_images) TextView mTxtImagesCounter;
    @BindView(R.id.text_branches_count) TextView mTxtBranchesCounter;
    @BindView(R.id.text_reviews_count) TextView mTxtReviewsCounter;
    //images
    @BindView(R.id.image_branch_logo)
    ImageView mImgBranchLogo;
    // textview week schedule
    @BindView(R.id.text_monday_hours) TextView mTxtMonday;
    @BindView(R.id.text_tuesday_hours) TextView mTxtTuesday;
    @BindView(R.id.text_wednesday_hours) TextView mTxtWednesday;
    @BindView(R.id.text_thursday_hours) TextView mTxtThursday;
    @BindView(R.id.text_friday_hours) TextView mTxtFriday;
    @BindView(R.id.text_saturday_hours) TextView mTxtSaturday;
    @BindView(R.id.text_sunday_hours) TextView mTxtSunday;
    @BindView(R.id.text_monday) TextView mTxtMondayLabel;
    @BindView(R.id.text_tuesday) TextView mTxtTuesdayLabel;
    @BindView(R.id.text_wednesday) TextView mTxtWednesdayLabel;
    @BindView(R.id.text_thursday) TextView mTxtThursdayLabel;
    @BindView(R.id.text_friday) TextView mTxtFridayLabel;
    @BindView(R.id.text_saturday) TextView mTxtSaturdayLabel;
    @BindView(R.id.text_sunday) TextView mTxtSundayLabel;

    // containers
    @BindView(R.id.container_working_hours_opened) ViewGroup mContainerWorkingHours;
    @BindView(R.id.container_tags) ViewGroup mContainerTags;
    @BindView(R.id.container_phone_numbers) ViewGroup mContainerPhoneNumbers;

    @BindView(R.id.image_instagram) ImageView mImgInstagram;
    @BindView(R.id.image_vk) ImageView mImgVk;
    @BindView(R.id.image_youtube) ImageView mImgYoutube;
    @BindView(R.id.image_facebook) ImageView mImgFacebook;
    @BindView(R.id.image_twitter) ImageView mImgTwitter;
    @BindView(R.id.btn_working_hours)
    ImageButton mImgBtnWorkingHours;

    List<ImageView> socialNetworks;
    BranchesContract.Presenter<BranchesContract.View> mPresenter;
    ImageSliderAdapter imageSliderAdapter;
    // интенты для перехода при клике на социальную сеть
    Intent twitterIntent;
    Intent facebookIntent;
    Intent vkIntent;
    Intent youtubeIntent;
    Intent instagramIntent;

    @BindView(R.id.view_pager_images) ViewPager mViewPagerImages;
    List<TextView> mListWeekDays;
    List<String> mImagesUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        ButterKnife.bind(this);
        mListWeekDays = new ArrayList<TextView>(){
            {
                add(mTxtMonday);
                add(mTxtTuesday);
                add(mTxtWednesday);
                add(mTxtThursday);
                add(mTxtFriday);
                add(mTxtSaturday);
                add(mTxtSunday);
            }
        };
        mPresenter = new BranchesPresenter<>(this, new BranchesModel()); //?(
        socialNetworks = new ArrayList<ImageView>() {
            {
                add(mImgVk);
                add(mImgInstagram);
                add(mImgYoutube);
                add(mImgTwitter);
                add(mImgFacebook);
            }
        };

        facebookIntent = new Intent();
        vkIntent = new Intent();
        twitterIntent = new Intent();
        youtubeIntent = new Intent();
        instagramIntent = new Intent();

        facebookIntent.setAction(Intent.ACTION_VIEW);
        facebookIntent.addCategory(Intent.CATEGORY_BROWSABLE);

        vkIntent.setAction(Intent.ACTION_VIEW);
        vkIntent.addCategory(Intent.CATEGORY_BROWSABLE);

        twitterIntent.setAction(Intent.ACTION_VIEW);
        twitterIntent.addCategory(Intent.CATEGORY_BROWSABLE);

        youtubeIntent.setAction(Intent.ACTION_VIEW);
        youtubeIntent.addCategory(Intent.CATEGORY_BROWSABLE);

        instagramIntent.setAction(Intent.ACTION_VIEW);
        instagramIntent.addCategory(Intent.CATEGORY_BROWSABLE);

        mImagesUrl = new ArrayList<>();
        imageSliderAdapter = new ImageSliderAdapter(this);

        imageSliderAdapter.setImagesUrl(mImagesUrl);
        mViewPagerImages.setAdapter(imageSliderAdapter);

        mPresenter.getBranchInfo(157);
    }



    @Override
    public void showBranchImages(List<String> imagesUrl) {
        this.mImagesUrl = imagesUrl;
        imageSliderAdapter.setImagesUrl(imagesUrl);
        mViewPagerImages.setAdapter(imageSliderAdapter);
        imageSliderAdapter.notifyDataSetChanged();
    }

    @Override
    public void showBranchName(String name) {

    }

    @Override
    public void showBranchCashback(String cashback) {

    }

    @Override
    public void showBranchAddress(String address) {

    }

    @Override
    public void showBranchTodaysWorkingHours(String todaysWorkingHours) {

    }

    @Override
    public void showBranchPhoneNumbers(List<String> phoneNumber) {

    }

    @Override
    public void showBranchWebSite(String webSite) {

    }

    @Override
    public void showBranchRating(float rating) {

    }

    @Override
    public void showBranchLogo(String urlLogo) {

    }

    @Override
    public void showBranchWeekWorkingHours(List<String> weekSchedule) {

    }

    @Override
    public void setBranchRegime(boolean isBranchOpen) {

    }

    @Override
    public void showBranchTags(List<String> tags) {

    }

    @Override
    public void showBranchCounter(String count) {

    }

    @Override
    public void showReviewsCounter(String count) {

    }

    @Override
    public void setSocialNetworks(Map<String, String> socialNetworksUrl) {

    }

    @Override
    public void selectCurrentDay(WeekDay currentDay) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }
}
