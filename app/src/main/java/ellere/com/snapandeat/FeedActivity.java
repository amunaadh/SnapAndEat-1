package ellere.com.snapandeat;

/**
 * Created by swikriti on 3/15/2020.
 */



        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.design.widget.BottomNavigationView;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.MenuItem;

        import java.util.ArrayList;

        import ellere.com.snapandeat.R;
        import ellere.com.snapandeat.fragments.AddFragment;
        import ellere.com.snapandeat.fragments.ProfileFragment;
        import ellere.com.snapandeat.model.FeedModel;
        import ellere.com.snapandeat.model.StoriesModel;
        import ellere.com.snapandeat.adapter.RecyclerViewAdapterFeed;
        import ellere.com.snapandeat.adapter.RecyclerViewAdapterStories;

public class FeedActivity extends AppCompatActivity {
    private ActionBar toolbar;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    BottomNavigationView bottomNavigationView;

    ArrayList<FeedModel> feedModelArrayList=new ArrayList<>();
    ArrayList<StoriesModel> storiesModelArrayList=new ArrayList<>();

    RecyclerViewAdapterFeed adapterFeed;
    RecyclerViewAdapterStories adapterStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        toolbar = getSupportActionBar();
        toolbar.setTitle(R.string.app_name);

        recyclerView1=(RecyclerView) findViewById(R.id.recy_feed);
        recyclerView2=(RecyclerView) findViewById(R.id.recy_stories);
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottom_navigation_view);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);

        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager1).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager1);

        adapterFeed=new RecyclerViewAdapterFeed(this,feedModelArrayList);
        adapterStories=new RecyclerViewAdapterStories(this,storiesModelArrayList);

        recyclerView1.setAdapter(adapterFeed);
        recyclerView2.setAdapter(adapterStories);

        populaterecyclerview();

        populaterecyclerviewstories();
        BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_home:
                        Intent intent= new Intent(FeedActivity.this,FeedActivity.class);
                        startActivity(intent);

                        return true;
                    case R.id.item_add:
                        openFragment(AddFragment.newInstance("",""));

                        return true;
                    case R.id.item_profile:
                        openFragment(ProfileFragment.newInstance("",""));

                        return true;

                }
                return false;
            }
        };
    }
    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void populaterecyclerviewstories() {

        StoriesModel storiesModel=new StoriesModel("Swikriti",R.drawable.propic1);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("Yamuna",R.drawable.propic2);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("Shardool",R.drawable.propic3);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("Isha",R.drawable.propic4);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("Santosh",R.drawable.propic5);
        storiesModelArrayList.add(storiesModel);
        storiesModel=new StoriesModel("Sandhya",R.drawable.propic6);
        storiesModelArrayList.add(storiesModel);
    }

    private void populaterecyclerview() {

       FeedModel feedModel=new FeedModel("Swikriti ","2 HOURS AGO","Isha","Bbq Chicken Pizza-250 cal",
                86,R.drawable.propic2,R.drawable.propic6,R.drawable.propic1,R.drawable.postpic1);

        feedModelArrayList.add(feedModel);

        feedModel=new FeedModel("Yamuna","25 MINUTES AGO","Swikriti","Cheese Pizza-200 cal",
                92,R.drawable.propic2,R.drawable.propic5,R.drawable.propic2,R.drawable.postpic2);

        feedModelArrayList.add(feedModel);

        feedModel=new FeedModel("Shardool","50 MINUTES AGO","Yamuna","Mexican Pizza-220 cal",
                82,R.drawable.propic2,R.drawable.propic4,R.drawable.propic3,R.drawable.postpic3);

        feedModelArrayList.add(feedModel);

        feedModel=new FeedModel("Isha","5 HOURS AGO","Swikriti","Pepperoni Pizza-215 cal",
                76,R.drawable.propic2,R.drawable.propic3,R.drawable.propic4,R.drawable.postoic4);

        feedModelArrayList.add(feedModel);

        feedModel=new FeedModel("Santosh","36 MINUTES AGO","Isha","Margherita Pizza- 240 cal",
                97,R.drawable.propic2,R.drawable.propic2,R.drawable.propic5,R.drawable.postpic5);

        feedModelArrayList.add(feedModel);

        feedModel=new FeedModel("Sandhya","8 HOURS AGO","Shardool","Pepperoni Pizza - 215 cal",
                56,R.drawable.propic2,R.drawable.propic1,R.drawable.propic6,R.drawable.postpic6);

        feedModelArrayList.add(feedModel);

    }
}

