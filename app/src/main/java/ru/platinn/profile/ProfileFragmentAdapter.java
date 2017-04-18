package ru.platinn.profile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by rodionov on 13.04.2017. Profile
 */

public class ProfileFragmentAdapter extends FragmentStatePagerAdapter {

    public ProfileFragmentAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(position + 10);
    }



    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "Полученные";
        } else {
            return "Выданные";
        }
    }
}
