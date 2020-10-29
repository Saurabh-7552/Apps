package com.example.listreminder;

import android.content.ClipData;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ftab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ftab2 extends Fragment {
    Button mClearHistory;
    ListView historyListView;
    List<Items> historyList;
    ItemAdapter historyAdapter;
    DataBaseHelper dataBaseHelper;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ftab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ftab2.
     */
    // TODO: Rename and change types and number of parameters
    public static ftab2 newInstance(String param1, String param2) {
        ftab2 fragment = new ftab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View historyView = inflater.inflate(R.layout.fragment_ftab2, container, false);
        mClearHistory = historyView.findViewById(R.id.clear_history);
        historyListView = historyView.findViewById(R.id.history_list);
        dataBaseHelper = new DataBaseHelper(getContext());
        historyList = ViewData();

        if (historyList != null) {
            historyAdapter = new ItemAdapter(getContext(), historyList);
            historyListView.setAdapter(historyAdapter);
        } else {
            Toast.makeText(getContext(), "Oops No history to Show", Toast.LENGTH_SHORT).show();
        }
        mClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyList.clear();
                historyAdapter.clear();
                dataBaseHelper.Delete();
                Toast.makeText(getContext(),"Content Deleted Congrats!!!",Toast.LENGTH_LONG).show();
            }
        });
        return historyView;
    }

    private List<Items> ViewData() {
        Cursor cursor = dataBaseHelper.getData();
        if (historyList != null)
            historyList.clear();
        if (historyAdapter != null) {
            historyAdapter.clear();
            historyAdapter.notifyDataSetChanged();
        }
        List<Items> ItemsList = new ArrayList<>();
        if (cursor.getCount() == 0)
            Toast.makeText(getContext(), "No Result to Show ", Toast.LENGTH_SHORT).show();
        else {
            while (cursor.moveToNext()) {
                Integer getNumber = Integer.parseInt(cursor.getString(2));
                ItemsList.add(new Items(cursor.getString(1), getNumber));

            }
            if (historyAdapter != null)
                historyAdapter.notifyDataSetChanged();
        }
        return ItemsList;
    }
}