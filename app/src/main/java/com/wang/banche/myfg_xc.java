package com.wang.banche;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by wang on 2019/1/13.
 */
public class myfg_xc extends Fragment {

    private ListView lv;
    private int[] imgids = new int[]{R.mipmap.luxian,R.mipmap.luxian, R.mipmap.luxian, R.mipmap.luxian,R.mipmap.luxian,R.mipmap.luxian,R.mipmap.luxian,R.mipmap.luxian,R.mipmap.luxian,R.mipmap.luxian,R.mipmap.luxian};
    private String[] A = new String[]{"07:24/35", "07:35",    "07:40",    "07:35",    "17:50",      "19:15",    "20:15",    "21:15",      "22/23/00:15",  "19:45",    "9:15"};
    private String[] B = new String[]{"北孝城",    "东方/北关", "沧州银行",   "东方街",   "厂区",        "厂区",      "厂区",    "厂区",        "厂区",         "沧州银行",   "厂区"};
    private String[] C = new String[]{"白班",      "白班",      "白班",     "白班",     "白班",        "白班",      "白班",     "白班",        "白班",         "夜班",     "夜班"};
    private String[] E = new String[]{"上班",      "上班",      "上班",      "上班",    "下班",        "下班",      "下班",     "下班",         "下班",        "上班",     "下班"};
    private String[] F = new String[]{"厂区",      "厂区",      "厂区",      "厂区",    "北孝/沧/县城","县/沧",      "县/沧",   "北孝/沧/县城",   "县城",       "厂区",      "县城"};
    private String[] G = new String[]{"内",        "内",        "末",       "末",      "内/末",       "内/末",     "内/末",    "内/末",         "内/末",       "内/末",    "内/末"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_xc, container, false);
        lv = view.findViewById(R.id.lv3);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SimpleAdapter myAdapter = new SimpleAdapter(getActivity(), getData(), R.layout.item,
                new String[]{"lx", "AA", "BB", "CC", "EE", "FF", "GG"},
                new int[]{R.id.a4, R.id.a1, R.id.a2, R.id.a3, R.id.a5, R.id.a6, R.id.a7,});
        lv.setAdapter(myAdapter);
    }

    private List<? extends Map<String, ?>> getData() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < A.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("lx", imgids[i]);
            showitem.put("AA", A[i]);
            showitem.put("BB", B[i]);
            showitem.put("CC", C[i]);
            showitem.put("EE", E[i]);
            showitem.put("FF", F[i]);
            showitem.put("GG", G[i]);
            list.add(showitem);
        }
        return list;
    }
}