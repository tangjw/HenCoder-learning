package com.zonsim.practice_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {

    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
    
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        
        
        canvas.drawOval(100,100,400,300,paint);
    
        paint.setStyle(Paint.Style.STROKE);
    
        canvas.drawOval(100,320,400,500,paint);
    
        RectF rectF = new RectF(500, 320, 700, 400);
        
        canvas.drawOval(rectF,paint);
        
    
    
    }
}
