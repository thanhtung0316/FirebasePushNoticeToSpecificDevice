package com.thanhtung.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @Headers({"Content-Type:application/json",
            "Authorization:key=AAAAVpzlkgA:APA91bEnPwqIYAe0eEx8xtvH35pFcZNrDCYCQCmacGgz_8Xfn1GHDU7aT5yUOp8kfirXi4HBbC7wlKuLL-xxuwDiDFAfC2eb3KXqd8xhmV2yO4bY1lrDyWXcsCxtqeriwQutIYQfz1jl"})
    @POST("fcm/send")
    Call<MyResponse> sendMessage(@Body Sender sender);
}
