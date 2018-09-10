package selecao.stos.bruno.movieapp.movie_list;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import selecao.stos.bruno.movieapp.Model.Movie;
import selecao.stos.bruno.movieapp.R;
import selecao.stos.bruno.movieapp.movie_detail.MovieDetailActivity;

public class ListAdapter extends RecyclerView.Adapter<MovieListViewHolder> {

    private List<Movie> listMovies;
    private Context context;

    public ListAdapter(List<Movie> listMovies, Context context) {
        this.listMovies = listMovies;
        this.context = context;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int position) {
        final Movie movie = listMovies.get(position);

        Picasso.with(context)
                .load(movie.getImageURL())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageViewCover);
        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewDescription.setText(movie.getDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra("movie", movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

}
