package com.lfq.zzuli.getphonenumber;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.util.Log;


import com.lfq.zzuli.getphonenumber.entity.PhoneInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/29 0029.
 */

//该类的功能是获取手机通讯录里所有联系人
public class Getmyphonenumber  {

    String Tag = "MainActivity";

    //创建一个ArrayList集合，将封装好的PhoneInfo对象添加到集合中
    public static List<PhoneInfo> lists = new ArrayList<PhoneInfo>();
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public  static String getPhoneNumber(Context context){
        //获取上下文，然后用GetContentResolver()方法，获取通讯录，然后用query()方法进行查询即可
        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null,null);
        String phoneName,phoneNumber;
        while (cursor.moveToNext()){
            //获取Phone.DISPLAY_NAME和Phone.NUMBER两个字段，读取手机数据库中的联系人的姓名和手机号码
            phoneName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            //创建PhoneInfo的对象，然后把利用其构造方法，把获取到的的数据封装到PhoneInfo对象中，然后把封装好的对象添加到集合中
            PhoneInfo phoneInfo = new PhoneInfo(phoneName,phoneNumber);
            lists.add(phoneInfo);
            //Log.d("Tag",phoneName + "  "  + phoneNumber);
        }
        return null;
    }
}
