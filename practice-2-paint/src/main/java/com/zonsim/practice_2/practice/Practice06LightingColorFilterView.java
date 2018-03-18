package com.zonsim.practice_2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zonsim.practice_2.R;


public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    private LightingColorFilter mNoRedLightingColorFilter;
    private LightingColorFilter mAddGreenLightingColorFilter;
    private PorterDuffColorFilter mPorterDuffColorFilter;
    
    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    
        /*  R' = R * mul.R / 0xff + add.R  
            G' = G * mul.G / 0xff + add.G  
            B' = B * mul.B / 0xff + add.B   */
        
        LightingColorFilter nochangelightingColorFilter = new LightingColorFilter(Color.WHITE, Color.BLACK);
        
        paint.setColorFilter(nochangelightingColorFilter);
    
        //去掉红色
        mNoRedLightingColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
    
        //增强绿色
        mAddGreenLightingColorFilter = new LightingColorFilter(Color.WHITE, 0x006600);
    
        mPorterDuffColorFilter = new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.OVERLAY);
    }
    
    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }
    
    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        
        // 第一个 LightingColorFilter：去掉红色部分
        paint.setColorFilter(mNoRedLightingColorFilter);  
        canvas.drawBitmap(bitmap, 0, 0, paint);
    
        // 第二个 LightingColorFilter：增强绿色部分
        //paint.setColorFilter(mAddGreenLightingColorFilter);
        paint.setColorFilter(mPorterDuffColorFilter);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
