package com.it.binarysatan.grecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.it.binarysatan.library.BaseAdapter;
import com.it.binarysatan.library.BaseHolder;
import com.it.binarysatan.library.recyclerview.GRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GRecyclerView mGRecyclerView;

    private static List<String> mDatas = new ArrayList<>(10);

    static {
        mDatas.add("1");
        mDatas.add("2");
        mDatas.add("3");
        mDatas.add("4");
        mDatas.add("5");
        mDatas.add("6");
        mDatas.add("7");
        mDatas.add("8");
        mDatas.add("9");
        mDatas.add("10");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  nomral adapter
         */

        mGRecyclerView = (GRecyclerView) findViewById(R.id.grecyclerview);
        mGRecyclerView.setAdapter(new BaseAdapter<String>(this, R.layout.listitem, mDatas, mGRecyclerView) {
            @Override
            public void updateUI(BaseHolder holder, int position, String data) {
//                TextView tv = holder.getView(R.id.tv);
//                tv.setText(data);
                holder.setText(R.id.tv, data);  // only support  setText, you can    holder.getView

            }

            // if you want setListener


            @Override
            protected void setListener(BaseHolder holder) {
                holder.getView(R.id.tv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            // if youo want onItemClick
            //note :  setListener  onItemClick  only one

            @Override
            protected void onItemClick(BaseHolder holder, int position) {
                // dosomething for position
            }
        });


        /**
         *  swipe adapter
         */

//        mGRecyclerView.setAdapter(new SwipeAdapter<String>(this, R.layout.swipeitem, mDatas, mGRecyclerView) {
//            @Override
//            public int getDeleteViewId() {
//                return R.id.ll_delete;
//            }
//
//            @Override
//            public void updateUI(BaseHolder holder, int position, String data) {
//                TextView tv = holder.getView(R.id.tv);
//                tv.setText(data);
//            }
//        });



        /**
         *  multi adapter
         */

//        mGRecyclerView.setAdapter(new MultiLayoutAdapter<String>(this, mDatas, mGRecyclerView) {
//            @Override
//            public int multiLayout(int position) {
//                if(position ==1)
//                    return R.layout.listitem;
//
//                return R.layout.swipeitem;
//            }
//
//            @Override
//            public void updateMuiltUI(BaseHolder holder, int position, List<String> data) {
//                if(getLayoutId(holder) ==R.layout.listitem){
//                    //dosomething
//                }else if(getLayoutId(holder) == R.layout.swipeitem){
//                    //dosomething
//                }
//            }
//        });



        /**
         * set refresh header
         */

//        mGRecyclerView.setRefreshHeader();


        /**
         *  set refresh footer
         */

//        mGRecyclerView.setRefreshFooter();

        /**
         * auto refresh
         */

//        mGRecyclerView.setRefreshing(true);


        /**
         * refresh listener
         */
//        mGRecyclerView.setOnRefreshListener(new GRecyclerView.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                mGRecyclerView.refreshComplete(); // refresh complete
//            }
//
//            @Override
//            public void onLoadMore() {
//                mGRecyclerView.loadMoreComplete(); // load complete
//                mGRecyclerView.loadNoMore(); // no data;
//            }
//        });

        /**
         * enable refresh  load
         */
//        mGRecyclerView.setRefreshingEnabled();
//        mGRecyclerView.setLoadingMoreEnabled();
    }
}
