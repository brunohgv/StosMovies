package selecao.stos.bruno.movieapp.movie_detail;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import selecao.stos.bruno.movieapp.Model.Movie;
import selecao.stos.bruno.movieapp.R;
import selecao.stos.bruno.movieapp.movie_list.MovieListActivity;

public class MovieDetailActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        getIncomingIntentData();
    }

    private void getIncomingIntentData () {
        if (getIntent().hasExtra("movie")) {
            Movie movie = (Movie) getIntent().getExtras().getSerializable("movie");
            setData(movie);
        }
    }

    private void setData (Movie movie) {
        ImageView imageView = findViewById(R.id.movie_detail_image);
        TextView textViewTitle = findViewById(R.id.movie_detail_title);
        TextView textViewDescription = findViewById(R.id.movie_detail_description);

        Picasso.with(this).load(movie.getImageURL()).into(imageView);
        textViewTitle.setText(movie.getTitle());
        textViewDescription.setText(movie.getDescription());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = new Intent(getApplicationContext(), MovieListActivity.class);
        startActivityForResult(intent, 0);
        return true;
    }

}
