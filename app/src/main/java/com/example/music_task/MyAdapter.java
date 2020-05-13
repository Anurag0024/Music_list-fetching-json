package com.example.music_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

  private   List<Listitem>listitems;
  private Context context;

  public MyAdapter(List<Listitem> listitems,Context context){
      this.listitems=listitems;
      this.context= context;
  }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_xml,parent,false);
       return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Listitem listitem= listitems.get(position);
        holder.artistname.setText(listitem.getArtistname());
        holder.trackname.setText(listitem.getTrackname());
        holder.primary.setText(listitem.getPrimary_generename());

        Picasso.with(context).load(listitem.getArtworkUrl())
                .into(holder.artwork);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"you clicked"+listitem.getTrackname(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView artistname;
        public  TextView trackname;
        public TextView primary;
        public ImageView artwork;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            artistname=(TextView)itemView.findViewById(R.id.artistname_id);
            trackname=(TextView)itemView.findViewById(R.id.trackname_id);
            primary=(TextView)itemView.findViewById(R.id.primary_genre_id);
            artwork=(ImageView)itemView.findViewById(R.id.artworkImg_id);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.linear_layout_id);
        }
    }


}
