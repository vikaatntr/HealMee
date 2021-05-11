package com.v.healme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detail_book extends AppCompatActivity {

    ImageView mGambar;
    TextView mJudul, mAuthor, mHalaman, mDesc;

    String iGambar, iJudul, iAuthor, iHalaman, iDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        mGambar = findViewById(R.id.book1);
        mJudul = findViewById(R.id.judul_book1);
        mAuthor = findViewById(R.id.author_book1);
        mHalaman = findViewById(R.id.halaman_book1);
        mDesc = findViewById(R.id.textDesc);

        Intent intent = getIntent();
        iGambar = intent.getStringExtra("gambar");
        iJudul = intent.getStringExtra("judul");
        iAuthor = intent.getStringExtra("author");
        iHalaman = intent.getStringExtra("halaman");
        iDesc = intent.getStringExtra("desk");


        if (intent != null){
            mJudul.setText(iJudul);
            mDesc.setText(iDesc);
            Glide.with(detail_book.this).load(iGambar).into(mGambar);
        }
    }
}