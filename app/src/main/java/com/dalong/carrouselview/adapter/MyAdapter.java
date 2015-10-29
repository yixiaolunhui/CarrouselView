package com.dalong.carrouselview.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dalong.carrouselview.R;
import com.dalong.carrouselview.entity.Photo;
import com.dalong.carrouselview.view.CarouselItem;

import java.util.List;


/**
 * 实现自己的适配器
 * @author zhouweilong
 *
 */
public final class MyAdapter extends CarouselBaseAdapter<Photo>{

	public MyAdapter(Context context, List<Photo> photos){
		super(context, photos);
	}

	@Override
	public CarouselItem<Photo> getCarouselItem(Context context){
		return new PhotoItem(context);
	}

	public static final class PhotoItem extends CarouselItem<Photo> {

		private LinearLayout image;


		private Context context;

		public PhotoItem(Context context){
			super(context, R.layout.item);
			this.context = context;
		}

		@Override
		public void extractView(View view){
			image = (LinearLayout) view.findViewById(R.id.item_image);
		}

		@Override
		public void update(Photo photo){
			if(photo.image.equals("1")){
				image.setBackgroundResource(R.drawable.point1);
			}
			if(photo.image.equals("2")){
				image.setBackgroundResource(R.drawable.point2);
			}
			if(photo.image.equals("3")){
				image.setBackgroundResource(R.drawable.point3);
			}

		}

	}


}
