package com.secux.expandabletableitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context mContext;

    public ItemAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater ll = LayoutInflater.from(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_item, parent, false);

        return new ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemAdapter.ViewHolder holder, int position) {
        holder.textviewSectionName.setText("Item " + position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textviewSectionName;


        ViewHolder(View itemView) {
            super(itemView);

            textviewSectionName = itemView.findViewById(R.id.textView_item_name);

            final CardView cardView = itemView.findViewById(R.id.cardView_device_coin_token);

            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){


                }
            });
        }

    }
}
