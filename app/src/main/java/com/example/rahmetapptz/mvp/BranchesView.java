package com.example.rahmetapptz.mvp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rahmetapptz.ImageSliderAdapter;
import com.example.rahmetapptz.R;
import com.example.rahmetapptz.days.WeekDay;
import com.example.rahmetapptz.net.RahmetAPI;
import com.example.rahmetapptz.net.WebBranchInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.gujun.android.taggroup.TagGroup;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
    @BindView(R.id.container_tags) TagGroup mContainerTags;
    @BindView(R.id.container_phone_numbers) ViewGroup mContainerPhoneNumbers;
    @BindView(R.id.image_instagram) ImageView mImgInstagram;
    @BindView(R.id.image_vk) ImageView mImgVk;
    @BindView(R.id.image_youtube) ImageView mImgYoutube;
    @BindView(R.id.image_facebook) ImageView mImgFacebook;
    @BindView(R.id.image_twitter) ImageView mImgTwitter;
    @BindView(R.id.imageView) ImageView mImgMap;
    @BindView(R.id.btn_working_hours)
    ImageButton mImgBtnWorkingHours;
    RahmetAPI rahmetAPI;
    List<ImageView> socialNetworks;
    BranchesContract.Presenter<BranchesContract.View> mPresenter;
    ImageSliderAdapter imageSliderAdapter;
    // интенты для перехода при клике на социальную сеть
    Intent twitterIntent;
    Intent facebookIntent;
    Intent vkIntent;
    Intent youtubeIntent;
    Intent instagramIntent;
    Retrofit retrofit;

    @BindView(R.id.view_pager_images) ViewPager mViewPagerImages;
    List<TextView> mListWeekDays;
    List<String> mImagesUrl;
    Double coorlat, coorlng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        ButterKnife.bind(this);
        Log.d("test3", "getbranch");
        Log.d("TEST", "TURN INTO onCreate");

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



        socialNetworks = new ArrayList<ImageView>() {
            {
                add(mImgVk);
                add(mImgInstagram);
                add(mImgYoutube);
                  add(mImgTwitter);
                add(mImgFacebook);
            }
        };
        retrofit = new Retrofit.Builder()
                .baseUrl("https://gateway.choco.kz")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        rahmetAPI = retrofit.create(RahmetAPI.class);

        mPresenter = new BranchesPresenter<>(this,
                new BranchesModel(new WebBranchInfo(rahmetAPI)));

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
        mPresenter.getBranchInfo(114);
        Log.d("test", "asd");
        mViewPagerImages.setAdapter(imageSliderAdapter);


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
        Log.d("name", name);
        mTxtBranchName.setText(name);
    }

    @Override
    public void showBranchCashback(String cashback) {
        mTxtBranchCashbackInfo.setText(cashback);
    }

    @Override
    public void showBranchAddress(String address) {
        mTxtBranchAddress.setText(address);
    }

    @Override
    public void showBranchTodaysWorkingHours(String todaysWorkingHours) {
        mTxtBranchWorkingHours.setText(todaysWorkingHours);
    }

    @Override
    public void showBranchPhoneNumbers(List<String> phoneNumber) {
        LinearLayout.LayoutParams linearLayout = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setMargins(0,10,0,0);
        if(phoneNumber.size()==0){
            phoneNumber.add("No phone!");
        }
        for(String phones : phoneNumber){
            TextView textViewNumber  =new TextView(this);
            textViewNumber.setLayoutParams(linearLayout);
            textViewNumber.setTextColor(getResources().getColor(R.color.phoneNumberColor));
            textViewNumber.setText(phones);
            mContainerPhoneNumbers.addView(textViewNumber);
        }
    }

    @Override
    public void showBranchWebSite(String webSite) {
        mTxtBranchWebSite.setText(webSite);
    }

    @Override
    public void showBranchRating(float rating) {
        mTxtBranchRating.setText(rating+"");
    }

    @Override
    public void showBranchLogo(String urlLogo) {
        Picasso.with(this).load(urlLogo).into(mImgBranchLogo);  // download image and draw
    }

    @Override
    public void showBranchWeekWorkingHours(List<String> weekSchedule) {
        String currentWorkHours;
        for(int i=0; i<weekSchedule.size(); i++){
            currentWorkHours = weekSchedule.get(i);
            mListWeekDays.get(i).setText(currentWorkHours);
            currentWorkHours="";
        }
    }

    @Override
    public void setBranchRegime(boolean isBranchOpen) {
        String branchRegime = isBranchOpen ? "Открыто" : "Закрыто";
        int color = isBranchOpen ? Color.GREEN : Color.RED;
        mTxtBranchMode.setTextColor(color);
        mTxtBranchMode.setText(branchRegime);
    }

    @Override
    public void showBranchTags(List<String> tags) {
        mContainerTags.setTags(tags);
        /*for(String tag : tags){
            mContainerTags.setTag(tag);
        }*/
        Log.d("test", mContainerTags.getChildAt(0).toString()+"");
    }

    @Override
    public void showBranchCounter(String count) {
        mTxtBranchesCounter.setText(count);

    }

    @Override
    public void showReviewsCounter(String count) {
        mTxtReviewsCounter.setText(count);
    }

    @Override
    public void setSocialNetworks(Map<String, String> socialNetworksUrl) {
        for(ImageView view : socialNetworks){
            view.setVisibility(View.GONE);
        }
        for(Map.Entry<String, String> mapEntry : socialNetworksUrl.entrySet()){
            String url = mapEntry.getValue();
            String name = mapEntry.getKey();
            if(url==null){
                continue;
            }
            switch(name.toLowerCase()){
                case "vk":
                    mImgVk.setVisibility(View.VISIBLE);
                    vkIntent.setData(Uri.parse(url));   // ssylka na site
                case "youtube":
                    mImgYoutube.setVisibility(View.VISIBLE);
                    youtubeIntent.setData(Uri.parse(url));
                case "instagram":
                    mImgInstagram.setVisibility(View.VISIBLE);
                    instagramIntent.setData(Uri.parse(url));   // ssylka na site
                case "facebook":
                    mImgFacebook.setVisibility(View.VISIBLE);
                    facebookIntent.setData(Uri.parse(url));
                case "twitter":
                    mImgTwitter.setVisibility(View.VISIBLE);
                    twitterIntent.setData(Uri.parse(url));
            }

        }
    }

    @Override
    public void selectCurrentDay(WeekDay currentDay) {
        TextView currentDayView;
        TextView currentDayLabelView;
        switch (currentDay) {
            case MONDAY:
                currentDayView = mTxtMonday;
                currentDayLabelView = mTxtMondayLabel;
                break;
            case TUESDAY:
                currentDayView = mTxtTuesday;
                currentDayLabelView = mTxtTuesdayLabel;
                break;
            case WEDNESDAY:
                currentDayView = mTxtWednesday;
                currentDayLabelView = mTxtWednesdayLabel;
                break;
            case THURSDAY:
                currentDayView = mTxtThursday;
                currentDayLabelView = mTxtThursdayLabel;
                break;
            case FRIDAY:
                currentDayView = mTxtFriday;
                currentDayLabelView = mTxtFridayLabel;
                break;
            case SATURDAY:
                currentDayView = mTxtSaturday;
                currentDayLabelView = mTxtSaturdayLabel;
                break;
            case SUNDAY:
                currentDayView = mTxtSunday;
                currentDayLabelView = mTxtSundayLabel;
                break;
            default:
                currentDayView = mTxtMonday;
                currentDayLabelView = mTxtMondayLabel;
                break;
        }
        currentDayView.setTypeface(null, Typeface.BOLD);
        currentDayView.setTextColor(Color.BLACK);
        currentDayView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        currentDayLabelView.setTypeface(null, Typeface.BOLD);
        currentDayLabelView.setTextColor(Color.BLACK);
        currentDayLabelView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
    }

    @Override
    public void setCoordinate(double lng, double lat){
        coorlng = lng;
        coorlat = lat;

    }

    @Override
    public void showErrorMessage(String errorMessage) {
            Log.d("sds", errorMessage);
    }



    @OnClick({R.id.image_facebook, R.id.image_vk, R.id.image_twitter, R.id.image_instagram,
            R.id.image_youtube})
    void onSocialNetworkClick(View view){
        switch (view.getId()){
            case R.id.image_youtube:
                startActivity(youtubeIntent);
                break;
            case R.id.image_twitter:
                startActivity(twitterIntent);
                break;
            case R.id.image_instagram:
                startActivity(instagramIntent);
                break;
            case R.id.image_vk:
                startActivity(vkIntent);
                break;
            case R.id.image_facebook:
                startActivity(facebookIntent);
                break;


        }
    }
    @OnClick({R.id.container_working_hours, R.id.container_branches, R.id.container_reviews})
    void OnClick(View view){
        int visibleMode = view.getVisibility();
        switch (view.getId()){
            case R.id.container_working_hours:
                visibleMode = findViewById(R.id.container_working_hours_opened).getVisibility();
                if(visibleMode==View.GONE){
                    visibleMode = View.VISIBLE;
                } else {
                    visibleMode = View.GONE;
                }
                Drawable image;
                if(visibleMode==View.GONE){
                    image = getResources().getDrawable(R.drawable.arrow_open);
                }else{
                    image = getResources().getDrawable(R.drawable.arrow_close);
                }
                mImgBtnWorkingHours.setImageDrawable(image);
                mContainerWorkingHours.setVisibility(visibleMode);
                break;
        }


    }
    @OnClick({R.id.imageView})
    void onClickMap(ImageView imageView){
        Log.d("test", "clickMap");

    }

    @OnClick({R.id.btn_view_all_reviews})
    void onClickBtn(View view){
        Log.d("TEST2", "work");

    }
    @OnClick({R.id.imageView})
    void onClickMap(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:${"+coorlat+"}, ${"+coorlng+"}")));

    }
}
