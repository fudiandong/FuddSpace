package com.fudd.live.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by fudd-office on 2017-3-3 14:48.
 * Email: 5036175@qq.com
 * QQ: 5036175
 * Description: Image图片处理工具类  需要glide框架
 */

public class ImageUtil {

    /**
     *  处理圆形图片 此处用到Glide框架，需要在build.gradle 中添加compile 'jp.wasabeef:glide-transformations:2.0.1'
     * @param imageView 要显示的ImageView
     * @param dw  本地图片资源
     */
    public static void displayCircle(ImageView imageView, int dw){
        Glide.with(imageView.getContext())
                .load(dw)
                .bitmapTransform(new CropCircleTransformation(imageView.getContext()))
                .into(imageView);
    }

}
