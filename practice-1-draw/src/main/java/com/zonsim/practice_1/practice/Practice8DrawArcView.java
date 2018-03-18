package com.zonsim.practice_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    
    public Practice8DrawArcView(Context context) {
        super(context);
    }
    
    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        
        
        Paint paint = new Paint();
    
        paint.setStyle(Paint.Style.FILL);
    
        paint.setStrokeWidth(10);
    
        // canvas.drawRect(100, 100, 600, 500, paint);
    
        canvas.drawArc(100, 100, 600, 500, -90, -145, false, paint);
        
    }
}
