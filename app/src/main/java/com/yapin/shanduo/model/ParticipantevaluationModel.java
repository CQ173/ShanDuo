package com.yapin.shanduo.model;

import com.yapin.shanduo.presenter.OnLoadListener;

/**
 * Created by dell on 2018/5/30.
 */

public interface ParticipantevaluationModel {
    void load(OnLoadListener<String> listener, String activityId , String data);
}
