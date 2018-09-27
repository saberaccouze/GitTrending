package com.trending.git.gittrending;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.trending.git.gittrending.adapters.ReposAdapter;
import com.trending.git.gittrending.classes.Repos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ReposAdapter adpter;
    private ListView lvGitTrending;
    private RequestQueue myVollyList;
    private List<Repos> trendingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvGitTrending=findViewById(R.id.lvGitHubTrending);
        trendingList = new ArrayList<>();
       // myVollyList = Volley.newRequestQueue(this);
        //trendingJsonParse();
        adpter = new ReposAdapter(getApplicationContext(),trendingList);
        lvGitTrending.setAdapter(adpter);
    }

    private void trendingJsonParse() {
        String url ="https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray newArray = response.getJSONArray("items");
                    for (int i =0 ; i<newArray.length();i++ ){
                        JSONObject repository = newArray.getJSONObject(i);
                        trendingList.add(
                                new Repos(repository.getString("name"),
                                        repository.getString("description"),
                                        Float.parseFloat(repository.getString("score")),
                                        repository.getJSONObject("owner").getString("login"),
                                        repository.getJSONObject("owner").getString("avatar_url")
                                )
                        );
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }

}
