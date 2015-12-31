package com.zhaoxuan.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zhaoxuan.scrollbanner.ScrollBanner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ScrollBanner scrollBanner;

    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    private BannerAdapter bannerAdapter;

    private List<BannerDto> bannerDtos;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollBanner = (ScrollBanner) findViewById(R.id.scrollBanner);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);

        bannerDtos = new ArrayList<>();
        bannerDtos.add(new BannerDto(1, "#FF34B3", 1, "1111111 : 5s", 1, 5000));
        bannerDtos.add(new BannerDto(2, "#EE6A50", 2, "2222222 : 3s", 1, 3000));
        bannerDtos.add(new BannerDto(3, "#B3EE3A", 3, "3333333 : 4s", 1, 4000));
        bannerDtos.add(new BannerDto(4, "#00CED1", 4, "4444444 : 3s", 1, 3000));
        bannerDtos.add(new BannerDto(5, "#5E5E5E", 5, "5555555 : 5s", 1, 5000));

        bannerAdapter = new BannerAdapter(this);
        bannerAdapter.setDatas(bannerDtos);

        scrollBanner.setAdapter(bannerAdapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollBanner.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollBanner.stop();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollBanner.fixBanner(2);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollBanner.hideCustomBanner();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                scrollBanner.next();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollBanner.nextOfModel(ScrollBanner.ORIENTATION_HORIZONTAL);
            }
        });


    }
}
