package com.example.rogerpaviani.meuapp63;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private EditText txtTo;
    private EditText txtSubject;
    private EditText txtMessage;
    private ImageView imgView;

    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTo = (EditText) findViewById(R.id.txt_to);
        txtSubject = (EditText) findViewById(R.id.txt_subject);
        txtMessage = (EditText)findViewById(R.id.txt_message);
        imgView = (ImageView) findViewById(R.id.img_attachment);
    }

    public void onClickAnexar(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 123);
    }

    public void onClickEnviar(View view) {
        String strTo = txtTo.getText().toString();
        String strSubject = txtSubject.getText().toString();
        String strMessage = txtMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("application/image");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ strTo });
        intent.putExtra(Intent.EXTRA_SUBJECT, strSubject);
        intent.putExtra(Intent.EXTRA_TEXT, strMessage);
        if (selectedImageUri!=null) {
            intent.putExtra(Intent.EXTRA_STREAM, selectedImageUri);
        }
        startActivity(Intent.createChooser(intent, "Send email..."));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK)
        {
            selectedImageUri = data.getData();
            InputStream inputStream = null;
            try{
                inputStream = getContentResolver().openInputStream(selectedImageUri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                imgView.setImageBitmap(bitmap);
                imgView.setVisibility(View.VISIBLE);
            }
            catch (FileNotFoundException e)
            {
                selectedImageUri = null;
                imgView.setVisibility(View.GONE);
            }
        }
    }
}
