package com.secux.expandabletableitem;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class SectionAdpater extends RecyclerView.Adapter<SectionAdpater.ViewHolder> {

    Context mContext;

    public SectionAdpater(Context context) {
        this.mContext = context;
    }

    @Override
    public SectionAdpater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater ll = LayoutInflater.from(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_section, parent, false);

        return new SectionAdpater.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SectionAdpater.ViewHolder holder, int position) {
        holder.textviewSectionName.setText("Section " + position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textviewSectionName;
        RecyclerView testRecyclerView;
        ItemAdapter mAdapter;

        ViewHolder(View itemView) {
            super(itemView);

            textviewSectionName = itemView.findViewById(R.id.textView_coin_token_item);
            testRecyclerView = (RecyclerView)itemView.findViewById(R.id.recyclerview_items);
            testRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

            final CardView cardView = itemView.findViewById(R.id.cardView_device_coin_token);
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){

                    if (mAdapter == null) {
                        mAdapter = new ItemAdapter(mContext);
                        testRecyclerView.setAdapter(mAdapter);
                    }else{
                        testRecyclerView.setAdapter(null);
                        mAdapter = null;
                    }

                }
            });
        }

    }
}
