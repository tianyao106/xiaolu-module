package com.tianyao.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tianyao.myproject.bean.CheckTaskListData;
import com.tianyao.xiaolu.bean.response.ResponseResult;
import com.tianyao.xiaolu.widget.dialog.LoadingDialog;

import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Observable<ResponseResult<CheckTaskListData>> observable =
    }

    public void click(View view) {
        LoadingDialog loadingDialog = new LoadingDialog(this);
        loadingDialog.setText("正在登录中");
        loadingDialog.show();
    }
}
