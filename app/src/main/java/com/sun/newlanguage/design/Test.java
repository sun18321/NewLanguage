package com.sun.newlanguage.design;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class Test extends RecyclerView.Adapter {
    ViewPager2 mView;
    WebView mWeb;
    TextView mTv;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void test() {
        mWeb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mWeb.getLayoutParams();



        mTv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) view.getLayoutParams();


                return false;
            }
        });
    }
}
