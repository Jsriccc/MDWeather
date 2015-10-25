package com.riccc.mdweather.util;

/**
 * Created by Riccc on 15/10/8.
 */
public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);

}
