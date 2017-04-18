package ru.platinn.profile;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rodionov on 13.04.2017. Profile
 */

public class TabFragment extends Fragment {

    private final static String KEY = "key";

    private TextView mTextInfo;
    private int mPosition;

   /* private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private ProfileFragmentAdapter mAdapter;*/

    public static TabFragment newInstance(int position){

        TabFragment fragment = new TabFragment();

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
        //mAdapter = new ProfileFragmentAdapter(getChildFragmentManager());
        //
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("PROFILE","fragment "+mPosition+" onCreateView");

        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        mTextInfo = (TextView) view.findViewById(R.id.text_info);

        mTextInfo.setText("Описание " + mPosition);

        /*if(mPosition == 1){
            mTextInfo.setText("Описание 1");
        } else if (mPosition == 2) {
            mTextInfo.setText("Описание 2");
        } else if(mPosition == 10){
             mTextInfo.setText("Описание 10");
        } else if(mPosition == 11){
            mTextInfo.setText("Описание 11");
        }else {
            view = inflater.inflate(R.layout.fragment_profile, container, false);

            mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
            mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

            //mAdapter = new ProfileFragmentAdapter(getActivity().getSupportFragmentManager());
            //ProfilePageAdapter adapter = new ProfilePageAdapter(mViewPager);
            mViewPager.setAdapter(mAdapter);


            mTabLayout.setupWithViewPager(mViewPager);
        }*/

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("PROFILE","fragment "+mPosition+" onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("PROFILE","fragment "+mPosition+" onActivityCreated");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.d("PROFILE","fragment "+mPosition+" onAttachFragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("PROFILE","fragment "+mPosition+" onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("PROFILE","fragment "+mPosition+" onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("PROFILE","fragment "+mPosition+" onDestroy");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("PROFILE","fragment "+mPosition+" onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("PROFILE","fragment "+mPosition+" onResume");


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("PROFILE","fragment "+mPosition+" onStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("PROFILE","fragment "+mPosition+" onStop");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("PROFILE","fragment "+mPosition+" onStop");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d("PROFILE","fragment "+mPosition+" onHiddenChanged");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("PROFILE","fragment "+mPosition+" onSaveInstanceState");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("PROFILE","fragment "+mPosition+" onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d("PROFILE","fragment "+mPosition+" onViewStateRestored");
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Log.d("PROFILE","fragment "+mPosition+" onInflate");
    }
    
    
}
