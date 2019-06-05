package com.example.helloworld.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.example.helloworld.R;

public class CircleButton extends AppCompatButton {
    private boolean widthEqualHeight = true;
    public CircleButton(Context context)
    {
        this(context, null);
    }

    public CircleButton(Context context, AttributeSet attrs)
    {
        this(context, attrs, R.attr.buttonStyle);
    }
    public CircleButton(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        if(attrs!=null)
        {
            TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.CircleButton);
            this.widthEqualHeight = attrArray.getBoolean(R.styleable.CircleButton_widthEqualHeight, this.widthEqualHeight);

            attrArray.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(widthEqualHeight)
        {
            String text = this.getText().toString();
            float textSize = this.getTextSize();
            int width = (int)this.getTextWidth(text, textSize);
            int height = (int)this.getTextHeight(text, textSize);
            int max_val = width > height ? width : height;
            int maxSpec = MeasureSpec.makeMeasureSpec(max_val, MeasureSpec.EXACTLY);
            super.onMeasure(maxSpec, maxSpec);
        }
        else
        {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
        this.setBackgroundResource(0);
        this.setBackgroundResource(R.drawable.circle_bg);
    }

    public float getTextWidth(String text, float textSize)
    {
        if(TextUtils.isEmpty(text))
        {
            return 0;
        }
        // 非等宽字体会出错
//        // 通过画笔类来测量文字的宽度
//        Paint paint = new Paint();
//        paint.setTextSize(textSize);
//        return paint.measureText(text);
        return text.length() * textSize + this.getPaddingLeft() + this.getPaddingRight();
    }

    public float getTextHeight(String text, float textSize)
    {
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        Paint.FontMetrics fm = paint.getFontMetrics();
        return fm.bottom - fm.top;
    }

    public void setWidthEqualHeight(boolean val)
    {
        this.widthEqualHeight = val;
        this.update();
    }

    public boolean getWidthEqualHeight()
    {
        return this.widthEqualHeight;
    }

    public void update() {
        String text = this.getText().toString();
        float textSize = this.getTextSize();
        int width = (int)getTextWidth(text, textSize);
        int height = (int)getTextHeight(text, textSize);
        int widthSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        int heightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        this.measure(widthSpec, heightSpec);
    }
}
