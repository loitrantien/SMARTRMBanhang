package com.dnu.loi.smartrm.ui.normal.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.common.CommonApp;
import com.dnu.loi.smartrm.common.ScreenApp;
import com.dnu.loi.smartrm.ui.base.BaseActivity;
import com.dnu.loi.smartrm.ui.normal.more.MoreFragment;
import com.dnu.loi.smartrm.ui.normal.notifications.NotificationsFragment;
import com.dnu.loi.smartrm.ui.normal.ordermanage.OrderManageFragment;
import com.dnu.loi.smartrm.ui.normal.tablemap.TableMapFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, MainPagerAdapter.IOnInitPageItem {

    private ViewPager mPager;
    private BottomNavigationView navigation;
    private FrameLayout frNavMenu, frContainer;
    private TextView tvTitle;
    private ImageView ivSile;
    private DrawerLayout mDrawerLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void mappingView() {
        if (CommonApp.SCREEN == ScreenApp.Normal) {
            navigation = findViewById(R.id.navigation);
            mPager = findViewById(R.id.vpgMain);
        } else {
            frNavMenu = findViewById(R.id.frNavMenu);
            frContainer = findViewById(R.id.frContainer);
            tvTitle = findViewById(R.id.tvTitle);
            ivSile = findViewById(R.id.ivSlide);
            mDrawerLayout = findViewById(R.id.dwMain);
        }
    }

    @Override
    protected void onBindView() {
        if (CommonApp.SCREEN == ScreenApp.Large) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frNavMenu, MoreFragment.newInstance(v -> setDisplaySelected(v.getId())))
                    .commit();
            setDisplaySelected(R.id.nav_order);
        }

    }

    @Override
    protected void setViewEvent() {
        if (CommonApp.SCREEN == ScreenApp.Normal) {
            MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), 4, this);
            mPager.setAdapter(adapter);
            mPager.addOnPageChangeListener(this);
            navigation.setOnNavigationItemSelectedListener(this);

        }else {
            ivSile.setOnClickListener(v -> mDrawerLayout.openDrawer(Gravity.START));
        }
    }

    @Override
    protected void onActivityDestroy() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return setDisplaySelected(item.getItemId());
    }

    private boolean setDisplaySelected(int id) {
        if (CommonApp.SCREEN == ScreenApp.Normal) {

            switch (id) {
                case R.id.nav_order:
                    mPager.setCurrentItem(0);
                    return true;
                case R.id.nav_map:
                    mPager.setCurrentItem(1);
                    return true;
                case R.id.nav_notifications:
                    mPager.setCurrentItem(2);
                    return true;
                case R.id.nav_more:
                    mPager.setCurrentItem(3);
                    return true;
            }
        } else {
            Fragment fragment = null;
            switch (id) {
                case R.id.nav_order:
                    tvTitle.setText(R.string.title_order);
                    fragment = OrderManageFragment.newInstance(() -> setDisplaySelected(R.id.nav_map));
                    break;
                case R.id.nav_map:
                    tvTitle.setText(R.string.title_map);
                    fragment = new TableMapFragment();
                    break;
                case R.id.nav_notifications:
                    tvTitle.setText(R.string.title_notifications);
                    fragment = new NotificationsFragment();
                    break;
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frContainer, fragment)
                    .commit();
        }

        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                navigation.setSelectedItemId(R.id.nav_order);
                break;
            case 1:
                navigation.setSelectedItemId(R.id.nav_map);
                break;
            case 2:
                navigation.setSelectedItemId(R.id.nav_notifications);
                break;
            case 3:
                navigation.setSelectedItemId(R.id.nav_more);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public Fragment setPageItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = OrderManageFragment.newInstance(() -> mPager.setCurrentItem(1));
                break;
            case 1:
                fragment = new TableMapFragment();
                break;
            case 2:
                fragment = new NotificationsFragment();
                break;
            case 3:
                fragment = new MoreFragment();
                break;
        }

        return fragment;
    }
}
