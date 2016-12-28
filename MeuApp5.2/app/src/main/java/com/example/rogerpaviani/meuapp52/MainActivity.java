package com.example.rogerpaviani.meuapp52;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> stringList = new ArrayList<String>();
        stringList.add("http://ichef.bbci.co.uk/news/660/cpsprodpb/025B/production/_85730600_monkey2.jpg");
        stringList.add("http://static.tumblr.com/a89de0905df7f8f0d7785951ba661c3f/pqepffb/NWGmpqzw8/tumblr_static_295610_302158819913453_1148071692_n.jpg");
        stringList.add("https://pbs.twimg.com/profile_images/2799847701/adc9bf61f61a3677547eb102737d87d6_400x400.png");

        Double position = Math.random();
        String imageUrl = stringList.get((position > 0.7) ? 0 : (position > 4) ? 1 : 2);

        final ImageView imageView = (ImageView) findViewById(R.id.img_download);

        AsyncTask<String, Integer, Bitmap> downloadImage = new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                return DownloadUtil.downloadBitmap(strings[0]);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }
        };

        downloadImage.execute(imageUrl);
    }
}
