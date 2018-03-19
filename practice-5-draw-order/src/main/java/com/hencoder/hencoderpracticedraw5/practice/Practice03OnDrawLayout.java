package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class Practice03OnDrawLayout extends LinearLayout {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Pattern pattern = new Pattern();
    
    {
        // 在这里插入 setWillNotDraw(false) 以启用完整的绘制流程
       setWillNotDraw(false);
    }
    
    public Practice03OnDrawLayout(Context context) {
        super(context);
    }
    
    public Practice03OnDrawLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    
    public Practice03OnDrawLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    public void draw(Canvas canvas) {
        System.out.println("draw1");
        super.draw(canvas);
        System.out.println("draw2");
    }
    
    @Override
    public void onDrawForeground(Canvas canvas) {
        System.out.println("onDrawForeground1");
        super.onDrawForeground(canvas);
        System.out.println("onDrawForeground2");
    }
    
    
    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("onDraw1");
        super.onDraw(canvas);
        System.out.println("onDraw2");
        pattern.draw(canvas);
    }
    
    @Override
    protected void dispatchDraw(Canvas canvas) {
        System.out.println("dispatchDraw1");
        super.dispatchDraw(canvas);
        System.out.println("dispatchDraw2");
       
    }
    
    private class Pattern {
        private static final float PATTERN_RATIO = 5f / 6;
        
        Paint patternPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Practice03OnDrawLayout.Pattern.Spot[] spots;
        
        {
            patternPaint.setColor(Color.parseColor("#A0E91E63"));
        }
        
        private Pattern() {
            spots = new Practice03OnDrawLayout.Pattern.Spot[4];
            spots[0] = new Practice03OnDrawLayout.Pattern.Spot(0.24f, 0.3f, 0.026f);
            spots[1] = new Practice03OnDrawLayout.Pattern.Spot(0.69f, 0.25f, 0.067f);
            spots[2] = new Practice03OnDrawLayout.Pattern.Spot(0.32f, 0.6f, 0.067f);
            spots[3] = new Practice03OnDrawLayout.Pattern.Spot(0.62f, 0.78f, 0.083f);
        }
        
        private Pattern(Practice03OnDrawLayout.Pattern.Spot[] spots) {
            this.spots = spots;
        }
        
        private void draw(Canvas canvas) {
            int repitition = (int) Math.ceil((float) getWidth() / getHeight());
            for (int i = 0; i < spots.length * repitition; i++) {
                Practice03OnDrawLayout.Pattern.Spot spot = spots[i % spots.length];
                canvas.drawCircle(i / spots.length * getHeight() * PATTERN_RATIO + spot.relativeX * getHeight(), spot.relativeY * getHeight(), spot.relativeSize * getHeight(), patternPaint);
            }
        }
        
        private class Spot {
            private float relativeX;
            private float relativeY;
            private float relativeSize;
            
            private Spot(float relativeX, float relativeY, float relativeSize) {
                this.relativeX = relativeX;
                this.relativeY = relativeY;
                this.relativeSize = relativeSize;
            }
        }
    }
}
