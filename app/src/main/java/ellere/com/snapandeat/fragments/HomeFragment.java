package ellere.com.snapandeat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ellere.com.snapandeat.R;
import ellere.com.snapandeat.adapter.RecyclerViewAdapterFeed;
import ellere.com.snapandeat.adapter.RecyclerViewAdapterStories;
import ellere.com.snapandeat.model.FeedModel;
import ellere.com.snapandeat.model.StoriesModel;

/**
 * Created by DELL on 4/25/2020.
 */

public class HomeFragment extends Fragment {
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;


    ArrayList<FeedModel> feedModelArrayList=new ArrayList<>();
    ArrayList<StoriesModel> storiesModelArrayList=new ArrayList<>();

    RecyclerViewAdapterFeed adapterFeed;
    RecyclerViewAdapterStories adapterStories;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container, false);
        recyclerView1=view.findViewById(R.id.recy_feed);
        recyclerView2=view.findViewById(R.id.recy_stories);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView1.setLayoutManager(layoutManager);

        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(getActivity());
        ((LinearLayoutManager) layoutManager1).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager1);

        adapterFeed=new RecyclerViewAdapterFeed(getActivity(),feedModelArrayList);
        adapterStories=new RecyclerViewAdapterStories(getActivity(),storiesModelArrayList);

        recyclerView1.setAdapter(adapterFeed);
        recyclerView2.setAdapter(adapterStories);

        populaterecyclerview();

        populaterecyclerviewstories();
        return  view;
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
