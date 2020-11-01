package com.example.testnavigationdrawer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentManager extends FragmentPagerAdapter {
    private int count;

    public FragmentManager(@NonNull androidx.fragment.app.FragmentManager fm, int behavior) {
        super(fm, behavior);
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
