package com.chenayi.header;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Banner banner;
    private ViewPager vp;
    private TabLayout tabLayout;

    private List<String> urls;
    private List<Fragment> fragments;
    private final String[] TITLES = new String[]{"全部", "未处理", "已完成", "已取消"};
    private CommomViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        vp = findViewById(R.id.vp);

        initUrls();
        initBanner();

        initFragments();

        adapter = new CommomViewPagerAdapter(getSupportFragmentManager(), TITLES, fragments);
        vp.setAdapter(adapter);

        tabLayout.setupWithViewPager(vp,false);
    }

    private void initBanner() {
        banner = findViewById(R.id.banner);
        banner
                .setImageLoader(new GlideImageLoader())
                .setImages(urls)
                .start();
    }

    private void initUrls() {
        urls = new ArrayList<>();

        urls.add("https://timgsa.baidu.com/timg?image&quality=80" +
                "&size=b9999_10000&sec=1523763557&di=db3efbcfee13022541680ed99518e893" +
                "&imgtype=jpg" +
                "&er=1" +
                "&src=http%3A%2F%2Fpic.97uimg.com%2Fback_pic%2F00%2F04%2F13%2F75%2Fb6c3d3579f6747dff7cf9bd2d0fe57ba.jpg");


        urls.add("https://timgsa.baidu.com/timg?image" +
                "&quality=80" +
                "&size=b9999_10000" +
                "&sec=1523168838042&di=b7788350abc776c00ad85f1286f6ee97&imgtype=0" +
                "&src=http%3A%2F%2Fpic.90sjimg.com%2Fback_pic%2F00%2F00%2F69%2F40%2F197fc7596ea416d86b027e3b945b6e04.jpg");

        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec" +
                "=1523167846473&di=d444096c9afdbbd628ab6a579e66e06d&imgtype=0&src=http%3" +
                "A%2F%2Fpic.90sjimg.com%2Fback_pic%2F00%2F00%2F69%2F40%2Fad1ec9813fa678f" +
                "4ade69ab4fbaccbce.jpg");
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            fragments.add(TestFragment.newInstance(i));
        }
    }
}
