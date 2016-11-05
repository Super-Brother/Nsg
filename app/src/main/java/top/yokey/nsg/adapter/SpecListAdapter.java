package top.yokey.nsg.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
* 作用：商品详细页的规格 RecyclerView 适配器
*
*/

public class SpecListAdapter extends RecyclerView.Adapter<SpecListAdapter.ViewHolder> {

    private onItemClickListener itemClickListener;
    private ArrayList<HashMap<String, String>> mArrayList;

    public SpecListAdapter(ArrayList<HashMap<String, String>> arrayList) {
        this.mArrayList = arrayList;
        this.itemClickListener = null;
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        final HashMap<String, String> hashMap = mArrayList.get(position);

        holder.mTextView.setText(hashMap.get("value"));

        if (hashMap.get("default").equals("1")) {
            holder.mTextView.setTextColor(Color.WHITE);
            holder.mTextView.setBackgroundResource(R.drawable.border_text_view_goods_activity);
        } else {
            holder.mTextView.setTextColor(Color.GRAY);
            holder.mTextView.setBackgroundResource(R.drawable.border_text_view_goods_normal);
        }

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(hashMap.get("id"), hashMap.get("value"));
                }
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_spec, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View view) {
            super(view);

            mTextView = (TextView) view.findViewById(R.id.mainTextView);

        }

    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public interface onItemClickListener {
        void onItemClick(String id, String value);
    }

}
