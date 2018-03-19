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

public class Practice06SkewView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }
    
    public Practice06SkewView(Context context) {
        super(context);
    }
    
    public Practice06SkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice06SkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
    
        paint.setColor(Color.parseColor("#6CCCCCCC"));
        //paint.reset();
        canvas.save();
        //canvas.rotate(90,point1.x+bitmapWidth/2,point1.y+bitmapHeight/2);
        canvas.skew(-0.0f, 0.0f);
        
        //canvas.translate((bitmap.getWidth())/2,0);
        //canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.drawRect(point1.x,point1.y,point1.x+bitmapWidth,point1.y+bitmapHeight,paint);
    
        canvas.restore();
        
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    }
}
