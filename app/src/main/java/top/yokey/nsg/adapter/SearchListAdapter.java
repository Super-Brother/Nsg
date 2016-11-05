package top.yokey.nsg.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import top.yokey.nsg.activity.GoodsListActivity;
import top.yokey.nsg.activity.NcApplication;
import top.yokey.nsg.R;
import top.yokey.nsg.activity.StoreListActivity;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：搜索列表适配器
*
*/

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.ViewHolder> {

    private Activity mActivity;
    private NcApplication mApplication;
    private ArrayList<HashMap<String, String>> mArrayList;

    public SearchListAdapter(NcApplication application, Activity activity, ArrayList<HashMap<String, String>> arrayList) {
        this.mActivity = activity;
        this.mArrayList = arrayList;
        this.mApplication = application;
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final HashMap<String, String> hashMap = mArrayList.get(position);

        final String type = hashMap.get("type");
        final String title = hashMap.get("title");

        holder.typeTextView.setText(type);
        holder.titleTextView.setText(title);

        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                if (type.equals("宝贝")) {
                    intent.setClass(mActivity, GoodsListActivity.class);
                } else {
                    intent.setClass(mActivity, StoreListActivity.class);
                }
                intent.putExtra("type", "keyword");
                intent.putExtra("keyword", title);
                mApplication.startActivity(mActivity, intent);
                mApplication.finishActivity(mActivity);
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_search, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout mRelativeLayout;
        public TextView titleTextView;
        public TextView typeTextView;

        public ViewHolder(View view) {
            super(view);

            mRelativeLayout = (RelativeLayout) view.findViewById(R.id.mainRelativeLayout);
            titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            typeTextView = (TextView) view.findViewById(R.id.typeTextView);

        }

    }

}