package com.dalong.carrouselview.adapter;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dalong.carrouselview.view.CarouselItem;

/**
 * 适配器父类
 * @author zhouweilong
 *
 * @param <T>
 */
public abstract class CarouselBaseAdapter<T> extends BaseAdapter{

  private final List<CarouselItem<T>> items = new ArrayList<CarouselItem<T>>();

  public CarouselBaseAdapter(Context context, List<T> items){
    for (int i = 0; i < items.size(); i++){
      final CarouselItem<T> item = getCarouselItem(context);
      item.setIndex(i);
      item.update(items.get(i));
      this.items.add(item);
    }
  }

  @Override
  public int getCount(){
    if (items == null){
      return 0;
    }

    return items.size();
  }

  @Override
  public Object getItem(int position){
    return position;
  }

  @Override
  public long getItemId(int position){
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent){
    return items.get(position);
  }

  public abstract CarouselItem<T> getCarouselItem(Context context);

}
