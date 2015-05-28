package com.lms.test;

import android.net.Uri;
import android.provider.BaseColumns;

public final class Students {
    //���峣��
    public static final String AUTHORITY="com.example.provider.students";
    private Students(){}
    //�ڲ���
    public static final class Student implements BaseColumns{
        private Student(){} //���췽��
        public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/student");
        public static final String CONTENT_TYPE="vnd.android.cursor.dir/vnd.example.provider.students";
        public static final String CONTENT_ITEM_TYPE="vnd.android.cursor.item/vnd.example.provider.students";
        //���ݿ��еı��ֶ�
        public static final String NMAE="name";//����
        public static final String GENDER="gender";//�Ա�
        public static final String AGE="age";//����
    }
}
