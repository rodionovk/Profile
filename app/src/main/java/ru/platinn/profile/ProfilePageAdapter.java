package ru.platinn.profile;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodionov on 13.04.2017. Profile
 */

public class ProfilePageAdapter extends PagerAdapter {

    private List<View> mListView;
    private ViewGroup mRootView;

    public ProfilePageAdapter(ViewGroup root){
        mRootView = root;

        mListView = new ArrayList<>();

        View view1 = LayoutInflater.from(root.getContext()).inflate(R.layout.fragment_tab, mRootView, false);
        view1.setTag("Полученные");
        mListView.add(view1);

        View view2 = LayoutInflater.from(root.getContext()).inflate(R.layout.fragment_tab, mRootView, false);
        view2.setTag("Выданные");
        mListView.add(view2);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = mListView.get(position);
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return mListView.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mListView.get(position).getTag().toString();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
