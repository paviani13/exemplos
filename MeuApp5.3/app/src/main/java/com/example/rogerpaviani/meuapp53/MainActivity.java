package com.example.rogerpaviani.meuapp53;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText txtUrl;
    private ImageView imgDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUrl = (EditText) findViewById(R.id.txt_url);
        imgDownload = (ImageView) findViewById(R.id.img_download);
    }

    private String getCurrentDownloadURL(){
        return txtUrl.getText().toString();
    }

    private void confirmaDownload(){
        new AlertDialog.Builder(MainActivity.this)
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_dialog_map)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        fazDownload();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        limpaImgView();
                    }
                })
                .setTitle("Download da imagem")
                .setMessage("Tem certeza que quer fazer o download da imagem [" + getCurrentDownloadURL() + "] ?")
                .show();
    }

    private void fazDownload(){
        final ProgressDialog progressDialog = abreProgress();

        AsyncTask<String, Integer, Bitmap> downloadImage = new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                return DownloadUtil.downloadBitmap(strings[0]);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap==null)
                {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Erro")
                            .setMessage("Ocorreu um erro ao baixar a imagem.")
                            .show();
                }
                imgDownload.setImageBitmap(bitmap);
                progressDialog.hide();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }
        };

        downloadImage.execute(getCurrentDownloadURL());
    }

    private void limpaImgView(){
        imgDownload.setImageBitmap(null);
    }

    private ProgressDialog abreProgress(){
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Aguarde...");
        progressDialog.setMessage("Download em andamento ["+ getCurrentDownloadURL() +"]");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }

    public void onClickDownload(View view) {
        confirmaDownload();
    }
}
