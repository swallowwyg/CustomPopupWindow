package com.swallow.custompopupwindow;

import android.content.Context;

/**
 * 工具类，dp和px相互转化
 * Created by wyg_tdrh on 2016/10/25.
 */

public class DensityUtil {

    /**
     * 根据手机的分辨率从dp的转成为px
     * @param context
     * @param dipValue
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从px转成为dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
