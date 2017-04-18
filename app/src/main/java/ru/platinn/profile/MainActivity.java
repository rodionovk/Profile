package ru.platinn.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //private FrameLayout mContainer;
    private TextView mTab1;
    private TextView mTab2;
    private TextView mTab3;

    private FragmentManager mFragmentManager;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("PROFILE","MainActivity onCreate");

        //mContainer = (FrameLayout) findViewById(R.id.container);
        mTab1 = (TextView) findViewById(R.id.text_tab1);
        mTab2 = (TextView) findViewById(R.id.text_tab2);
        mTab3 = (TextView) findViewById(R.id.text_tab3);

        mTab1.setOnClickListener(this);
        mTab2.setOnClickListener(this);
        mTab3.setOnClickListener(this);

        mFragmentManager = getSupportFragmentManager();
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(),R.id.container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey){
                case "1":
                    return TabFragment.newInstance(1);
                case "2":
                    return TabFragment2.newInstance(2);
                case "3":
                    return TabFragment3.newInstance(3);
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
            //return null;
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("PROFILE","MainActivity onResume");
        ProfileApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("PROFILE","MainActivity onPause");
        ProfileApplication.INSTANCE.getNavigatorHolder().removeNavigator();
    }

    @Override
    public void onClick(View v) {



        switch (v.getId()) {
            case R.id.text_tab1:
                ProfileApplication.INSTANCE.getRouter().replaceScreen("1");
                //mFragment = TabFragment.newInstance(1);
                break;
            case R.id.text_tab2:
                ProfileApplication.INSTANCE.getRouter().replaceScreen("2");
                //mFragment = TabFragment.newInstance(2);
                break;
            case R.id.text_tab3:
                ProfileApplication.INSTANCE.getRouter().replaceScreen("3");
                //mFragment = TabFragment.newInstance(3);
                break;
        }

        /*mFragmentManager.beginTransaction()
                .replace(R.id.container, mFragment)
                .addToBackStack(null)
                .commit();*/
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("PROFILE","MainActivity onSaveInstanceState");
    }

    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
        Log.d("PROFILE","MainActivity onChildTitleChanged");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("PROFILE","MainActivity onRestart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("PROFILE","MainActivity onRestoreInstanceState");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("PROFILE","MainActivity onAttachedToWindow");
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d("PROFILE","MainActivity onAttachFragment");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("PROFILE","MainActivity onDetachedFromWindow");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("PROFILE","MainActivity onPostCreate");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.d("PROFILE","MainActivity onRestoreInstanceState persistentState");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("PROFILE","MainActivity onWindowFocusChanged");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("PROFILE","MainActivity onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("PROFILE","MainActivity onNewIntent");
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        Log.d("PROFILE","MainActivity onPause");
    }*/

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("PROFILE","MainActivity onPostResume");
    }

    /*@Override
    protected void onResume() {
        super.onResume();

    }*/

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        Log.d("PROFILE","MainActivity onResumeFragments");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("PROFILE","MainActivity onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("PROFILE","MainActivity onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("PROFILE","MainActivity onStop");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d("PROFILE","MainActivity onBackPressed");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d("PROFILE","MainActivity onAttachFragment 2");
    }


}
