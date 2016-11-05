package top.yokey.nsg.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import top.yokey.nsg.R;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：预存款 适配器
*
*/

public class RechargeCardListAdapter extends RecyclerView.Adapter<RechargeCardListAdapter.ViewHolder> {

    private ArrayList<HashMap<String, String>> mArrayList;

    public RechargeCardListAdapter(ArrayList<HashMap<String, String>> arrayList) {
        this.mArrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final HashMap<String, String> hashMap = mArrayList.get(position);

        String description = hashMap.get("description");

        holder.statusTextView.setText(description.substring(0, description.indexOf("，")));
        String temp = "SN" + description.substring(description.indexOf(":"), description.length());
        holder.snTextView.setText(temp);

        String money = "￥ " + hashMap.get("available_amount");
        holder.moneyTextView.setText(money);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_recharge_card, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout mRelativeLayout;
        public TextView statusTextView;
        public TextView moneyTextView;
        public TextView snTextView;

        public ViewHolder(View view) {
            super(view);

            mRelativeLayout = (RelativeLayout) view.findViewById(R.id.mainRelativeLayout);
            statusTextView = (TextView) view.findViewById(R.id.statusTextView);
            moneyTextView = (TextView) view.findViewById(R.id.moneyTextView);
            snTextView = (TextView) view.findViewById(R.id.snTextView);

        }

    }

}
