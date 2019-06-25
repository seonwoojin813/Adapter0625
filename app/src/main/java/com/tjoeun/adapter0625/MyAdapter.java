package com.tjoeun.adapter0625;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    //뷰를 전개하기 위해서 필요한 Context
    Context context;
    //전개할 뷰(레이아웃)의 id
    int layout;
    //출력할 데이터
    List<VO> data;

    //생성자에서 위의 3개를 주입
    public MyAdapter(Context context, int layout,
                     List<VO>data ){
        this.context = context;
        this.layout = layout;
        this.data = data;

    }

    @Override
    //테이블의 행의 개수를 설정하는 메소드
    public int getCount(){
        return data.size();
    }

    @Override
    //행의 문자열을 설정하는 메소드
    public Object getItem(int position){
        return data.get(position).name;
    }

    @Override
    //행의 ID를 설정하는 메소드
    public long getItemId(int position){
        return position;
    }

    @Override
    //항목뷰를 만들어주는 메소드
    //position은 뷰가 출력되는 인덱스
    //parent는 항목 뷰가 놓이게 될 ListView
    public View getView(
            int position, View convertView,
            ViewGroup parent){
        //XML로 만든 뷰를 전개하기 위한 객체 생성
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    //재사용할 뷰가 없으면 생성
        if(convertView == null){
            convertView = inflater.inflate(
                    layout, parent, false);
        }
        //위치에 따라 배경색을 다르게 저장
        if(position % 2 == 0)
            convertView.setBackgroundColor(Color.RED);
        else
            convertView.setBackgroundColor(Color.BLUE);

        //레이아웃 파일에 디자인한 이미지 뷰 가져오기
        ImageView imageView = (ImageView)convertView.findViewById(R.id.img);

        //이미지 출력
        imageView.setImageResource(data.get(position).icon);

        //텍스트 뷰에 텍스트 출력하기
        TextView textView = (TextView)convertView.findViewById(R.id.btn);
        textView.setText(data.get(position).name);

        //Button
        //버튼의 이벤트 처리를 익명객체로 하는 경우
        //익명 객체는 자신이 포함된 메소드의 지역변수를 사용할 수 없으므로
        //final로 변환해서 사용
        final int pos = position;
        Button btn = (Button)convertView.findViewById(R.id.btn);
        btn.setOnClickListener((view)->{
           //Log.e("이벤트", "버튼 클릭");

            VO vo = data.get(pos);
            Toast.makeText(
                    context, vo.name,
                    Toast.LENGTH_LONG).show();
        });

        return  convertView;




    }



}
