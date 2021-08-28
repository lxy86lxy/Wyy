package com.example.wyy.util;

//回调机制接口
public interface HttpBack{
    void onFinish(String response);
    void onError(Exception e);
}
