package com.example.rogerpaviani.meuapp92network;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button btnGet;
    private Button btnPost;
    private TextView txtResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResponse = (TextView) findViewById(R.id.txt_response);

        btnPost = (Button) findViewById(R.id.btn_post);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        URL url;
                        HttpURLConnection httpURLConnection;

                        try {
                            url = new URL("http://httpbin.org/post");
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("POST");
                            int responseCode = httpURLConnection.getResponseCode();
                            final String body;
                            switch (responseCode) {
                                case HttpURLConnection.HTTP_OK:
                                    body = StreamUtil.readStream(httpURLConnection.getInputStream());
                                    break;
                                default:
                                    body = "Erro na requisição!";
                                    break;
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtResponse.setText(formatString(body));
                                }
                            });

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btnGet = (Button) findViewById(R.id.btn_get);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        URL url;
                        HttpURLConnection httpURLConnection;

                        try {
                            url = new URL("http://httpbin.org/get");
                            httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("GET");
                            int responseCode = httpURLConnection.getResponseCode();
                            final String body;
                            switch (responseCode) {
                                case HttpURLConnection.HTTP_OK:
                                    body = StreamUtil.readStream(httpURLConnection.getInputStream());
                                    break;
                                default:
                                    body = "Erro na requisição!";
                                    break;
                            }

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtResponse.setText(formatString(body));
                                }
                            });

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public static String formatString(String text) {
        StringBuilder json = new StringBuilder();
        String indentString = "";

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            switch (letter) {
                case '{':
                case '[':
                    json.append("\n" + indentString + letter + "\n");
                    indentString = indentString + "\t";
                    json.append(indentString);
                    break;
                case '}':
                case ']':
                    indentString = indentString.replaceFirst("\t", "");
                    json.append("\n" + indentString + letter);
                    break;
                case ',':
                    json.append(letter + "\n" + indentString);
                    break;

                default:
                    json.append(letter);
                    break;
            }
        }

        return json.toString();
    }
}
