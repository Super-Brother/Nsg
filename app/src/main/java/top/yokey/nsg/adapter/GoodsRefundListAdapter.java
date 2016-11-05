package top.yokey.nsg.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
* 作用：退货商品列表适配器
*
*/

public class GoodsRefundListAdapter extends RecyclerView.Adapter<GoodsRefundListAdapter.ViewHolder> {

    private Activity mActivity;
    private NcApplication mApplication;
    private ArrayList<HashMap<String, String>> mArrayList;

    public GoodsRefundListAdapter(NcApplication application, Activity activity, ArrayList<HashMap<String, String>> arrayList) {
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
        ImageLoader.getInstance().displayImage(hashMap.get("goods_img_360"), holder.mImageView);
        holder.nameTextView.setText(hashMap.get("goods_name"));
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApplication.startGoods(mActivity, hashMap.get("goods_id"));
            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_goods_order, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout mRelativeLayout;
        public ImageView mImageView;
        public TextView nameTextView;
        public TextView infoTextView;

        public ViewHolder(View view) {
            super(view);

            mRelativeLayout = (RelativeLayout) view.findViewById(R.id.mainRelativeLayout);
            mImageView = (ImageView) view.findViewById(R.id.mainImageView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            infoTextView = (TextView) view.findViewById(R.id.infoTextView);

        }

    }

}

