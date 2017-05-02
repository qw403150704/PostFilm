package com.example.qw.postfilm.activity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.qw.postfilm.R;
import com.example.qw.postfilm.model.Film;
import com.example.qw.postfilm.model.FilmAdapter;
import com.example.qw.postfilm.model.in_theaterGson;
import com.example.qw.postfilm.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private String url = "https://api.douban.com/v2/movie/in_theaters";
    private String urlHead = "https://api.douban.com/v2/movie/";
    public static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        final Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.more);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Button leftBtn = (Button) findViewById(R.id.btn_left);
        final Button rightBtn = (Button) findViewById(R.id.btn_right);
        leftBtn.setVisibility(View.INVISIBLE);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("说明");
                builder.setMessage("应用数据来自豆瓣API，本页面最多显示20条信息\n\n作者邮箱：403150704@qq.com");
                builder.show();
            }
        });

        final TextView mainTitle = (TextView) findViewById(R.id.title_main);
        final TextView subTitle  = (TextView) findViewById(R.id.title_sub);


        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        final List<Film> filmList = new ArrayList<Film>();


        HttpUtil.sendOKHttpRequest(url,new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this,"erro",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {

                final String responceData = response.body().string();
                Gson gson = new Gson();
                Type type = new TypeToken<in_theaterGson>(){}.getType();
                final in_theaterGson data = gson.fromJson(responceData, type);
                final String count = String.valueOf(data.getCount());
                final String total = String.valueOf(data.getTotal());
                final List<in_theaterGson.Subjects> subjectsList = data.getSubjects();


                Bitmap bitmap = null;

                for (int i = 0; i < subjectsList.size(); i++) {
                    try {
                        bitmap = Glide.with(MainActivity.this).load(subjectsList.get(i).getImages().getMedium()).asBitmap().into(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL).get();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    Film myFilm = new Film(subjectsList.get(i).getId(),subjectsList.get(i).getRating().getAverage(),subjectsList.get(i).getTitle(),bitmap);

                    filmList.add(myFilm);
                }
//                Film mFilm = new Film("last",null,"",bmp);
//                filmList.add(mFilm);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (data.getTotal()<data.getCount()){
                            subTitle.setText(total +" / " + total);
                        }else {
                            subTitle.setText(count + " / " + total);
                        }
                        mainTitle.setText("正 在 上 映");
                        rightBtn.setVisibility(View.VISIBLE);
                        FilmAdapter adapter = new FilmAdapter(filmList,MainActivity.this);
                        recyclerView.setAdapter(adapter);
                    }
                });



            }
        });

    }

}
