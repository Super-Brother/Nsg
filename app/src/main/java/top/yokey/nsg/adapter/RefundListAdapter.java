package top.yokey.nsg.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import top.yokey.nsg.activity.NcApplication;
import top.yokey.nsg.R;
import top.yokey.nsg.activity.RefundDetailedActivity;
import top.yokey.nsg.utility.TextUtil;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：退款列表适配器
*
*/

public class RefundListAdapter extends RecyclerView.Adapter<RefundListAdapter.ViewHolder> {

    private Activity mActivity;
    private NcApplication mApplication;
    private ArrayList<HashMap<String, String>> mArrayList;

    public RefundListAdapter(NcApplication application, Activity activity, ArrayList<HashMap<String, String>> arrayList) {
        this.mActivity = activity;
        this.mArrayList = arrayList;
        this.mApplication = application;
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        final HashMap<String, String> hashMap = mArrayList.get(position);

        holder.storeTextView.setText(hashMap.get("store_name"));

        switch (hashMap.get("seller_state_v")) {
            case "1":
                holder.stateTextView.setText("等待商家确认");
                break;
            case "2":
                holder.stateTextView.setText("商家已确认");
                break;
            case "3":
                holder.stateTextView.setText("商家已拒绝");
                break;
        }

        if (!hashMap.get("admin_state").equals("无")) {
            holder.stateTextView.setText(hashMap.get("admin_state"));
        }

        try {
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(hashMap.get("goods_list"));
            for (int i = 0; i < jsonArray.length(); i++) {
                arrayList.add(new HashMap<>(TextUtil.jsonObjectToHashMap(jsonArray.get(i).toString())));
            }
            holder.mListView.setLayoutManager(new LinearLayoutManager(mActivity));
            holder.mListView.setAdapter(new GoodsRefundListAdapter(mApplication, mActivity, arrayList));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String info = "编号：" + hashMap.get("refund_sn") + " | 退款金额<font color='#FF5001'> ￥ " + hashMap.get("refund_amount") + " </font>";
        holder.infoTextView.setText(Html.fromHtml(info));

        holder.detailedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, RefundDetailedActivity.class);
                intent.putExtra("refund_id", hashMap.get("refund_id"));
                mApplication.startActivity(mActivity, intent);
            }
        });

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, RefundDetailedActivity.class);
                intent.putExtra("refund_id", hashMap.get("refund_id"));
                mApplication.startActivity(mActivity, intent);
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_refund, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout mLinearLayout;
        public TextView storeTextView;
        public TextView stateTextView;
        public RecyclerView mListView;
        public TextView infoTextView;
        public TextView detailedTextView;

        public ViewHolder(View view) {
            super(view);

            mLinearLayout = (LinearLayout) view.findViewById(R.id.mainLinearLayout);
            storeTextView = (TextView) view.findViewById(R.id.storeTextView);
            stateTextView = (TextView) view.findViewById(R.id.stateTextView);
            mListView = (RecyclerView) view.findViewById(R.id.mainListView);
            infoTextView = (TextView) view.findViewById(R.id.infoTextView);
            detailedTextView = (TextView) view.findViewById(R.id.detailedTextView);

        }

    }

}
