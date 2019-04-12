package com.ecnu.pizzaexpressapplication.Information.api;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import com.ecnu.pizzaexpressapplication.R;
import java.lang.*;
import android.content.Intent;
import android.view.View;
import butterknife.ButterKnife;
import com.ecnu.pizzaexpressapplication.base.PizzaExpressBaseActivity;
import com.ecnu.pizzaexpressapplication.base.PizzaExpressBaseCallBack;
import com.ecnu.pizzaexpressapplication.bean.User;
import com.ecnu.pizzaexpressapplication.Information.api.InformationApi;

public class InformationViewActivity extends PizzaExpressBaseActivity {
    @BindView(R.id.tv_user_name3)
    TextView tv_user_name3;
    @BindView(R.id.tv_user_phonenum3)
    TextView tv_user_phonenum3;
    @BindView(R.id.tv_user_qq3)
    TextView tv_user_qq3;
    @BindView(R.id.tv_user_vx3)
    TextView tv_user_vx3;
    @BindView(R.id.tv_user_address3)
    TextView tv_user_address3;
    @BindView(R.id.bt_update2)
    Button bt_update2;

    // public static information2Activity newInstance() {
    //   return new information2Activity();
    //  }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_information3);
//        initView();

    }
    private void initView() {
        ButterKnife.bind(this);
        setTitleString("个人信息");
        addRequest(getService(InformationApi.class).getUserInfo(), new PizzaExpressBaseCallBack<User>() {
            @Override
            public void onSuccess200(User o) {
                User user = o;
                tv_user_name3.setText(user.getNickName());
                tv_user_phonenum3.setText(user.getTelephone());
                tv_user_qq3.setText(user.getQq());
                tv_user_vx3.setText(user.getWechat());
                tv_user_address3.setText(user.getAddress());
            }
        });
        bt_update2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationViewActivity.this, InformationChangeActivity.class);
                startActivity(intent);
            }
        });
    }


}