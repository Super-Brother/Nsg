package top.yokey.nsg.adapter;

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
* 作用：添加地址时选择区域的适配器
*
*/

public class AddressMapListAdapter extends RecyclerView.Adapter<AddressMapListAdapter.ViewHolder> {

    private onItemClickListener itemClickListener;
    private ArrayList<HashMap<String, String>> mArrayList;

    public AddressMapListAdapter(ArrayList<HashMap<String, String>> arrayList) {
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

        holder.mTextView.setText(hashMap.get("name"));
        holder.mTextView.append("\n");
        holder.mTextView.append(hashMap.get("address"));

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(hashMap.get("address"));
                }
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_address_map, group, false);
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
        void onItemClick(String address);
    }

}

