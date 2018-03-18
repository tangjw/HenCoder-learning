package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice01ClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }
    
    public Practice01ClipRectView(Context context) {
        super(context);
    }
    
    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;
    
        canvas.drawBitmap(bitmap, 0, 0, paint);
    
        paint.setColor(Color.parseColor("#55CCCCCC"));
        canvas.drawRect(400, 300, 400 + bitmap.getWidth(), 300 + bitmap.getHeight(), paint);
    
        paint.reset();
       
        /*canvas.save();
        canvas.clipRect(400 + 50, 300 + 50, 
                400 - 50 + bitmap.getWidth(), 
                300 - 50 + bitmap.getHeight());
        canvas.drawBitmap(bitmap,400+50,300+50,paint);
        canvas.restore();*/
        canvas.save();
        Path path = new Path();
    
        path.addArc(400 + 50, 300 + 50,
                400 - 50 + bitmap.getWidth(),
                300 - 50 + bitmap.getHeight(), 0, -90);
        path.lineTo(400, 600);
        path.close();
        canvas.clipPath(path);
    
        canvas.drawBitmap(bitmap, 400 + 50, 300 + 50, paint);
        canvas.restore();
        
    }
}
