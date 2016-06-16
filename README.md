## GRecyclerView

###### Support
*  支持三种adapter,BaseAdapter(普通),MutilyAdapter(多种布局),SwipeAdapter(侧滑删除)
*  支持分割线、也可根据position 自定义分割线
*  支持刷新加载, 也可自己加入。 只需继承一个类。
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

### 如果想要自定义刷新头部样式 或底部加载样式
##### 你只需要写个类 并且继承BaseRefreshHeader 或者 BaseRefreshFooter 然后根据 setState(int state)里面回传状态进行调整

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

##### 普通的Adapter, 直接在updateUI里面更新即可.

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
####  侧滑删除的 Adapter


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

##### XML

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

#### 多种布局的Adapter
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

##### 分割线属性。

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

### 注意:如果使用 GridLayoutManager 或者 StaggeredGridLayoutManager, 如果你要给它们设置分割线,那么需要 使用drawable这个属性,不支持 dividerColor、dividerStrokeWidth.


##### 如果你想要根据 position 自定义 分割线的属性, 那么你只需要继承一个adapter, 然后需要实现Provider,如ColorProvider、DrawableProvider等等.

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

## 更多细节，请参考Sample



# 本人博客 :Blog:http://blog.csdn.net/xuezhe__
# 感谢
[https://github.com/jianghejie/XRecyclerView](https://github.com/jianghejie/XRecyclerView)

[https://github.com/yqritc/RecyclerView-FlexibleDivider](https://github.com/yqritc/RecyclerView-FlexibleDivider)

[https://github.com/daimajia/AndroidSwipeLayout](https://github.com/daimajia/AndroidSwipeLayout)



