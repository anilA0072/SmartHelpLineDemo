package com.example.anil.smarthelpline;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Filter;
import android.widget.Filterable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.*;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.anil.smarthelpline.Navigation_Elements.modelListClick;
import com.example.anil.smarthelpline.login_tabs.DbHelper;
import com.example.anil.smarthelpline.login_tabs.listClick;

import java.util.ArrayList;

public class first_aid_Fragment extends Fragment implements Filterable,View.OnClickListener{
    ArrayList<String> data;
    ListView listView;
    SearchView searchView;
    ArrayAdapter<String> adapter;

    SQLiteDatabase sqLiteDatabase;
    private com.example.anil.smarthelpline.login_tabs.DbHelper DbHelper;
    Cursor cursor;

    public first_aid_Fragment() {
    }
   @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        DbHelper dbHelper=new DbHelper(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_first_aid, container, false);
        // Inflate the layout for this fragment

        data=new ArrayList<>();
        data.add("Anaphylaxis");
        data.add("Animal bites");
        data.add("Black eye");
        data.add("Blisters");
        data.add("Bruise");
        data.add("Burns");
        data.add("Cardiopulmonary resuscitation (CPR)");
        data.add("Chemical burns");
        data.add("Chemical splash in the eye");
        data.add("Chest pain");
        data.add("Choking");
        data.add("Corneal abrasion (scratch)");
        data.add("Cuts and scrapes");
        data.add("Dislocation");
        data.add("Electrical burns");
        data.add("Electrical shock");
        data.add("Fainting");
        data.add("Fever");
        data.add("Foreign object in the ear");
        data.add("Foreign object in the eye");
        data.add("Foreign object in the nose");
        data.add("Foreign object in the skin");
        data.add("Foreign object inhaled");
        data.add("Foreign object swallowed");
        data.add("Frostbite");
        data.add("Gastroenteritis");
        data.add("Head pain");
        data.add("Head trauma");
        data.add("Heart attack");
        data.add("Heat exhaustion");
        data.add("Heatstroke");
        data.add("Human bites");
        data.add("Hypothermia");
        data.add("Insect bites and stings");
        data.add("Motion sickness");
        data.add("Nosebleeds");
        data.add("Poisoning");
        data.add("Puncture wounds");
        data.add("Severe bleeding");
        data.add("Shock");
        data.add("Snakebites");
        data.add("Spider bites");
        data.add("Spinal injury");
        data.add("Sprain");
        data.add("Stroke");
        data.add("Tooth loss");


       return view;
    }
    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
      getActivity().getMenuInflater().inflate( R.menu.menu_search,menu );
       MenuItem menuItem = menu.findItem( R.id.item_search );
        searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE

                adapter.getFilter().filter(query);
                return false;
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        adapter=new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_expandable_list_item_1,
                data
        );

        listView=(ListView)view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                modelListClick model;
                DbHelper dbHelper=new DbHelper( getContext() );
                model=dbHelper.getData( data.get( position) );
               Intent intent=new Intent(getContext(),listClick.class );
              intent.putExtra( "title",model.getTitle() );
                intent.putExtra( "p0",model.getP0() );
                intent.putExtra( "p1",model.getP1() );
                intent.putExtra( "p2",model.getP2() );
                intent.putExtra( "p3",model.getP3() );
                intent.putExtra( "p4",model.getP4() );
                intent.putExtra( "p5",model.getP5() );
                intent.putExtra( "p6",model.getP6() );
                intent.putExtra( "p7",model.getP7() );
                intent.putExtra( "p8",model.getP8() );
                intent.putExtra( "p9",model.getP9() );
                intent.putExtra( "p10",model.getP10() );


                startActivity( intent );



            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Filter getFilter() {
        listView.setTextFilterEnabled(true);

        return null;
    }
}
