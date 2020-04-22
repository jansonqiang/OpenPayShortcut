package com.suda.openpayshortcut.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.suda.openpayshortcut.R;
import com.suda.openpayshortcut.activity.bean.PayItem;
import com.suda.openpayshortcut.activity.pay.BaseScanUI;
import com.suda.openpayshortcut.activity.pay.MainCaptureActivity;
import com.suda.openpayshortcut.activity.pay.OspTabHostActivity;
import com.suda.openpayshortcut.activity.pay.WalletOfflineCoinPurseUI;
import com.suda.openpayshortcut.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;

    Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = this;
        mRecyclerView  = findViewById(R.id.recyclerView);
        setView();
    }

    private void setView(){

        final List<PayItem> payItems = new ArrayList<>();
        payItems.add(new PayItem("扫码(微)",R.drawable.wx_scan));
        payItems.add(new PayItem("付款码(微)",R.drawable.wx_fukuan));

        payItems.add(new PayItem("扫码(支)",R.drawable.alipay_scan));
        payItems.add(new PayItem("付款码(支)",R.drawable.alipay_fukuan));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        HomeAdapter adapter = new HomeAdapter(payItems);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                PayItem item =  payItems.get(position);

             switch (position){

                 case 0:

                     startActivity(new Intent(mContext, BaseScanUI.class));
                     break;

                 case 1:

                     startActivity(new Intent(mContext, WalletOfflineCoinPurseUI.class));
                     break;

                 case 2:

                     startActivity(new Intent(mContext, MainCaptureActivity.class));
                     break;

                 case 3:

                     startActivity(new Intent(mContext, OspTabHostActivity.class));
                     break;

             }


            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_setting:
                 startActivity(new Intent(this,MainActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
