package com.surdroid.undersrtandingtabs.activity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.surdroid.undersrtandingtabs.R;
import com.surdroid.undersrtandingtabs.fragments.EightFragment;
import com.surdroid.undersrtandingtabs.fragments.FiveFragment;
import com.surdroid.undersrtandingtabs.fragments.FourFragment;
import com.surdroid.undersrtandingtabs.fragments.NineFragment;
import com.surdroid.undersrtandingtabs.fragments.OneFragment;
import com.surdroid.undersrtandingtabs.fragments.SevenFragment;
import com.surdroid.undersrtandingtabs.fragments.SixFragment;
import com.surdroid.undersrtandingtabs.fragments.TenFragment;
import com.surdroid.undersrtandingtabs.fragments.ThreeFragment;
import com.surdroid.undersrtandingtabs.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "ONE");
        adapter.addFrag(new TwoFragment(), "TWO");
        adapter.addFrag(new ThreeFragment(), "THREE");
        adapter.addFrag(new FourFragment(), "FOUR");
        adapter.addFrag(new FiveFragment(), "FIVE");
        adapter.addFrag(new SixFragment(), "SIX");
        adapter.addFrag(new SevenFragment(), "SEVEN");
        adapter.addFrag(new EightFragment(), "EIGHT");
        adapter.addFrag(new NineFragment(), "NINE");
        adapter.addFrag(new TenFragment(), "TEN");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
