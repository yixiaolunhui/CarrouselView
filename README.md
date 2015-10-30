# CarrouselView
旋转木马优化版，适合超过5个以上的旋转view界面
如果你只需要3-4个的切换的话还是采用这个吧：
https://github.com/dalong982242260/LoopRotarySwitch
##效果
 ![image](https://github.com/dalong982242260/CarrouselView/blob/master/screenshot/carouselview.gif)       
   
##本代码借鉴于：http://www.codeproject.com/Articles/146145/Android-3D-Carousel
              修改而来

##优点：
1、布局可以随意自定义，不受只是图片的限制。
2、增加点击切换到中间位置。
3、手势滑动切换。
4、切换中间回调。
5、自定义适配器更加方便用户设置自己需要的布局。
##使用方法
  1、布局文件引用
  <com.dalong.carrouselview.view.Carousel
        android:id="@+id/carousel"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        />
        
   2、代码设置数据
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
          
   

