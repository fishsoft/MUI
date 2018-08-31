package com.morse.mlibrary;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

public class MateUtils {

    /**
     * 获取meta_data配置数据
     *
     * @param context
     * @param key     meta_data key
     * @return String
     */
    public static String getMateData(Context context, String key) {
        if (TextUtils.isEmpty(key)) {
            throw new NullPointerException("meta data key is null");
        }
        try {
            String packageName = context.getPackageName();
            PackageManager manager = context.getPackageManager();
            Bundle bundle = manager.getApplicationInfo(packageName, PackageManager.GET_META_DATA).metaData;
            if (null == bundle) {
                return null;
            }
            return bundle.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
