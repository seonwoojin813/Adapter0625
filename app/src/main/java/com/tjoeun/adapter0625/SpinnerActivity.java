package com.tjoeun.adapter0625;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SpinnerActivity extends AppCompatActivity {

    String [] ar;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    TextView nation;

    //시작할 때 이벤트가 발생한 것인지 확인하기 위한 변수
    boolean flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        //스피너 출력
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setPrompt("여행가고 싶은 나라를 선택하기");

        adapter = ArrayAdapter.createFromResource(
                SpinnerActivity.this,
                R.array.nations,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //arrays.xml 에 만든 배열을 가져오기
        ar = getResources().getStringArray(R.array.nations);
        //spinner에서 선택을 했을 때의 이벤트 처리
        spinner.setOnItemSelectedListener(
                new Spinner.OnItemSelectedListener(){
                    //선택을 했을 때 호출되는 메소드
                    @Override
                    public void onItemSelected(
                            AdapterView parent, View view,
                            int position, long id){
                        if(flag == false){
                            flag = true;
                            return;
                        }
                        Toast.makeText(SpinnerActivity.this,
                                ar[position], Toast.LENGTH_LONG).show();

                        nation = (TextView)findViewById(R.id.nation);
                        nation.setText(ar[position]);

                    }
                    @Override
                    public  void onNothingSelected(AdapterView parent){

                    }
                });

        final ProgressBar lect = (ProgressBar)findViewById(R.id.progressbar);
        final ProgressBar indicator = (ProgressBar)findViewById(R.id.indicator);
        Button start = (Button)findViewById(R.id.start);
        Button end = (Button)findViewById(R.id.end);

        start.setOnClickListener((view) ->{
          lect.setProgress(75);
          lect.setSecondaryProgress(99);
          indicator.setVisibility(View.VISIBLE);
        });

        end.setOnClickListener((view) -> {
            indicator.setVisibility(View.GONE);
                });


    }
}
