package com.example.samim.recylerview_volly_glide_gson_json.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.samim.recylerview_volly_glide_gson_json.R;
import com.example.samim.recylerview_volly_glide_gson_json.UserDetail.User;

/**
 * Created by SAMIM on 2/11/2018.
 */


//RecylerView


public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {
    private Context context;
    private User[] data;
    public GithubAdapter(Context context, User [] data)
    {
        this.context=context;
        this.data=data;
    }

    @Override
    public GithubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_user_layout,parent,false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GithubViewHolder holder, int position) {
        //pass url data
        final User user=data[position];
        //pass url text data
        holder.txtUser.setText(user.getLogin());
        //pass url image
        Glide.with(holder.imgUser.getContext()).load(user.getAvatarUrl()).into(holder.imgUser);


        //parfrom cllick event in eatch item;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,user.getLogin()+"  cllicked", Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder{
        ImageView imgUser;
        TextView txtUser;
        public GithubViewHolder(View itemView) {
            super(itemView);

            imgUser=(ImageView) itemView.findViewById(R.id.imgUser);
            txtUser=(TextView)itemView.findViewById(R.id.textUser);
        }
    }
}
