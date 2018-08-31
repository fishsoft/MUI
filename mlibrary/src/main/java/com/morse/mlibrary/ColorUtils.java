package com.morse.mlibrary;

import android.support.annotation.NonNull;

/**
 * 颜色转化工具类
 * Created by admin on 2018/4/19.
 */
public class ColorUtils {

    /**
     * 将int颜色值转成16位字符串
     *
     * @param color
     * @return
     */
    public static String convertInt2Hex(int color) {
        return convertRGBToHex(convertInt2RGB(color));
    }

    /**
     * 整形颜色值转成RGB
     *
     * @param color
     * @return
     */
    public static int[] convertInt2RGB(int color) {
        int red = (color & 0xff0000) >> 16;
        int green = (color & 0x00ff00) >> 8;
        int blue = (color & 0x0000ff);
        return new int[]{red, green, blue};
    }

    /**
     * 将rgb色彩值转成16进制代码
     *
     * @param r
     * @param g
     * @param b
     * @return
     */
    public static String convertRGBToHex(int r, int g, int b) {
        return new StringBuffer("#")
                .append(getRGBString(r))
                .append(getRGBString(g))
                .append(getRGBString(b))
                .toString();
    }

    @NonNull
    private static String getRGBString(int rgb) {
        int red = rgb / 16;
        int rred = rgb % 16;
        return new StringBuffer()
                .append(getHexString(red))
                .append(getHexString(rred))
                .toString();
    }

    /**
     * 将rgb色彩值转成16进制代码
     *
     * @param rgb
     * @return
     */
    public static String convertRGBToHex(int[] rgb) {
        return convertRGBToHex(rgb[0], rgb[1], rgb[2]);
    }

    @NonNull
    private static String getHexString(int red) {
        if (red == 10) return "A";
        else if (red == 11) return "B";
        else if (red == 12) return "C";
        else if (red == 13) return "D";
        else if (red == 14) return "E";
        else if (red == 15) return "F";
        else return String.valueOf(red);
    }
}
