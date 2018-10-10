package com.example.elahi.aplicacionened;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        appBarLayout = (AppBarLayout) view.findViewById(R.id.appbarid);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdpaterCalendario adapter = new ViewPagerAdpaterCalendario(getFragmentManager());
        adapter.addFragment(new Fragement_futbol(),"Futbol");
        adapter.addFragment(new Fragment_Basquetbol(),"Básquetbol");
        adapter.addFragment(new Fragment_Voleibol(),"Voleibol");
        adapter.addFragment(new Fragment_Voleibol_playa(),"Voleibol Playa");
        adapter.addFragment(new Fragment_Beisbol(), "Béisbol");
        adapter.addFragment(new Fragment_Ajedrez(),"Ajedrez");
        adapter.addFragment(new Fragment_Natacion(),"Natación");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
