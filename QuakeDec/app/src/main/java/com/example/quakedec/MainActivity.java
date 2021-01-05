package com.example.quakedec;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   private ListAdapter listAdapter;
   private List<EarthQuakeData> earthQuakeDataList;
   private QueryUtils queryUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queryUtils =new QueryUtils();
        earthQuakeDataList=queryUtils.getList();
        listAdapter =new ListAdapter(MainActivity.this,earthQuakeDataList);

        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        earthquakeListView.setAdapter(listAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    JSONArray jsonArray =queryUtils.getRoot();
                    JSONObject jsonObject=jsonArray.getJSONObject(position);
                    JSONObject propertyObject=jsonObject.getJSONObject("properties");
                    String url=propertyObject.getString("url");
                    Intent webSiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(webSiteIntent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}