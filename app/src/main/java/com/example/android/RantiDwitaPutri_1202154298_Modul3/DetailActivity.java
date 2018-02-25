package com.example.android.RantiDwitaPutri_1202154298_Modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView mainTitle, count, air;
    ImageView mainImage;
    int water, max, min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //initialize the ImageView and title TextView
        TextView mainTitle = (TextView) findViewById(R.id.titleDetail);  //memasukkan title
        ImageView mainImage = (ImageView) findViewById(R.id.ImageDetail); // memasukkan imagenya
        ImageView air = (ImageView) findViewById(R.id.air);

        int water = 0; //memberikan nilai awal pada variabel water
        air.setImageLevel(water);
        Toast.makeText(this, "Air Sedikit", Toast.LENGTH_SHORT).show(); //menampilkan toast jika airnya sedikit

        //menampilkan gambar yang dipilih dari halaman sebelumnya
        Drawable drawable = ContextCompat.getDrawable(this, getIntent().getIntExtra(Main.IMAGE_KEY, 0));

        //membuat objek dan set warna pada objek GradientDrawable
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //mengecek drawable kosong atau tidak nya
        if (drawable != null){
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        mainTitle.setText(getIntent().getStringExtra(Main.TITLE_KEY));

        Glide.with(this).load(getIntent().getIntExtra(Main.IMAGE_KEY, 0)).placeholder(gradientDrawable).into(mainImage);
    }
    public void IncreaseScore(View view) { //membuat agar increase bisa diklik dan bisa bertambah
        ImageView air = (ImageView) findViewById(R.id.air);
        count = (TextView) findViewById(R.id.count);

        int max = 6;
        if (water < max){
            water++;
            air.setImageLevel(water);
            count.setText(String.valueOf(water) + " L ");
            if (water == max){
                Toast.makeText(this, "Air Sudah Penuh", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void DecreaseScore(View view) {   //membuat agar deccrease bisa diklik dan bisa berkurang
        ImageView air = (ImageView) findViewById(R.id.air);
        count = (TextView) findViewById(R.id.count);

        int min = 0;
        if (water > 0){
            water--;
            air.setImageLevel(water);
            count.setText(String.valueOf(water) + " L " );
            if ( water == 0 ){
                Toast.makeText(this, "Air Sedikit", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
