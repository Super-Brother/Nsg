package top.yokey.nsg.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

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
* 作用：商品详细页 推荐商品 适配器
*
*/

public class GoodsDetailedListAdapter extends RecyclerView.Adapter<GoodsDetailedListAdapter.ViewHolder> {

    private Activity mActivity;
    private NcApplication mApplication;
    private ArrayList<HashMap<String, String>> mArrayList;

    public GoodsDetailedListAdapter(NcApplication application, Activity activity, ArrayList<HashMap<String, String>> arrayList) {
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

        holder.mImageView.setImageResource(R.mipmap.ic_launcher);
        ImageLoader.getInstance().displayImage(hashMap.get("goods_image_url"), holder.mImageView);
        holder.nameTextView.setText(hashMap.get("goods_name"));
        String temp = "￥ " + hashMap.get("goods_promotion_price");
        holder.priceTextView.setText(temp);

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApplication.startGoods(mActivity, hashMap.get("goods_id"));
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_goods_detailed, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout mLinearLayout;
        public ImageView mImageView;
        public TextView nameTextView;
        public TextView priceTextView;

        public ViewHolder(View view) {
            super(view);

            mLinearLayout = (LinearLayout) view.findViewById(R.id.mainLinearLayout);
            mImageView = (ImageView) view.findViewById(R.id.mainImageView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            priceTextView = (TextView) view.findViewById(R.id.priceTextView);

        }

    }

}