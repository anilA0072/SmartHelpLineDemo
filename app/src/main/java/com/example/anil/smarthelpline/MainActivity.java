package com.example.anil.smarthelpline;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.anil.smarthelpline.Navigation_Elements.AboutUs;
import com.example.anil.smarthelpline.Navigation_Elements.Ambulance;
import com.example.anil.smarthelpline.Navigation_Elements.Clinic;
import com.example.anil.smarthelpline.Navigation_Elements.Doctor.DoctorActivity;
import com.example.anil.smarthelpline.Navigation_Elements.Hospital;
import com.example.anil.smarthelpline.Navigation_Elements.Medicine_trackerActivity;
import com.example.anil.smarthelpline.Navigation_Elements.Settings;
import com.example.anil.smarthelpline.Navigation_Elements.SpecializationActivity;
import com.example.anil.smarthelpline.Navigation_Elements.bmi_Calculator_Fragment;
import com.example.anil.smarthelpline.Navigation_Elements.feedback_Fragment;
import com.example.anil.smarthelpline.login_tabs.PagerAdapter;
import com.example.anil.smarthelpline.login_tabs.Session;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private Session session;
    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    private FragmentManager fragmentManager;
    private NavigationView navigationView;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SmartHelpLine");

        //TobLayout
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("FirstAid"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        nDrawerLayout = (DrawerLayout) findViewById(R.id.main_page);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.open, R.string.close);
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        nToggle.setToolbarNavigationClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (nToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void setTItleSupport(String tItleSupport){
        getSupportActionBar().setTitle(tItleSupport);

    }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();
            Fragment fragment=null;
            if (id == R.id.nav_hospitals) {
                startActivity( new Intent( getApplicationContext(),Hospital.class) );
            } else if (id == R.id.nav_clinics) {
                startActivity( new Intent( getApplicationContext(),Clinic.class) );
            } else if (id == R.id.nav_Doctors) {
              startActivity( new Intent( getApplicationContext(),DoctorActivity.class ) );
            } else if (id == R.id.nav_specialization) {
                startActivity( new Intent( getApplicationContext(),SpecializationActivity.class ) );
            } else if (id == R.id.nav_medicineTracker) {
                startActivity( new Intent( getApplicationContext(),Medicine_trackerActivity.class ) );
            } else if (id == R.id.nav_ambulance) {
                startActivity( new Intent( getApplicationContext(),Ambulance.class) );
            } else if (id == R.id.nav_feedback) {
                Toast.makeText(getApplicationContext(), "feedback ", Toast.LENGTH_LONG).show();
                fragment=new feedback_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            } else if (id == R.id.nav_Settings) {
                startActivity( new Intent( getApplicationContext(),Settings.class) );
            } else if (id == R.id.nav_aboutUs) {
                startActivity( new Intent( getApplicationContext(),AboutUs.class) );
            } else if (id == R.id.nav_bmiCalculator) {
                Toast.makeText(getApplicationContext(), "BMI Calculator ", Toast.LENGTH_LONG).show();
                fragment=new bmi_Calculator_Fragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container,fragment)
                        .addToBackStack(null)
                        .commit();
            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.main_page);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }


    @Override
    public void onBackPressed() {

      super.onBackPressed();
      getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }
}
