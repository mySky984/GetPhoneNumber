package com.lfq.zzuli.getphonenumber.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lfq.zzuli.getphonenumber.R;
import com.lfq.zzuli.getphonenumber.entity.PhoneInfo;

import java.util.List;
import java.util.zip.Inflater;


/**
 * Created by Administrator on 2016/11/1 0001.
 */

/*
此适配器要携带手机联系人和号码数据，还要用上下文
* */

//由于要显示联系人姓名和电话号码，还有可能要显示图片，所以定义一个自定义的适配器MyAdapter

public class MyAdapter  extends BaseAdapter{

    //此适配器需要两个参数，即封装好数据的集合，还有承接上下文的context

    private List<PhoneInfo> list;
    private Context context;

    private RelativeLayout relativeLayout;

    //用构造方法传递数据
    public MyAdapter(List<PhoneInfo> lists, Context context){
        this.list = lists;
        this.context = context;
    }


    //该方法用于返回集合的数量
    @Override
    public int getCount() {
        return list.size();
    }

    //用于返回当前这条数据,即获取当前集合中的一条数据
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    //获取当前的ID，其中ID和Position是完全相等的
    @Override
    public long getItemId(int position) {
        return position;
    }

    //必须要获取当前要加载的View,同时把内容加载到视图当中
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
  /*      //首先获取加载View的权限
        LayoutInflater inflater = LayoutInflater.from(context);
        //通过relativeLayout进行加载
        relativeLayout = (RelativeLayout) inflater.inflate(R.layout.call,null);

        //获取TextView实例
        TextView nametv = (TextView)relativeLayout.findViewById(R.id.name);
        TextView numbertv = (TextView)relativeLayout.findViewById(R.id.number);
        //同时把内容加载到relativeLayout视图当中
        nametv.setText(list.get(i).getName());
        numbertv.setText(list.get(i).getNumber());
        return relativeLayout;*/

        //对上面的listView进行优化
        ViewHolder viewHolder = null;
        //如果该view从未被加载,其中convertView是指要返回到主页面的View
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.call,null);
            viewHolder = new ViewHolder();
            //找到两个控件的实例
            viewHolder.nametv = (TextView) convertView.findViewById(R.id.name);
            viewHolder.numbertv = (TextView) convertView.findViewById(R.id.number);
            //给两个控件加载内容
            viewHolder.nametv.setText(list.get(i).getName());
            viewHolder.numbertv.setText(list.get(i).getNumber());
            //把封装好的viewHolder加载到视图中
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.nametv.setText(list.get(i).getName());
            viewHolder.numbertv.setText(list.get(i).getNumber());
        }
        return convertView;
    }
    static class ViewHolder{
        TextView nametv,numbertv;
    }

}


