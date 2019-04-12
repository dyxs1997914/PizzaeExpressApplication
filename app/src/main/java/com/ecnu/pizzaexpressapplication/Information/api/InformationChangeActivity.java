package com.ecnu.pizzaexpressapplication.Information.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.ecnu.pizzaexpressapplication.R;
import java.lang.*;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ecnu.pizzaexpressapplication.R;
import com.ecnu.pizzaexpressapplication.base.BaseResponse;
import com.ecnu.pizzaexpressapplication.base.PizzaExpressBaseActivity;
import com.ecnu.pizzaexpressapplication.base.PizzaExpressBaseCallBack;
import com.ecnu.pizzaexpressapplication.bean.User;
import com.ecnu.pizzaexpressapplication.Information.*;
import com.ecnu.pizzaexpressapplication.Information.api.InformationApi;
import com.ecnu.pizzaexpressapplication.login.LoginActivity;
import com.ecnu.pizzaexpressapplication.login.api.LoginApi;
import com.ecnu.pizzaexpressapplication.login.response.LoginResponse;
import com.ecnu.pizzaexpressapplication.main.MainActivity;
import com.lemon.support.util.DigestUtils;
import java.util.Date;

public class InformationChangeActivity extends PizzaExpressBaseActivity{


    @BindView(R.id.et_user_name)
    EditText et_user_name;
    @BindView(R.id.tv_user_name)
    TextView tv_user_name;
    @BindView(R.id.et_user_phonenum)
    EditText et_user_phonenum;
    @BindView(R.id.tv_user_phonenum)
    TextView tv_user_phonenum;
    @BindView(R.id.et_user_vx)
    EditText et_user_vx;
    @BindView(R.id.et_user_qq)
    EditText et_user_qq;
    @BindView(R.id.et_user_address)
    EditText et_user_address;
    @BindView(R.id.bt_update)
    Button bt_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_change);
        initView();
    }
    private void initView() {
        ButterKnife.bind(this);
        setTitleString("修改个人信息");
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = et_user_name.getText().toString();
                String qqString = et_user_qq.getText().toString();
                String vxString = et_user_vx.getText().toString();
                String phonenumString = et_user_phonenum.getText().toString();
                String addressString = et_user_address.getText().toString();
                User user =new User();
                user.setNickName(nameString);
                user.setQq(qqString);
                user.setWechat(vxString);
                user.setTelephone(phonenumString);
                user.setAddress(addressString);
                if(phonenumString.length()==0)
                {
                    makeToast("请输入手机号！");
                }
               else if(phonenumString.length()!=11)
                {
                    makeToast("请输入正确的手机号！");
                }
                else if(nameString.length()==0)
                {
                    makeToast("请输入昵称！");
                }
                else if(addressString.length()==0)
                {
                    makeToast("请输入地址！");
                }
                else {
                    addRequest(getService(InformationApi.class).modifyUserInfo(user), new PizzaExpressBaseCallBack<BaseResponse>() {
                        @Override
                        public void onSuccess200(BaseResponse o) {
                            makeToast("修改成功");
                            Log.d(TAG, "onSuccess200: " + o.getErrorMessage());
                            Intent intent = new Intent(InformationChangeActivity.this, InformationViewActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
    }
}
