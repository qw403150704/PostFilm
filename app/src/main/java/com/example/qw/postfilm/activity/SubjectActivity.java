package com.example.qw.postfilm.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.qw.postfilm.R;
import com.example.qw.postfilm.model.movieGson;
import com.example.qw.postfilm.util.HttpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.qiujuer.genius.blur.StackBlur;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by QW on 2017/4/25.
 */

public class SubjectActivity extends AppCompatActivity {

    String urlHead = "https://api.douban.com/v2/movie/";
    public static final String TAG2 = "SubjectActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        final TextView mainTitle = (TextView) findViewById(R.id.title_main);

        final ImageView image = (ImageView) findViewById(R.id.image_subject);
        final TextView title = (TextView) findViewById(R.id.sub_title);

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.sub_ratingStar);
        final TextView ratingText = (TextView) findViewById(R.id.sub_ratingText);
        final TextView altTitle = (TextView) findViewById(R.id.sub_altTitle);
        final TextView movieType = (TextView) findViewById(R.id.sub_type);
        final TextView time = (TextView) findViewById(R.id.sub_time);
        final TextView pubdata = (TextView) findViewById(R.id.sub_pubdata);
        final LinearLayout linearLayout_summary = (LinearLayout) findViewById(R.id.Linear_summary);


        final TextView director = (TextView) findViewById(R.id.sub_director);
        final TextView writer = (TextView) findViewById(R.id.sub_writer);
        final TextView mainActor = (TextView) findViewById(R.id.sub_mainActor);
        final TextView country = (TextView) findViewById(R.id.sub_country);
        final TextView link = (TextView) findViewById(R.id.sub_mobilelink);

        final LinearLayout linearLayout_subBgm = (LinearLayout) findViewById(R.id.Linear_bg);
        final TextView summary = (TextView) findViewById(R.id.summary_text);
        final TextView clickToSeeMore = (TextView) findViewById(R.id.sub_clickToSeeMore);
        final TextView ratingNum = (TextView) findViewById(R.id.sub_numText);

        Button right = (Button) findViewById(R.id.btn_right);
        right.setVisibility(View.INVISIBLE);
        Button back = (Button) findViewById(R.id.btn_left);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        Intent intent = getIntent();
        String id = intent.getStringExtra("filmId");
        String url = urlHead + id;
        HttpUtil.sendOKHttpRequest(url, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(SubjectActivity.this, "erro", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String responceData = response.body().string();
                Gson gson = new Gson();
                final Type type = new TypeToken<movieGson>() {
                }.getType();
                final movieGson res = gson.fromJson(responceData, type);
                String typeText = null;
                String directorText = null;
                String writerText = null;
                String actorText = null;
                String countryText = null;

                typeText = res.getAttrs().getMovie_type().get(0);
                if (res.getAttrs().getMovie_type().size() > 0) {
                    for (int i = 1; i < res.getAttrs().getMovie_type().size() - 1; i++) {
                        typeText = typeText + " / " + res.getAttrs().getMovie_type().get(i);
                    }
                }
                directorText = res.getAttrs().getDirector().get(0);
                if (res.getAttrs().getDirector().size() > 0) {
                    for (int i = 1; i < res.getAttrs().getDirector().size() - 1; i++) {
                        directorText = directorText + " / " + res.getAttrs().getDirector().get(i);
                    }
                }

                writerText = res.getAttrs().getWriter().get(0);
                if (res.getAttrs().getWriter().size() > 0) {
                    for (int i = 1; i < res.getAttrs().getWriter().size() - 1; i++) {
                        writerText = writerText + " / " + res.getAttrs().getWriter().get(i);
                    }
                }

                actorText = res.getAttrs().getCast().get(0);
                if (res.getAttrs().getCast().size() > 0) {
                    for (int i = 1; i < res.getAttrs().getCast().size() - 1; i++) {
                        actorText = actorText + " / " + res.getAttrs().getCast().get(i);
                    }
                }

                countryText = res.getAttrs().getCountry().get(0);
                if (res.getAttrs().getCountry().size() > 0) {
                    for (int i = 1; i < res.getAttrs().getCountry().size() - 1; i++) {
                        countryText = countryText + " / " + res.getAttrs().getCountry().get(i);
                    }
                }


                final String timeText = "片长：" + res.getAttrs().getMovie_duration().get(0);
                final String linkText = res.getMobile_link();
                directorText = "导演：" + directorText;
                writerText = "编剧：" + writerText;
                actorText = "主演：" + actorText;
                countryText = "制片国家/地区：" + countryText;


                String pubdataText = null;
                if (res.getAttrs().getPubdate() != null) {
                    pubdataText = "上映：" + res.getAttrs().getPubdate().get(0);
                }


                Bitmap bitmap = null;
                try {
                    bitmap = Glide.with(getApplicationContext()).load(res.getImage()).asBitmap().into(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL, com.bumptech.glide.request.target.Target.SIZE_ORIGINAL).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }


                final String finalTypeText = "类型：" + typeText;
                final String finalPubdataText = pubdataText;
                final Bitmap finalBitmap = bitmap;
                final Bitmap finalBitmap1 = bitmap;
                final String finalDirectorText = directorText;
                final String finalWriterText = writerText;
                final String finalActorText = actorText;
                final String finalCountryText = countryText;
                runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void run() {
                        mainTitle.setText("");
                        title.setText(res.getTitle());
                        ratingBar.setRating(res.getRating().getAverage() / 2);
                        ratingText.setText(String.valueOf(res.getRating().getAverage()));
                        ratingNum.setText("(" + String.valueOf(res.getRating().getNumRaters()) + "人评)");
                        altTitle.setText(res.getAlt_title());
                        movieType.setText(finalTypeText);
                        time.setText(timeText);
                        director.setText(finalDirectorText);
                        writer.setText(finalWriterText);
                        mainActor.setText(finalActorText);
                        country.setText(finalCountryText);
                        link.setText(linkText);

                        image.setImageBitmap(finalBitmap);
                        Bitmap bgmBitmap = null;
                        if (finalBitmap1 != null) {
                            bgmBitmap = Bitmap.createBitmap(finalBitmap, 0, 0, finalBitmap1.getWidth(), finalBitmap1.getHeight() / 3);
                        }
                        Bitmap newBitmap = StackBlur.blurNatively(bgmBitmap, 5, false);
                        Drawable drawable = new BitmapDrawable(newBitmap);
                        linearLayout_subBgm.setBackground(drawable);

                        if (res.getAttrs().getPubdate() != null) {
                            pubdata.setText(finalPubdataText);
                        } else {
                            pubdata.setText("上映：不详");
                        }


                        summary.setText(res.getSummary());
                        summary.setHeight(summary.getLineHeight() * 4);
                        summary.post(new Runnable() {
                            @Override
                            public void run() {
                                if (summary.getLineCount() > 4) {
                                    clickToSeeMore.setVisibility(View.VISIBLE);
                                    linearLayout_summary.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if (clickToSeeMore.getText().equals("V")) {
                                                clickToSeeMore.setText("A");
                                                summary.setMaxLines(100);
                                            } else {
                                                clickToSeeMore.setText("V");
                                                summary.setMaxLines(4);
                                            }
                                        }
                                    });
                                } else {
                                    clickToSeeMore.setVisibility(View.GONE);
                                }
                            }
                        });




                    }
                });

            }

        });
    }
}




