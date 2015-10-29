package com.dalong.carrouselview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dalong.carrouselview.adapter.MyAdapter;
import com.dalong.carrouselview.entity.Photo;
import com.dalong.carrouselview.view.Carousel;
import com.dalong.carrouselview.view.CarouselAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Carousel carousel;
    private final List<Photo> photos = new ArrayList<Photo>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        carousel = (Carousel) findViewById(R.id.carousel);

        photos.add(new Photo("Photo1", "1"));
        photos.add(new Photo("Photo2", "2"));
        photos.add(new Photo("Photo3", "3"));
        photos.add(new Photo("Photo3", "1"));
        photos.add(new Photo("Photo3", "2"));
        photos.add(new Photo("Photo3", "3"));
        photos.add(new Photo("Photo3", "1"));
        photos.add(new Photo("Photo3", "2"));
        photos.add(new Photo("Photo3", "3"));

        adapter = new MyAdapter(this, photos);
        carousel.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        carousel.setGravity(Gravity.CENTER);

        carousel.setOnItemClickListener(new CarouselAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CarouselAdapter<?> carouselBaseAdapter, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "The item '" + position + "' has been clicked", Toast.LENGTH_SHORT).show();
                carousel.scrollToChild(position);
            }
        });
        carousel.setOnItemSelectedListener(new CarouselAdapter.OnItemSelectedListener() {

            @Override
            public void onItemSelected(CarouselAdapter<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "The item" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(CarouselAdapter<?> parent) {
                // TODO Auto-generated method stub

            }
        });
        carousel.setOnItemLongClickListener(new CarouselAdapter.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(CarouselAdapter<?> carouselBaseAdapter, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "The item '" + position + "' has been long clicked", Toast.LENGTH_SHORT).show();
                carousel.scrollToChild(position);
                return false;
            }

        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
