package com.suda.openpayshortcut.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.suda.openpayshortcut.R;
import com.suda.openpayshortcut.activity.bean.PayItem;

import java.util.List;

public class HomeAdapter   extends BaseQuickAdapter<PayItem, BaseViewHolder> {

    public HomeAdapter(@Nullable List<PayItem> data) {
        super(R.layout.item_home,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PayItem item) {

        ImageView imageView = helper.getView(R.id.image);
        TextView textView = helper.getView(R.id.text);

        imageView.setImageResource(item.imgId);
        textView.setText(item.name);


    }
}
