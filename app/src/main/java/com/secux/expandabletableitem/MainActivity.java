package com.secux.expandabletableitem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    SectionAdpater mAdapter;

    private ItemTouchHelper.Callback mItemTouchCallback = new ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP | ItemTouchHelper.DOWN,
            0) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                              RecyclerView.ViewHolder target) {

            final int fromPos = viewHolder.getAdapterPosition();
            final int toPos = target.getAdapterPosition();

            mAdapter.notifyItemMoved(fromPos, toPos);

            return true; // true if moved, false otherwise
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView testRecyclerView = (RecyclerView)findViewById(R.id.recyclerview_test);
        testRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new SectionAdpater(this);
        testRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(testRecyclerView);
    }
}