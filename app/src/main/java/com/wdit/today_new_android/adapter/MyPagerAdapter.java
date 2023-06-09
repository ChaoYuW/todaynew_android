package com.wdit.today_new_android.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {

   private String[] mTitles;
   private ArrayList<Fragment> mFragments;
   public MyPagerAdapter(@NonNull FragmentManager fm, String[] titles, ArrayList<Fragment> fragments) {
      super(fm);
      this.mTitles = titles;
      this.mFragments = fragments;
   }

   @Nullable
   @Override
   public CharSequence getPageTitle(int position) {
      return mTitles[position];
   }

   @NonNull
   @Override
   public Fragment getItem(int position) {
      return mFragments.get(position);
   }

   @Override
   public int getCount() {
      return mFragments.size();
   }
}
