package com.fudd.databindingstudy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseArray;

import com.fudd.databindingstudy.BaseActivity;
import com.fudd.databindingstudy.R;
import com.fudd.databindingstudy.databinding.CollectionBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nordpol on 2017/2/24 0024.
 */

public class CollectionActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CollectionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_collection);

        String[] literals = new String[]{"liang", "fei"};

        List<String> list = new ArrayList<>();
        SparseArray<String> sparse = new SparseArray<>(2);

        String key = "firstName";
        int index = 0;

        for (int i = 0; i < literals.length; i++) {
            list.add(literals[i]);
            sparse.put(i, literals[i]);
        }

        Map<String, String> map = new HashMap<>();
        map.put(key, "liang");
        map.put("lastName", "fei");

        binding.setIndex(index);    //  index =0
        binding.setKey(key);        //  key =firstName
        binding.setList(list);      //  list = {"liang", "fei"}
        binding.setSparse(sparse);  //  lei
        binding.setMap(map);        //  {firstName:"liang", lastName:"fei"}

    }
}
