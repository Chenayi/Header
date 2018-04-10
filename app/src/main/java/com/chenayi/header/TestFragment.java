package com.chenayi.header;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenwy on 2018/4/8.
 */

public class TestFragment extends Fragment {
    private RecyclerView rv;

    private int index;
    private ListAdapter listAdapter;

    public static TestFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        index = arguments.getInt("index");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_test, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listAdapter = new ListAdapter(datas());
        rv = getView().findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(listAdapter);
    }

    private List<String> datas() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("text : " + (i + 1));
        }
        return datas;
    }
}
