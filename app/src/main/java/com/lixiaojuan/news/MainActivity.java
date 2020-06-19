package com.lixiaojuan.news;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.lixiaojuan.news.Fragment.ArticleFragment;
import com.lixiaojuan.news.Fragment.PersonalFragment;
import com.lixiaojuan.news.Fragment.PictureFragment;
import com.lixiaojuan.news.adapter.MyFragmentAdapter;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList fragments;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        viewPager=findViewById(R.id.myViewPager);
        fragments=new ArrayList<Fragment>();
        Fragment articleFragment =new ArticleFragment();
        Fragment pictureFragment=new PictureFragment();
        Fragment personalFragment=new PersonalFragment();
        fragments.add(articleFragment);
        fragments.add(pictureFragment);
        fragments.add(personalFragment);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);
    }
}
