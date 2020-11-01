package com.example.listreminder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ftab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ftab1 extends Fragment {
    ArrayList<Items> list = new ArrayList<>();
    ItemAdapter adapter;
    int number = 0;
    DataBaseHelper ItemDataBase;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ftab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ftab1.
     */
    public static ftab1 newInstance(String param1, String param2) {
        ftab1 fragment = new ftab1();
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
        final View mView = inflater.inflate(R.layout.fragment_ftab1, container, false);

        Button btn = mView.findViewById(R.id.enter);     // get Button view from fragment_ftab1 layout
        adapter = new ItemAdapter(getContext(), list);   // initialize ItemAdapter view
        ItemDataBase = new DataBaseHelper(getContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                   // On Clicking Enter button get String , add to arrayList and notify adapter to change
                EditText edit = (EditText) mView.findViewById(R.id.itemsList);
                String enteredString = edit.getText().toString();
                if (enteredString.isEmpty())
                    enteredString = "Empty!!";
                list.add(new Items(enteredString, ++number));
                if (!(ItemDataBase.Insert(enteredString, number)))
                    Toast.makeText(getContext(), "Cannot Inserted!!Sorry!!", Toast.LENGTH_SHORT).show();
                edit.getText().clear();
                adapter.notifyDataSetChanged();
            }
        });

        final ListView myList = mView.findViewById(R.id.mylist);
        myList.setAdapter(adapter);                              //Setting adapter to ListView


        Button btn1 = mView.findViewById(R.id.clear);                         // On clicking CLear button all items cleared
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                number = 0;
                adapter.clear();
            }
        });
        /////////////////////////////Number state logic should be solved////////////////////////
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageView = view.findViewById(R.id.delete);
                final int position2 =position;
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Items items=list.get(position2);
                        list.remove(position2);
                        if(adapter!=null)
                        adapter.notifyDataSetChanged();
                        if(list==null)
                            number=0;
                        else
                        number=items.getIntegerNumber()+1;
                    }
                });


            }
        });
        ////////////////////////////////////////////////////////////////////////
        return mView;
    }
}