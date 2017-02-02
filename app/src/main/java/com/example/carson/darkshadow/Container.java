package com.example.carson.darkshadow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.carson.darkshadow.R.drawable.searchiconwhite;

public class Container extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private TextView title;
    private String[] tabs = {"Feed", "Notifications", "Events", "Messages"};
    private Drawable[] icons = new Drawable[4];
    private Activity a = this;
    private int previous;
    private Button goBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        previous = 0;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable search = getDrawable(searchiconwhite);
        search.setTint(getResources().getColor(R.color.colorPrimary));
        ((ImageButton)toolbar.findViewById(R.id.search)).setImageDrawable(search);
        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.tabtitle);
        title.setText(tabs[0]);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        Drawable feed = getDrawable(R.drawable.homeicon);
        Drawable notifs = getDrawable(R.drawable.notificonfull);
        Drawable events = getDrawable(R.drawable.clockiconfull);
        Drawable messages = getDrawable(R.drawable.messagesiconfull);

        icons[0] = feed;
        icons[1] = notifs;
        icons[2] = events;
        icons[3] = messages;

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                icons[position].setTint(getResources().getColor(R.color.colorAccent));
                icons[previous].setTint(getResources().getColor(R.color.colorPrimary));
                title.setText(tabs[position]);
                previous = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setUpTabIcons();
        icons[0].setTint(getResources().getColor(R.color.colorAccent));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Drawable fabImage = (Drawable) getDrawable(R.drawable.drafticon);
        fabImage.setTint(getResources().getColor(R.color.black));
        fab.setImageDrawable(fabImage);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Container.this, EventCreator.class);
                startActivity(intent);
            }
        });

    }

    public void goButton(View v){
        goBut = (Button) v.findViewById(R.id.going);
        if(goBut.getText().equals("I'LL GO")){
            goBut.setText("GOING");
            goBut.setBackgroundResource(R.drawable.goingborder);
        }
        else{
            goBut.setText("I'LL GO");
            goBut.setBackgroundResource(R.drawable.border);
        }
    }

    public void goToProfile(View v){
        Intent intent = new Intent(Container.this, Profile.class);
        startActivity(intent);
    }

    public void setUpTabIcons(){
        for(int i = 0; i<4; i++){
            icons[i].setTint(getResources().getColor(R.color.colorPrimary));
            View v;
            if(i==2)
                v = getLayoutInflater().inflate(R.layout.clocktabview,null);
            else
                v = getLayoutInflater().inflate(R.layout.tabview, null);
            v.findViewById(R.id.icon).setBackground(icons[i]);
            tabLayout.getTabAt(i).setCustomView(v);
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_container, menu);
        return true;
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_container, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public static class FeedFragment extends Fragment {

        public FeedFragment(){

        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.feed_fragment, container, false);

            ListView feed = (ListView) rootView.findViewById(R.id.feed);

            FeedItem me = new FeedItem("Carson Schubert", "Hit the Gym", rootView.getResources().getDrawable(R.mipmap.ic_launcher), "12m");
            FeedItem two = new FeedItem("Rizwan Lubis", "WHOAAAAAA", rootView.getResources().getDrawable(R.drawable.drafticon), "1h");
            FeedItem three = new FeedItem("Rizwan Lubis", "WHOAAAAAA", rootView.getResources().getDrawable(R.drawable.drafticon), "1h");
            FeedItem four = new FeedItem("Rizwan Lubis", "WHOAAAAAA", rootView.getResources().getDrawable(R.drawable.drafticon), "1h");
            FeedItem five = new FeedItem("Rizwan Lubis", "WHOAAAAAA", rootView.getResources().getDrawable(R.drawable.drafticon), "1h");
            FeedItem six = new FeedItem("Carson Schubert", "Hey whats up?", rootView.getResources().getDrawable(R.mipmap.ic_launcher), "12m");
            FeedItem seven = new FeedItem("Carson Schubert", "Hey whats up?", rootView.getResources().getDrawable(R.mipmap.ic_launcher), "12m");
            FeedItem eight = new FeedItem("Carson Schubert", "Hey whats up?", rootView.getResources().getDrawable(R.mipmap.ic_launcher), "12m");
            FeedItem nine = new FeedItem("Carson Schubert", "Hey whats up?", rootView.getResources().getDrawable(R.mipmap.ic_launcher), "12m");



            ArrayList<FeedItem> items = new ArrayList<FeedItem>();

            items.add(me);
            items.add(two);
            items.add(three);
            items.add(four);
            items.add(five);
            items.add(six);
            items.add(seven);
            items.add(eight);
            items.add(nine);


            FeedAdapter adapter = new FeedAdapter(getActivity(), 15, items);
            adapter.notifyDataSetChanged();
            feed.setAdapter(adapter);

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position == 0)
                return new FeedFragment();
            else
                return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 4;
        }

    }

}
