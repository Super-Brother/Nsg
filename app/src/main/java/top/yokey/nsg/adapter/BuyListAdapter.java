package top.yokey.nsg.adapter;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import top.yokey.nsg.R;
import top.yokey.nsg.activity.NcApplication;
import top.yokey.nsg.utility.TextUtil;

/*
*
* 作者：Yokey软件工作室
*
* 企鹅：1002285057
*
* 网址：www.yokey.top
*
* 作用：购买第一步的商品列表适配器
*
*/

public class BuyListAdapter extends RecyclerView.Adapter<BuyListAdapter.ViewHolder> {

    private Activity mActivity;
    private NcApplication mApplication;
    private onTextWatcherListener mTextWatcher;
    private ArrayList<HashMap<String, String>> mArrayList;

    public BuyListAdapter(NcApplication application, Activity activity, ArrayList<HashMap<String, String>> arrayList) {
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
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        final String store_id;
        int goods_num = 0;

        try {
            JSONArray jsonArray = new JSONArray(hashMap.get("goods_list"));
            for (int i = 0; i < jsonArray.length(); i++) {
                HashMap<String, String> temp = new HashMap<>(TextUtil.jsonObjectToHashMap(jsonArray.get(i).toString()));
                goods_num += Integer.parseInt(temp.get("goods_num"));
                arrayList.add(temp);
            }
            GoodsBuyListAdapter mAdapter = new GoodsBuyListAdapter(mApplication, mActivity, arrayList);
            holder.mListView.setLayoutManager(new LinearLayoutManager(mActivity));
            holder.mListView.setAdapter(mAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        store_id = arrayList.get(0).get("store_id");
        holder.storeTextView.setText(hashMap.get("store_name"));
        String total = "共 <font color='#FF5001'>" + goods_num + "</font> 件商品，";
        total += "共 <font color='#FF5001'>" + hashMap.get("store_goods_total") + "</font> 元";
        holder.infoTextView.setText(Html.fromHtml(total));

        holder.messageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (mTextWatcher != null) {
                    mTextWatcher.onTextWatcher(store_id, s.toString());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
        View view = LayoutInflater.from(group.getContext()).inflate(R.layout.item_list_buy, group, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView storeTextView;
        public RecyclerView mListView;
        public TextView infoTextView;
        public EditText messageEditText;

        public ViewHolder(View view) {
            super(view);

            storeTextView = (TextView) view.findViewById(R.id.storeTextView);
            mListView = (RecyclerView) view.findViewById(R.id.mainListView);
            infoTextView = (TextView) view.findViewById(R.id.infoTextView);
            messageEditText = (EditText) view.findViewById(R.id.messageEditText);

        }

    }

    public void setOnTextWatcherListener(onTextWatcherListener textWatcher) {
        this.mTextWatcher = textWatcher;
    }

    public interface onTextWatcherListener {
        void onTextWatcher(String id, String content);
    }

}
