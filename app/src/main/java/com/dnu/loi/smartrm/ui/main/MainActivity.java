package com.dnu.loi.smartrm.ui.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.dnu.loi.smartrm.R;
import com.dnu.loi.smartrm.ui.base.BaseActivity;
import com.dnu.loi.smartrm.ui.more.MoreFragment;
import com.dnu.loi.smartrm.ui.notifications.NotificationsFragment;
import com.dnu.loi.smartrm.ui.ordermanage.OrderManageFragment;
import com.dnu.loi.smartrm.ui.tablemap.TableMapFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener, MainPagerAdapter.IOnInitPageItem {

    private ViewPager mPager;
    private BottomNavigationView navigation;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void mappingView() {
        navigation = findViewById(R.id.navigation);
        mPager = findViewById(R.id.vpgMain);

    }

    @Override
    protected void onBindView() {

    }

    @Override
    protected void setViewEvent() {
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager(), 4, this);
        mPager.setAdapter(adapter);
        mPager.addOnPageChangeListener(this);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onActivityDestroy() {

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return setDisplaySelected(item.getItemId());
    }

    private boolean setDisplaySelected(int id) {
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

        return false;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                setTitle(R.string.title_order);
                navigation.setSelectedItemId(R.id.nav_order);
                break;
            case 1:
                setTitle(R.string.title_map);
                navigation.setSelectedItemId(R.id.nav_map);
                break;
            case 2:
                setTitle(R.string.title_notifications);
                navigation.setSelectedItemId(R.id.nav_notifications);
                break;
            case 3:
                setTitle(R.string.title_more);
                navigation.setSelectedItemId(R.id.nav_more);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public Fragment setPageItem(int position) {
        Fragment fragment=null;

        switch (position){
            case 0:
                fragment=new OrderManageFragment();
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
