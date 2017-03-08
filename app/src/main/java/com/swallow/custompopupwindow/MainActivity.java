package com.swallow.custompopupwindow;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mRl_gender;
    private TextView mTv_gender;
    private PopupWindow pop_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }


    //初始化view
    private void initView() {
        mRl_gender=(RelativeLayout) findViewById(R.id.rl_gender);
        mTv_gender=(TextView)findViewById(R.id.tv_gender);
    }

    //初始化数据
    private void initData() {
        mRl_gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View contentView;
                LayoutInflater mLayoutInflater = LayoutInflater.from(MainActivity.this);
                contentView = mLayoutInflater.inflate(R.layout.item_pop_gender,
                        null);
                pop_gender = new PopupWindow(contentView,
                        DensityUtil.dip2px(MainActivity.this, 200), DensityUtil.dip2px(MainActivity.this, 80));
                TextView tv_pop_male_gender = (TextView) contentView.findViewById(R.id.tv_pop_male_gender);
                TextView tv_pop_female_gender = (TextView) contentView.findViewById(R.id.tv_pop_female_gender);
                // 产生背景变暗效果
                WindowManager.LayoutParams lp = getWindow()
                        .getAttributes();
                lp.alpha = 0.4f;
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(lp);
                pop_gender.setTouchable(true);
                pop_gender.setFocusable(true);
                pop_gender.setBackgroundDrawable(new BitmapDrawable());
                pop_gender.setOutsideTouchable(true);
                pop_gender.showAtLocation(contentView, Gravity.CENTER, 0, 0);
                pop_gender.update();
                View.OnClickListener listener_gender = new View.OnClickListener() {
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.tv_pop_male_gender:
                                mTv_gender.setText("男");
                                break;
                            case R.id.tv_pop_female_gender:
                                mTv_gender.setText("女");
                                break;
                        }
                        pop_gender.dismiss();
                    }
                };
                tv_pop_male_gender.setOnClickListener(listener_gender);
                tv_pop_female_gender.setOnClickListener(listener_gender);
                pop_gender.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    // 在dismiss中恢复透明度
                    public void onDismiss() {
                        WindowManager.LayoutParams lp = getWindow()
                                .getAttributes();
                        lp.alpha = 1f;
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                        getWindow().setAttributes(lp);
                    }
                });
            }
        });
    }
}
