package com.thanhtung.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @Headers({"Content-Type:application/json",
            "Authorization:key=AAAAXEbZ-qQ:APA91bEzhFglxmOVk0QmT2jbTBnWTO9LHuP4j1OJstXPU-TZWAyizqJjKW17-ZLCM1D-NsHK-PUBtE_O_Xnk0IbsfzRAsvmdErd92hO3yeWtZJXAQGsu6cQmLq8Ka-czRphsQ4zSaMKe"})
    @POST("fcm/send")
    Call<MyResponse> sendMessage(@Body Sender sender);
}
