package com.example.tarun.uitsocieties;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.os.Build.VERSION_CODES.M;
import static com.example.tarun.uitsocieties.InClub.event_detail;
import static com.example.tarun.uitsocieties.MainActivity.width;

/**
 * Created by Tarun on 16-Aug-17.
 */

/**********************  ARRAY ADAPTER FOR CLUB LOGOS GRID LAYOUT  ********************/

public class MyArrayAdap extends RecyclerView.Adapter<MyArrayAdap.MyViewHolder> {

    public static int CLUB_NO;
    Context con;
    ArrayList<Data1> club_data;
    int layout;


    public MyArrayAdap(Context context, ArrayList<Data1> data, int layout) {
        con = context;
        club_data = data;
        this.layout = layout;
    }

    @Override
    public MyArrayAdap.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(con);
        View photoView = inflater.inflate(layout, parent, false);
        MyArrayAdap.MyViewHolder viewHolder = new MyArrayAdap.MyViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Data1 curr_club = club_data.get(position);
        ImageView imageView = holder.mClubImageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Glide.with(con)
                .load(curr_club.getImg_res_Id())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.color_gray_place))
                .into(imageView);

        TextView name = holder.club_name;
        name.setText(curr_club.getClub_name());
    }

    @Override
    public int getItemCount() {
        return club_data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView mClubImageView;
        public TextView club_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            if((itemView.findViewById(R.id.club_name))!=null) {
                club_name = (TextView) itemView.findViewById(R.id.club_name);
            }
            mClubImageView = (ImageView) itemView.findViewById(R.id.club_logo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent in = new Intent(con,InClub.class);
            in.setFlags(getAdapterPosition());
            event_detail = false;
            con.startActivity(in);
        }
    }
}
