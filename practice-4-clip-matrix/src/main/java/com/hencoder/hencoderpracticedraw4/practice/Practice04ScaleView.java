package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice04ScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }
    
    public Practice04ScaleView(Context context) {
        super(context);
    }
    
    public Practice04ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice04ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        
        paint.setColor(Color.parseColor("#6CCCCCCC"));
        canvas.drawRect(point1.x,point1.y,point1.x+bitmapWidth,point1.y+bitmapHeight,paint);
        paint.reset();
        
        
        //canvas.scale() 参数 缩放x 缩放外y  缩放原点(x,y)
        
        canvas.save();
        canvas.scale(1.2f, 0.8f,point1.x,point1.y+bitmapHeight);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    }
}
