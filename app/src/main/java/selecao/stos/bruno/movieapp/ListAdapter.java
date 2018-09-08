package selecao.stos.bruno.movieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import selecao.stos.bruno.movieapp.Model.Movie;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Movie> listMovies;
    private Context context;

    public ListAdapter(List<Movie> listMovies, Context context) {
        this.listMovies = listMovies;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = listMovies.get(position);

        Picasso.with(context).load(movie.getImageURL()).into(holder.imageViewCover);
        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewDescription.setText(movie.getDescription());
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitle;
        public TextView textViewDescription;
        public ImageView imageViewCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewCover = (ImageView) itemView.findViewById(R.id.imageViewCover);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
        }
    }
}
