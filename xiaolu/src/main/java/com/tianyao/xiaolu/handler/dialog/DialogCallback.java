package com.tianyao.xiaolu.handler.dialog;

import android.app.Dialog;
import android.text.TextUtils;

import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by 陆维淋
 * on 2018/10/9
 */
public abstract class DialogCallback<T> implements Callback<T> {

    public final int RESET_CODE = 502;
    private DialogHandler dialogHandler;
    private boolean isShowDialog;

    public DialogCallback(Dialog dialog, boolean isShowDialog) {
        this.dialogHandler = new DialogHandler(dialog);
        this.isShowDialog = isShowDialog;
        init();
    }

    private void init() {
        if (isShowDialog) {
            showProgressDialog();
        }
    }

    private void showProgressDialog() {
        if (dialogHandler != null) {
            dialogHandler.obtainMessage(DialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (dialogHandler != null) {
            dialogHandler.obtainMessage(DialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            dialogHandler = null;
        }
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        dismissProgressDialog();
        onSuccess(response.body());
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onFailure(Call<T> call, Throwable e) {
        String msg;
        if (e instanceof SocketTimeoutException || e instanceof ConnectException) {
            msg = "请求超时，请稍后重试！";
        } else if (e instanceof JsonSyntaxException) {
            msg = "服务器返回数据格式出错！";
        } else if (e instanceof HttpException) {
            int code = ((HttpException) e).code();
            if (code == RESET_CODE) {
                msg = "服务正在重启，请稍后";
            } else {
                msg = "请求失败，请稍后重试！";
            }
        } else {
            msg = "请求失败，请稍后重试！";
        }
        dismissProgressDialog();
        if (!TextUtils.isEmpty(msg)) {
            onFailure(msg);
        }
    }

    public abstract void onFailure(String msg);

    public abstract void onSuccess(T t);
}
