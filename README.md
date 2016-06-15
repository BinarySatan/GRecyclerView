## GRecyclerView
###### Support
*  support BaseAdapter SwipeAdapter MultiyAdapter
*  custom decoration
*  custom refresh header and footer
___

## Hao to use ?

### gradle
`compile 'com.binarysatan:GRecyclerView:1.0'`

### maven
 `<dependency>
  <groupId>com.binarysatan</groupId>
  <artifactId>GRecyclerView</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>`

### if you want use custom header or footer
##### you need custom class extends BaseRefreshHeader or BaseRefreshFooter

    public class RefreshHeader extends BaseRefreshHeader {

    public TextView mTv;

    public RefreshHeader(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public View getContainerView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.header, new FrameLayout(getContext()));
    }

    @Override
    public void setState(int state) {
        switch (state) {
            case IRefreshHeader.STATE_NORMAL:
                mTv.setText("下拉刷新");
                break;
            case IRefreshHeader.STATE_RELEASE_TO_REFRESH:
                mTv.setText("释放刷新");
                break;
            case IRefreshHeader.STATE_REFRESHING:
                mTv.setText("正在刷新");
                break;
            case IRefreshHeader.STATE_DONE:
                mTv.setText("刷新完成");
                break;
        }
    }

    @Override
    public View getRootView() {
        return this;
    }
    }
    
    class MainActivity extends Activity{
        mGRecyclerView.setRefreshHeader(new RefreshHeader());
        mGRecyclerView.setRefreshFooter(...);
    }
    
##### if you want use  normal adapter

         /**
         *  nomral list
         */

        mGRecyclerView = (GRecyclerView) findViewById(R.id.grecyclerview);
        mGRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mGRecyclerView.setAdapter(new BaseAdapter<String>(this, R.layout.listitem, mDatas, mGRecyclerView) {
            @Override
            public void updateUI(BaseHolder holder, int position, String data) {
                TextView tv = holder.getView(R.id.tv);
                tv.setText(data);


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




___
####  is support swipeAdapter


        mGRecyclerView.setAdapter(new SwipeAdapter<String>(this, R.layout.swipeitem, mDatas, mGRecyclerView) {
            @Override
            public int getDeleteViewId() {
                return R.id.ll_delete;
            }

            @Override
            public void updateUI(BaseHolder holder, int position, String data) {
                TextView tv = holder.getView(R.id.tv);
                tv.setText(data);
            }
        });`

##### for xml

    <?xml version="1.0" encoding="utf-8"?>
    <com.it.binarysatan.library.swipelayout.SwipeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <!--swipe 侧滑部分-->
    <LinearLayout
        android:id="@+id/ll_delete"
        android:layout_width="50dp"
        android:background="#F00"
        android:layout_height="match_parent">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="删除" />
    </LinearLayout>

    <!--item  content-->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp">

        <TextView
            android:id="@+id/tv"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center" />

    </LinearLayout>

    </com.it.binarysatan.library.swipelayout.SwipeLayout>
___

#### mulityAdapter
        mGRecyclerView.setAdapter(new MultiLayoutAdapter<String>(this, mDatas, mGRecyclerView) {
            @Override
            public int multiLayout(int position) {
                if(position ==1)
                    return R.layout.listitem;

                return R.layout.swipeitem;
            }

            @Override
            public void updateMuiltUI(BaseHolder holder, int position, List<String> data) {
                if(getLayoutId(holder) ==R.layout.listitem){
                    //dosomething
                }else if(getLayoutId(holder) == R.layout.swipeitem){
                    //dosomething
                }
            }
        });
____

##### if you want set divider, it support the following attribute

    <declare-styleable name="GRecyclerView">
        <attr name="dividerStrokeWidth" format="reference" />
        <attr name="dividerColor" format="color" />
        <attr name="margin_left" format="dimension" />
        <attr name="margin_right" format="dimension" />
        <attr name="margin_top" format="dimension" />
        <attr name="margin_bottom" format="dimension" />
        <attr name="drawable" format="reference" />
        <attr name="needDivider" format="boolean" />
        <attr name="listSelector" format="reference" />
    </declare-styleable>

### Note: if you use GridLayoutManager or StaggeredGridLayoutManager, you need to use the drawable to set the divider


##### if you want custom divier for position, you nedd custom adapter extends BaseAdapter or SwipeAdapter or MultiLayoutAdapter

    public class MyAdapter extends BaseAdapter implements FlexibleDividerDecoration.ColorProvider {
    
    public MyAdapter(Context context, int layoutId, List datas, GRecyclerView recyclerView) {
        super(context, layoutId, datas, recyclerView);
    }

    @Override
    public void updateUI(BaseHolder holder, int position, Object data) {
        
    }

    @Override
    public int dividerColor(int position, RecyclerView parent) {
        if(position==0)
            return Color.RED;
        return Color.BLACK;
    }
    }
    
## if you want to know more detail, to see sample



# Blog:http://blog.csdn.net/xuezhe__
# Thanks
[https://github.com/jianghejie/XRecyclerView](https://github.com/jianghejie/XRecyclerView)

[https://github.com/yqritc/RecyclerView-FlexibleDivider](https://github.com/yqritc/RecyclerView-FlexibleDivider)

[https://github.com/daimajia/AndroidSwipeLayout](https://github.com/daimajia/AndroidSwipeLayout)



