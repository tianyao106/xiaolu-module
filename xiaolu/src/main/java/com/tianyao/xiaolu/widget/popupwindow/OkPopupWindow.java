package com.tianyao.xiaolu.widget.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.tianyao.xiaolu.R;

import java.lang.ref.WeakReference;

/**
 * Created by 陆维淋
 * on 2018/9/12
 */
public class OkPopupWindow extends PopupWindow {

    View parent;
    MyHandler myHandler;

    public OkPopupWindow(Context context) {
        super(context);
    }

    public OkPopupWindow(Context context, View view) {
        super(context);
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        setContentView(LayoutInflater.from(context).inflate(R.layout.popupwindow_dialog_ok, null));
        this.setWidth((int) (0.34 * metrics.widthPixels));//0.34=124/360
        this.setHeight((int) (0.12 * metrics.heightPixels));//0.12=77/640
        this.parent = view;
        myHandler = new MyHandler((Activity) context);
    }

    public void show() {
        this.showAtLocation(this.parent, Gravity.CENTER, 0, 0);
        myHandler.postDelayed(new MyRunnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, 1000);
    }

    private class MyHandler extends Handler {

        WeakReference<Activity> weakReference;

        public MyHandler(Activity activity) {
            this.weakReference = new WeakReference<>(activity);
        }
    }

    private class MyRunnable implements Runnable {

        @Override
        public void run() {

        }
    }


}
