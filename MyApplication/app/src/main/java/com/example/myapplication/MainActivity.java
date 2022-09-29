package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Fragment mfind_Wechat = new find_wechat();
    private Fragment mfind_Contacts = new find_contacts();
    private Fragment mfind_Discover = new find_discover();
    private Fragment mfind_Myself = new find_myself();

    private LinearLayout mWechat_text;
    private LinearLayout mContacts_text;
    private LinearLayout mDiscover_text;
    private LinearLayout mMyself_text;

    private ImageButton mWechat_img;
    private ImageButton mContacts_img;
    private ImageButton mDiscover_img;
    private ImageButton mMyself_img;

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment(); //添加界面
        initView(); //视图选择
        initEvent(); //时间触发
        selectFragment(0); //Fragment的选择
    }

    private void initFragment() {
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, mfind_Wechat);
        transaction.add(R.id.id_content, mfind_Contacts);
        transaction.add(R.id.id_content, mfind_Discover);
        transaction.add(R.id.id_content, mfind_Myself);
        transaction.commit();
    }

    private void initView() {
        mWechat_text = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mContacts_text = (LinearLayout) findViewById(R.id.id_tab_frd);
        mDiscover_text = (LinearLayout) findViewById(R.id.id_tab_contact);
        mMyself_text = (LinearLayout) findViewById(R.id.id_tab_settings);

        mWechat_img = (ImageButton) findViewById(R.id.id_tab_WeChat_img);
        mContacts_img = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mDiscover_img = (ImageButton) findViewById(R.id.id_tab_contact_img);
        mMyself_img = (ImageButton) findViewById(R.id.id_tab_settings_img);
    }

    private void initEvent() {
        mWechat_text.setOnClickListener(this);
        mContacts_text.setOnClickListener(this);
        mDiscover_text.setOnClickListener(this);
        mMyself_text.setOnClickListener(this);
    }

    private void selectFragment(int i) {
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i) {
            case 0:
                Log.d("setSelect", "1");
                transaction.show(mfind_Wechat);
                mWechat_img.setImageResource(R.drawable.wechat);
                break;
            case 1:
                transaction.show(mfind_Contacts);
                mContacts_img.setImageResource(R.drawable.contacts);
                break;
            case 2:
                transaction.show(mfind_Discover);
                mDiscover_img.setImageResource(R.drawable.discover);
                break;
            case 3:
                transaction.show(mfind_Myself);
                mMyself_img.setImageResource(R.drawable.myself);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        transaction.hide(mfind_Wechat);
        transaction.hide(mfind_Contacts);
        transaction.hide(mfind_Discover);
        transaction.hide(mfind_Myself);
    }


    @Override
    public void onClick(View v) {
        Log.d("onClick", "1");
        resetImgs();
        switch (v.getId()) {
            case R.id.id_tab_weixin:
                Log.d("onClick", "2");
                selectFragment(0);
                break;
            case R.id.id_tab_frd:
                selectFragment(1);
                break;
            case R.id.id_tab_contact:
                selectFragment(2);
                break;
            case R.id.id_tab_settings:
                selectFragment(3);
                break;
            default:
                break;
        }
    }

    private void resetImgs() {
        mWechat_img.setImageResource(R.drawable.wechat);
        mContacts_img.setImageResource(R.drawable.contacts);
        mDiscover_img.setImageResource(R.drawable.discover);
        mMyself_img.setImageResource(R.drawable.myself);
    }
}