package com.example.a01375594.historyModule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 01375594 on 2018/5/8.
 */

public class HistoryItemAdapter extends BaseAdapter {

    private List<ItemEntity> items;

    public HistoryItemAdapter(List<ItemEntity> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).id;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history_item_list, viewGroup, false);
            viewHolder.nameTv = (TextView) view.findViewById(R.id.nameTv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.nameTv.setText(items.get(i).name);

        return view;
    }

     private static class ViewHolder {
         TextView nameTv;
     }
}
