package com.tjoeun.adapter0625;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //리스트 뷰에 출력할 데이터
    List<Map<String,String>> list = new ArrayList<>();
    //리스트 뷰 출력을 위한 Adapter
    SimpleAdapter adapter;
    //화면에 출력할 ListView
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> map = new HashMap<>();
        map.put("nation", "Portugal");
        map.put("player", "Ronaldo");
        list.add(map);

        map =new HashMap<>();
        map.put("nation", "Argentina");
        map.put("player", "Messi");
        list.add(map);

        map =new HashMap<>();
        map.put("nation", "Brazil");
        map.put("player", "Neymar");
        list.add(map);

        //adapter 만들기
        adapter = new SimpleAdapter(MainActivity.this, list, android.R.layout.simple_expandable_list_item_2,
                new String[] {"nation", "player"},
                new int[]{android.R.id.text1, android.R.id.text2});

        //ListView를 가져와서 연결하기
        listView = (ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);




    }
}
