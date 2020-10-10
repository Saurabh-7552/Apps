package com.example.testtablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int count;
    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm,behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new ftab1();

            case 1: return new ftab2();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
