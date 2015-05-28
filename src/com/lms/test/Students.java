package com.lms.test;

import android.net.Uri;
import android.provider.BaseColumns;

public final class Students {
    //定义常量
    public static final String AUTHORITY="com.example.provider.students";
    private Students(){}
    //内部类
    public static final class Student implements BaseColumns{
        private Student(){} //构造方法
        public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/student");
        public static final String CONTENT_TYPE="vnd.android.cursor.dir/vnd.example.provider.students";
        public static final String CONTENT_ITEM_TYPE="vnd.android.cursor.item/vnd.example.provider.students";
        //数据库中的表字段
        public static final String NMAE="name";//姓名
        public static final String GENDER="gender";//性别
        public static final String AGE="age";//年龄
    }
}
