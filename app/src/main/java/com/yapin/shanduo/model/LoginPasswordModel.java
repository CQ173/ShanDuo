package com.yapin.shanduo.model;

import com.yapin.shanduo.presenter.OnLoadListener;

/**
 * Created by dell on 2018/5/31.
 */

public interface LoginPasswordModel {
    void load(OnLoadListener<String> listener,String typeId ,String phone , String code , String password , String newPassword);
}
