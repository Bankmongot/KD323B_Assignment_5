package se.k3.antonochisak.kd323bassignment5.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import se.k3.antonochisak.kd323bassignment5.models.movie.Movie;
import se.k3.antonochisak.kd323bassignment5.R;
import se.k3.antonochisak.kd323bassignment5.helpers.StaticHelpers;
import se.k3.antonochisak.kd323bassignment5.models.movie.Movie;

/**
 * Created by Viktors on 2015-04-29.
 */
public class MyAdapter extends BaseAdapter {

        ArrayList<Movie> mMovies;
        LayoutInflater mLayoutInflater;

        private int mItemWidth, mItemHeight, mMargin;

        public MyAdapter(ArrayList<Movie> mMovies, LayoutInflater mLayoutInflater) {
        this.mMovies = mMovies;
        this.mLayoutInflater = mLayoutInflater;
    }

    class ViewHolder{
        @InjectView(R.id.iv_poster)
        ImageView iv_poster;


        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.movies_list, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Load pictures with picasso
        Picasso.with(view.getContext())
                .load(mMovies.get(position).getPoster())
                        //  .resize(mItemWidth, mItemHeight)
                .into(holder.iv_poster);



        TextView movie_text = (TextView)view.findViewById(R.id.movie_t);


        String years = String.valueOf(mMovies.get(position).getYear());

        movie_text.setText(mMovies.get(position).getTitle() + " (" + years + ")");

        TextView movie_slug = (TextView)view.findViewById(R.id.movie_desc);

        String slug = String.valueOf(mMovies.get(position).getSlugline());

        movie_slug.setText(slug);


        Log.i("tagline", "movies "+mMovies.get(position).getYear());


        return view;
    }



        @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
