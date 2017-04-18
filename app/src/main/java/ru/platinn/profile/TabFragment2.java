package ru.platinn.profile;

import android.content.Context;
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
import android.widget.Toast;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

/**
 * Created by rodionov on 18.04.2017. Profile
 */

public class TabFragment2 extends Fragment {

    private final static String KEY = "key";
    private TextView mTextInfo;
    private int mPosition;

    private Navigator navigator;
    private Router mRouter;

    public static TabFragment2 newInstance(int position){

        TabFragment2 fragment = new TabFragment2();

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
        mRouter = new Router();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("PROFILE","fragment "+mPosition+" onCreateView");

        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        mTextInfo = (TextView) view.findViewById(R.id.text_info);

        mTextInfo.setText("Описание " + mPosition);
        mTextInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileApplication.INSTANCE.getRouter().navigateTo("21");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        navigator = new SupportFragmentNavigator(getActivity().getSupportFragmentManager(),R.id.container) {
            @Override
            protected Fragment createFragment(String screenKey, Object data) {
                switch (screenKey){
                    case "21":
                        return TabFragment.newInstance(21);
                    case "22":
                        return TabFragment.newInstance(22);
                    case "23":
                        return TabFragment.newInstance(23);
                    default:
                        throw new RuntimeException("Unknown screen key!");
                }
                //return null;
            }

            @Override
            protected void showSystemMessage(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void exit() {
                getActivity().finish();
            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        ProfileApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    public void onPause() {
        super.onPause();
        ProfileApplication.INSTANCE.getNavigatorHolder().removeNavigator();
    }
}
