package com.dnu.loi.smartrm.ui.normal.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Mô tả:
 * <p>
 * Created by loi on 04/04/2018.
 */

class MainPagerAdapter extends FragmentStatePagerAdapter {

    private IOnInitPageItem onInitPageItem;
    private int pageSize;

    MainPagerAdapter(FragmentManager fm, int pageSize, IOnInitPageItem onInitPageItem) {
        super(fm);
        this.onInitPageItem = onInitPageItem;
        this.pageSize = pageSize;
    }

    @Override
    public Fragment getItem(int position) {
       return onInitPageItem.setPageItem(position);
    }

    @Override
    public int getCount() {
        return pageSize;
    }

    interface IOnInitPageItem {
        Fragment setPageItem(int position);
    }
}
