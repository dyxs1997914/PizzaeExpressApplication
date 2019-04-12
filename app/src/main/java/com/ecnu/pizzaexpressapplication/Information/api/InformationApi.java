package com.ecnu.pizzaexpressapplication.Information.api;

import com.ecnu.pizzaexpressapplication.bean.User;
import com.lemon.support.request.SimpleCall;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface InformationApi {
    @GET("user/getUserInfo")
    SimpleCall<User> getUserInfo();
    @PUT("user/modifyUserInfo")
    SimpleCall<User> modifyUserInfo(@Body User user);
}
