package com.tianyao.xiaolu.subscriber;

import android.app.Dialog;
import android.text.TextUtils;

import com.google.gson.JsonSyntaxException;
import com.tianyao.xiaolu.handler.dialog.DialogHandler;  

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Created by xiaolu
 * on 2018/9/18
 */
public abstract class DialogSubscriber<T> extends Subscriber<T> {

    public final int RESET_CODE = 502;

    /**
     * 是否需要显示加载的对话框，有的需要有的不需要，所以在创建订阅者时，直接给true或者false即可
     */
    private boolean isShowDialog = false;

    /**
     * 定义一个请求成功的抽象方法，子类必须实现并在实现中进行处理服务器返回的数据
     *
     * @param t 服务器返回的数据
     */
    public abstract void onSuccess(T t);

    /**
     * 定义一个请求成功的抽象方法，子类必须实现并在实现中进行处理服务器返回的数据
     *
     * @param msg 服务器返回的错误信息
     */
    public abstract void onFailure(String msg);

    private DialogHandler dialogHandler;

    public DialogSubscriber(Dialog dialog, boolean isShowDialog) {
        this.dialogHandler = new DialogHandler(dialog);
        this.isShowDialog = isShowDialog;
    }

    @Override
    public void onStart() {
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
    public void onCompleted() {
        dismissProgressDialog();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onError(Throwable e) {
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

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }
}
