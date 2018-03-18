package com.zonsim.practice_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {
    
    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }
    
    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        
        
        Paint paint = new Paint();
        
        paint.setStyle(Paint.Style.STROKE);
        
        canvas.drawRoundRect(100, 100, 400, 400,5000,5000,paint );
        
        
    }
}