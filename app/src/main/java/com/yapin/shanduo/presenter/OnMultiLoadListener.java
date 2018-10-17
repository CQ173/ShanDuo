package com.yapin.shanduo.presenter;

/**
 * @author Smile Wei
 * @since 2016/7/26.
 * 在Presenter层实现，给Model层回调，更改View层的状态，确保Model层不直接操作View层
 */
public interface OnMultiLoadListener<T> {

    /**
     * 成功时的回调
     *
     * @param success 成功信息
     */
    void onSuccess(T success, int totalPage);

    /**
     * 失败时的回调
     *
     * @param msg 错误信息
     */
    void onError(String msg);

    void networkError();
}