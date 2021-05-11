package com.v.healme;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.ViewHolder> {

    private Context mContext;
    ArrayList<HashMap<String, String>> list_buku;

    public recyclerAdapter(list_book mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.mContext = mainActivity;
        this.list_buku = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        Glide.with(context)
//                .load("http://192.168.95.77/app_blogvolley/img/" + list_data.get(position).get("gambar"))
//                .crossFade()
//                .placeholder(R.mipmap.ic_launcher)
//                .into(holder.imghape);
        holder.txtjudul.setText(list_buku.get(position).get("judul_buku"));
        holder.txtauthor.setText(list_buku.get(position).get("author_buku"));
        holder.txthalaman.setText(list_buku.get(position).get("halaman_buku"));
        Glide.with(mContext).load(list_buku.get(position).get("gambar_buku")).into(holder.mGambar);

        holder.mKonten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, detail_book.class);

                intent.putExtra("judul", list_buku.get(position).get("judul_buku"));
                intent.putExtra("author", list_buku.get(position).get("author_buku"));
                intent.putExtra("halaman", list_buku.get(position).get("halaman_buku"));
                intent.putExtra("desk", list_buku.get(position).get("deskripsi_buku"));
                intent.putExtra("gambar", list_buku.get(position).get("gambar_buku"));

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_buku.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtjudul,txtauthor,txthalaman;
        ImageView mGambar;
        LinearLayout mKonten;

        public ViewHolder(View itemView) {
            super(itemView);

            txtjudul = (TextView) itemView.findViewById(R.id.judul_book1);
            txtauthor = (TextView) itemView.findViewById(R.id.author_book1);
            txthalaman = (TextView) itemView.findViewById(R.id.halaman_book1);
            mGambar = (ImageView) itemView.findViewById(R.id.book1);
            mKonten = (LinearLayout)  itemView.findViewById(R.id.konten_item);
        }
    }

}