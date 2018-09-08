package selecao.stos.bruno.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

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

import java.util.ArrayList;
import java.util.List;

import selecao.stos.bruno.movieapp.Model.Movie;

public class MainActivity extends AppCompatActivity {

    private static final String URL_MOVIES = "http://processo.stos.mobi/app/filme/listar";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieList = new ArrayList<>();

//        for (int i = 0 ; i < 10 ; i++){
//            Movie movie = new Movie(i, "title " + i, "description " + i);
//            movieList.add(movie);
//        }

        loadRecyclerViewData();

        adapter = new ListAdapter(movieList, this);
        recyclerView.setAdapter(adapter);
    }

    void loadRecyclerViewData () {
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL_MOVIES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            System.out.print("################################################" + jsonArray.toString());
                            for (int i = 0 ; i < jsonArray.length() ; i++) {
                                JSONObject movieObject = jsonArray.getJSONObject(i);
                                Movie movie = new Movie(
                                        movieObject.getInt("id"),
                                        movieObject.getString("titulo"),
                                        movieObject.getString("descricao"),
                                        movieObject.getString("capa"),
                                        movieObject.getString("url_imagem")
                                );
                                movieList.add(movie);
                            }
                            adapter = new ListAdapter(movieList, MainActivity.this);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG)
                            .show();
                        Log.e("Erro", error.getMessage());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
