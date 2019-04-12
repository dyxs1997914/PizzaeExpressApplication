package com.ecnu.pizzaexpressapplication.main.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.Unbinder;
import com.ecnu.pizzaexpressapplication.Information.api.InformationChangeActivity;
import com.ecnu.pizzaexpressapplication.base.PizzaExpressBaseFragment;
import android.widget.TextView;
import com.ecnu.pizzaexpressapplication.R;

import java.lang.*;

import butterknife.ButterKnife;
import com.ecnu.pizzaexpressapplication.base.PizzaExpressBaseCallBack;
import com.ecnu.pizzaexpressapplication.bean.User;
import com.ecnu.pizzaexpressapplication.Information.api.InformationApi;
import com.ecnu.pizzaexpressapplication.Information.api.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends PizzaExpressBaseFragment {
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
    private Unbinder unbinder;

    private void initView() {
        setTitleString("个人信息");
        addRequest(getService(InformationApi.class).getUserInfo(), new PizzaExpressBaseCallBack<User>() {
            @Override
            public void onSuccess200(User o) {
                User user = o;
                Log.d(TAG, "onSuccess200: " + user);
                tv_user_name3.setText(user.getNickName());
                tv_user_phonenum3.setText(user.getTelephone());
                tv_user_qq3.setText(user.getQq());
                tv_user_vx3.setText(user.getWechat());
                tv_user_address3.setText(user.getAddress());
            }
        });
//        bt_update2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(PersonalFragment.this, informationActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    public static PersonalFragment newInstance() {
        return new PersonalFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        bt_update2 = view.findViewById(R.id.bt_update2);
        bt_update2.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), InformationChangeActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_information_view, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
