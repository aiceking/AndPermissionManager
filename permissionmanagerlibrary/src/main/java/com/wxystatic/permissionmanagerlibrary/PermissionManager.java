package com.wxystatic.permissionmanagerlibrary;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

/**
 * Created by static on 2017/12/16/016.
 */

public class PermissionManager {
    public static void getPermission(final Activity activity, final String[] permissions, final int PermissionRequestCode, final GetPermissionListener getPermissionListener){
        AndPermission.with(activity)
                .requestCode(PermissionRequestCode)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        rationale.resume();
                    }
                }).callback(new PermissionListener() {
            @Override
            public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                if (PermissionRequestCode==requestCode){
                    if(AndPermission.hasPermission(activity,permissions)) {
                        if (getPermissionListener!=null){
                            getPermissionListener.onSuccess();
                        }
                    } else {
                        if (getPermissionListener!=null){
                            getPermissionListener.onFailed("您已主动拒绝授予该权限");
                        }
                    }
                }
            }

            @Override
            public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                if (PermissionRequestCode==requestCode){
                    if (AndPermission.hasAlwaysDeniedPermission(activity, deniedPermissions)) {
                        if (getPermissionListener!=null){
                            getPermissionListener.onFailed("您已主动拒绝权限申请界面弹出，请自行在设置中进行授权");
                        }
                    }else{
                        if (!AndPermission.hasPermission(activity,permissions)){
                            if (getPermissionListener!=null){
                                getPermissionListener.onFailed("您已主动拒绝授予该权限");
                            }
                        }else{
                            if (getPermissionListener!=null){
                                getPermissionListener.onSuccess();
                            }
                        }
                    }
                }
            }
        }).start();
    }
    public static void getPermission(final Activity activity, final String permission, final int PermissionRequestCode, final GetPermissionListener getPermissionListener){
        AndPermission.with(activity)
                .requestCode(PermissionRequestCode)
                .permission(permission)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        rationale.resume();
                    }
                }).callback(new PermissionListener() {
            @Override
            public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                if (PermissionRequestCode==requestCode){
                    if(AndPermission.hasPermission(activity,permission)) {
                        if (getPermissionListener!=null){
                            getPermissionListener.onSuccess();
                        }
                    } else {
                        if (getPermissionListener!=null){
                            getPermissionListener.onFailed("您已主动拒绝授予该权限");
                        }
                    }
                }
            }

            @Override
            public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                if (PermissionRequestCode==requestCode){
                    if (AndPermission.hasAlwaysDeniedPermission(activity, deniedPermissions)) {
                        if (getPermissionListener!=null){
                            getPermissionListener.onFailed("您已主动拒绝权限申请界面弹出，请自行在设置中进行授权");
                        }
                    }else{
                        if (!AndPermission.hasPermission(activity,permission)){
                            if (getPermissionListener!=null){
                                getPermissionListener.onFailed("您已主动拒绝授予该权限");
                            }
                        }else{
                            if (getPermissionListener!=null){
                                getPermissionListener.onSuccess();
                            }
                        }
                    }
                }
            }
        }).start();
    }
}
