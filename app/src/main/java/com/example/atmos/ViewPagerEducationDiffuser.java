/*
package com.example.atmos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerEducationDiffuser extends Fragment {
    */
/**
     * The number of pages (wizard steps) to show in this demo.
     *//*

    private static final int NUM_PAGES = 4;

    */
/**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     *//*

    private ViewPager mPager;

    */
/**
     * The pager adapter, which provides the pages to the view pager widget.
     *//*

    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    */
/**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     *//*

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new DiffuserFragment1();
                case 1:
                    return new DiffuserFragment2();
                case 2:
                    return new DiffuserFragment3();
                case 3:
                    return new DiffuserFragment4();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
*/
