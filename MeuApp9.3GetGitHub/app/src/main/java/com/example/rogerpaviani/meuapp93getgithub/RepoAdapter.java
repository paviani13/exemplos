package com.example.rogerpaviani.meuapp93getgithub;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by roger.paviani on 19/12/2016.
 */

public class RepoAdapter extends BaseAdapter {

    private List<Repo> repoList;
    private Activity activity;

    public RepoAdapter(List<Repo> repoList, Activity activity) {
        this.repoList = repoList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return this.repoList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.repoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view ==null)
        {
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.repo_layout, null);
        }

        Repo repo = this.repoList.get(i);

        TextView txtRepoName = (TextView) view.findViewById(R.id.txt_reponame);
        txtRepoName.setText(repo.ProjectName);

        final ImageView imgAvatar = (ImageView) view.findViewById(R.id.img_avatar);

        Picasso
                .with(activity.getApplicationContext())
                .load(repo.OwnerAvatar)
                .resize(100, 100)
                .centerCrop()
                .into(imgAvatar);
//        AsyncTask<String, Void, Bitmap> downloadImage = new AsyncTask<String, Void, Bitmap>() {
//            @Override
//            protected Bitmap doInBackground(String... strings) {
//                return BitmapUtil.downloadBitmap(strings[0]);
//            }
//
//            @Override
//            protected void onPostExecute(Bitmap bitmap) {
//                imgAvatar.setImageBitmap(bitmap);
//            }
//        };
//        downloadImage.execute(repo.OwnerAvatar + "&s=50&");

        return view;
    }
}
