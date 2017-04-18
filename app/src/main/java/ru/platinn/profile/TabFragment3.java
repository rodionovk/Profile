package ru.platinn.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rodionov on 18.04.2017. Profile
 */

public class TabFragment3 extends Fragment {

    private final static String KEY = "key";
    private TextView mTextInfo;
    private int mPosition;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private ProfileFragmentAdapter mAdapter;

    public static TabFragment3 newInstance(int position){

        TabFragment3 fragment = new TabFragment3();

        Bundle bndl = new Bundle();
        bndl.putInt(KEY, position);

        fragment.setArguments(bndl);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("PROFILE","fragment "+mPosition+" onCreate");

        mPosition = getArguments().getInt(KEY);
        mAdapter = new ProfileFragmentAdapter(getChildFragmentManager());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("PROFILE","fragment "+mPosition+" onCreateView");

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        return view;
    }
}
