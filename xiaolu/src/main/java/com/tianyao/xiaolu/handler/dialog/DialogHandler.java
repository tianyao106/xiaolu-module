package com.tianyao.xiaolu.handler.dialog;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by 陆维淋
 * on 2018/9/18
 */
public class DialogHandler extends Handler {

    /**
     * 显示加载框
     */
    public static final int SHOW_PROGRESS_DIALOG = 1;

    /**
     * 隐藏加载框
     */
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private WeakReference<Dialog> weakReference;

    public DialogHandler(Dialog dialog) {
        this.weakReference = new WeakReference<>(dialog);
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                showLodingDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissLodingDialog();
                break;
        }
    }

    private void showLodingDialog() {
        if (weakReference != null) {
            Dialog dialog = weakReference.get();
            if (dialog != null) {
                dialog.show();
            }
        }
    }

    private void dismissLodingDialog() {
        if (weakReference != null) {
            Dialog dialog = weakReference.get();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }
}
