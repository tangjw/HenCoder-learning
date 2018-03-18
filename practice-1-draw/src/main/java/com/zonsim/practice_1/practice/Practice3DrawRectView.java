package com.zonsim.practice_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    public Practice3DrawRectView(Context context) {
        super(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
    
        Paint paint = new Paint();
    
        RectF rectF = new RectF(100.5f, 100.5f, 300.0f, 200.0f);
        Rect rect = new Rect(100, 160, 300, 320);
    
    
        canvas.drawRect(rectF, paint);
        canvas.drawRect(rect, paint);
    
    
    }
}
