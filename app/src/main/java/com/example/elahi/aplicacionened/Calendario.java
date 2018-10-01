package com.example.elahi.aplicacionened;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

public class Calendario extends Fragment {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calendario, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        appBarLayout = (AppBarLayout) view.findViewById(R.id.appbarid);
        tabLayout.addTab(tabLayout.newTab().setText("DIA 1"));
        tabLayout.addTab(tabLayout.newTab().setText("DIA 2"));
        tabLayout.addTab(tabLayout.newTab().setText("DIA 3"));
        tabLayout.addTab(tabLayout.newTab().setText("SEMIFINAL"));
        tabLayout.addTab(tabLayout.newTab().setText("FINAL"));

        return view;
    }

}
