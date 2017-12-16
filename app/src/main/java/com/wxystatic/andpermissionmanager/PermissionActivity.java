package com.wxystatic.andpermissionmanager;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wxystatic.permissionmanagerlibrary.GetPermissionListener;
import com.wxystatic.permissionmanagerlibrary.PermissionManager;
import com.yanzhenjie.permission.Permission;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PermissionActivity extends AppCompatActivity {
    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.btn_camera)
    Button btnCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        ButterKnife.bind(this);

    }
    @OnClick({R.id.btn_call, R.id.btn_camera})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_call:
                PermissionManager.getPermission(this, Manifest.permission.CALL_PHONE, 111, new GetPermissionListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(PermissionActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(PermissionActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_camera:
                PermissionManager.getPermission(this, Permission.CAMERA, 222, new GetPermissionListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(PermissionActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(PermissionActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
