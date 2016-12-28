package com.example.rogerpaviani.meuapp93getgithub;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private ListView lst_items;
    private TextView txt_url;
    private List<Repo> repoList;

    private String repoURL = "https://api.github.com/users/microsoft/repos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst_items = (ListView) findViewById(R.id.lst_items);
        txt_url = (TextView) findViewById(R.id.txt_url);

        txt_url.setText(repoURL);

        repoList = new ArrayList<Repo>();

        ShowLoader();
        GetRepos();
    }

    private void GetRepos() {

        if (true)
        {
            GetWithVolley();
        }
        else if (false)
        {
            GetWithAsyncHttp();
        }
        else if (false)
        {
            GetWithOkHttp();
        }
    }

    private void GetWithOkHttp() {
        OkHttpClient client = new OkHttpClient();
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(repoURL)
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();
            final JSONArray json = new JSONArray(response.body().toString());
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ExtractItems(json);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void GetWithAsyncHttp() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(repoURL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    int responseCode = httpURLConnection.getResponseCode();
                    String body;
                    final JSONArray json;
                    switch (responseCode) {
                        case HttpURLConnection.HTTP_OK:
                            body = StreamUtil.readStream(httpURLConnection.getInputStream());
                            json = new JSONArray(body);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ExtractItems(json);
                                }
                            });
                            break;
                        default:
                            Log.e("MainActivity", "Erro na requisiçao REPOS");
                            break;
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void GetWithVolley() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = repoURL;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        final JSONArray json = new JSONArray(response);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ExtractItems(json);
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("MainActivity", "Erro na requisiçao REPOS");
                }
            });
        // Add the request to the RequestQueue.
        //queue.add(stringRequest);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(final JSONArray response) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ExtractItems(response);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("MainActivity", "Erro na requisiçao REPOS");
                    }
                });
        queue.add(jsonArrayRequest);
    }

    private void ExtractItems(JSONArray json) {
        for (int i = 0; i < json.length(); i++) {
            try {
                repoList.add(ParseRepo(json.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ShowList();
    }

    private void ShowLoader()
    {
        //
    }

    private void HideLoader()
    {
        //
    }

    private void ShowList() {
        RepoAdapter repoAdapter = new RepoAdapter(repoList, this);
        lst_items.setAdapter(repoAdapter);
        HideLoader();
    }

    private Repo ParseRepo(JSONObject jsonObject) throws JSONException {
        String projectName = jsonObject.getString("name");
        String avatarUrl = jsonObject.getJSONObject("owner").getString("avatar_url");
        return new Repo(projectName, avatarUrl);
    }
}
