package top.yokey.nsg.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import top.yokey.nsg.activity.NcApplication;
import top.yokey.nsg.R;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：代金券适配器
*
*/

public class RedPacketListAdapter extends RecyclerView.Adapter<RedPacketListAdapter.ViewHolder> {

    private Activity mActivity;
    private NcApplication mApplication;
    private ArrayList<HashMap<String, String>> mArrayList;

    public RedPacketListAdapter(NcApplication application, Activity activity, ArrayList<HashMap<String, String>> arrayList) {
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

        String temp = "红包活动：" + hashMap.get("packet_name");
        holder.nameTextView.setText(temp);
        temp = "红包金额：" + hashMap.get("packet_price") + " 元";
        holder.moneyTextView.setText(temp);
        holder.stateTextView.setText("红包状态：已领取");

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_red_packet, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout mRelativeLayout;
        public TextView nameTextView;
        public TextView moneyTextView;
        public TextView stateTextView;

        public ViewHolder(View view) {
            super(view);

            mRelativeLayout = (RelativeLayout) view.findViewById(R.id.mainRelativeLayout);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            moneyTextView = (TextView) view.findViewById(R.id.moneyTextView);
            stateTextView = (TextView) view.findViewById(R.id.stateTextView);

        }

    }


}
