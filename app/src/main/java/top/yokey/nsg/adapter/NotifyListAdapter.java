package top.yokey.nsg.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import top.yokey.nsg.R;
import top.yokey.nsg.utility.TimeUtil;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：通知列表适配器
*
*/

public class NotifyListAdapter extends RecyclerView.Adapter<NotifyListAdapter.ViewHolder> {

    private ArrayList<HashMap<String, String>> mArrayList;

    public NotifyListAdapter(ArrayList<HashMap<String, String>> arrayList) {
        this.mArrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final HashMap<String, String> hashMap = mArrayList.get(position);

        String temp = "<font color='#DDDDDD'>" + TimeUtil.longToTime(hashMap.get("message_time")) + " >>> </font><br>" + hashMap.get("message_body");

        holder.contentTextView.setText(Html.fromHtml(temp));

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_notify, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView contentTextView;

        public ViewHolder(View view) {
            super(view);

            contentTextView = (TextView) view.findViewById(R.id.contentTextView);

        }

    }

}