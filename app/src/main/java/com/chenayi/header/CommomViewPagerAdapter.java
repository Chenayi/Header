package com.chenayi.header;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenwy on 2018/1/29.
 */

public class CommomViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private String[] mTitles;

    public CommomViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    public CommomViewPagerAdapter(FragmentManager fm, String[] titles, List<Fragment> fragments) {
        super(fm);
        mTitles = titles;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments == null || mFragments.size() <= 0 ? null : mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    public List<Fragment> getFragments() {
        return mFragments == null ? new ArrayList<Fragment>() : mFragments;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null && mTitles.length > 0) {
            return mTitles[position];
        }
        return super.getPageTitle(position);
    }
}
