package com.v.healme;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class help_right_now extends AppCompatActivity {

    //Actionbar
    private ActionBar actionBar;

    //UI Views
    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_right_now);

        //init actionbar
        actionBar = getSupportActionBar();

        //init UI Views
        viewPager = findViewById(R.id.viewPager);
        loadCards();

        //set viewpager change listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //ill just change the tittle of actionbar
                String title = modelArrayList.get(position).getTitle();
                //actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCards() {
        //init list
        modelArrayList = new ArrayList<>();

        //add items to list
        modelArrayList.add(new MyModel(
                "Take a Breath",
                "Focusing on your breathing slows down the adrenaline response and the distressing thoughts. Breath mindfully and notice the sensations of breathing into your belly. You might find it helpful to count your breaths, or to breath in to a count of 4",
                R.drawable.take_breath));

        modelArrayList.add(new MyModel(
                "Observe",
                "Your thoughs and feelings. For example" +
                        "1. I'm anxious" +
                        "2. My body's alarm system has been triggered" +
                        "3. My mind is tricking me into believing I'm in danger" +
                        "4. I'm feeling really tense and hyped up",
                R.drawable.observe));

        modelArrayList.add(new MyModel(
                "Pull Back",
                "Ask yourself:" +
                        "1. Is this really true or does it just feel that way?" +
                        "2. Is this fact or opinion?" +
                        "3. What would a friend say about this?" +
                        "4. What advice would I tell someone else?" +
                        "5. Even though it feels really bad, these physical sensations are a normal body response ... it will pass",
                R.drawable.pullback));

        modelArrayList.add(new MyModel(
                "Your Turn",
                "Now it's over to you. Don't worry though, this part's easy. Try something that works for you. Maybe do some deep grounding techniques, read through some positive quotes or affimations, do some deep breathing, check out the catastrophe scale, or remind yourself that you're in the present." +
                        "There's no right or wrong thing to try, whatever works for you is best",
                R.drawable.your_turn));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100,0,100,0);
    }
}