package com.example.a01375594.messageModule;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.a01375594.basemodule.BaseFragment;

import java.util.List;

/**
 * Created by 01375594 on 2018/5/7.
 */
@Route(path = "/message/listFragment")
public class MessageFragment extends BaseFragment {

    @Autowired()
    public String token;

    private ListView listLv;

    private List<ItemEntity> itemEntities = DataUtils.generatorData(20);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_fragment_list, container, false);
        listLv = (ListView) view.findViewById(R.id.listLv);
        TextView emptyView = new TextView(getContext());
        emptyView.setText("没有token，暂无message数据");
        emptyView.setTextColor(Color.BLACK);
        emptyView.setGravity(Gravity.CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        emptyView.setLayoutParams(layoutParams);
        ((ViewGroup)listLv.getParent()).addView(emptyView);
        listLv.setEmptyView(emptyView);

        if (TextUtils.isEmpty(token)) {
            Toast.makeText(getContext(), "token不能为空", Toast.LENGTH_LONG).show();
            return view;
        }
        Toast.makeText(getContext(), token, Toast.LENGTH_LONG).show();

        MessageItemAdapter adapter = new MessageItemAdapter(itemEntities);
        listLv.setAdapter(adapter);

        listLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ARouter.getInstance()
                        .build("/message/detail")
                        .withString("token", token)
                        .withInt("id", itemEntities.get(position).id)
                        .withString("name", itemEntities.get(position).name)
                        .navigation();
            }
        });

        return view;
    }
}
