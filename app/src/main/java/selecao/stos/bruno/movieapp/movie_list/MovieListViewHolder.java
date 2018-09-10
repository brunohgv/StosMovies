package selecao.stos.bruno.movieapp.movie_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import selecao.stos.bruno.movieapp.R;

public class MovieListViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewTitle;
    public TextView textViewDescription;
    public ImageView imageViewCover;
    public CardView cardView;

    public MovieListViewHolder(@NonNull View itemView) {
        super(itemView);

        imageViewCover = (ImageView) itemView.findViewById(R.id.list_image);
        textViewTitle = (TextView) itemView.findViewById(R.id.list_title);
        textViewDescription = (TextView) itemView.findViewById(R.id.list_description);
        cardView = (CardView) itemView.findViewById(R.id.list_card);
    }

}
