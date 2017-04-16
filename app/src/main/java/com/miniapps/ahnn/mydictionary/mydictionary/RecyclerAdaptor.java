package com.miniapps.ahnn.mydictionary.mydictionary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by AhmedKhaled on 4/16/2017.
 */

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.Holder> {

    List<Word> Data;
    Context context;

    public RecyclerAdaptor(List<Word> data, Context context) {
        Data = data;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new Holder(itemView);
    }


    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        holder.textView.setText(Data.get(position).getWord());
    }


    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_word);
        }
    }
}
