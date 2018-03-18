package com.zonsim.practice_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {
    
    public Practice6DrawLineView(Context context) {
        super(context);
    }
    
    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        
        Paint paint = new Paint();

//        canvas.drawLine(100,100,500,100,paint);
    
        //                 0    1    2    3    4    5    6    7    8    9    10   11
        float[] points = {100, 100, 100, 300, 800, 400, 500, 500, 200, 150, 700, 900};


//        canvas.drawLines(points, paint);
        canvas.drawLines(points, 1, 8, paint);
        
        
    }
}
