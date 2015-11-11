package me.mattak.outlined_text;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * OutlinedTextView
 * Created by mattak on 2015/11/11.
 */
public class OutlinedTextView extends TextView {
    private float mStrokeWidth = 0.0f;
    private int mStrokeColor = Color.TRANSPARENT;

    public OutlinedTextView(Context context) {
        super(context);
    }

    public OutlinedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.parse(attrs);
    }

    public OutlinedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.parse(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OutlinedTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.parse(attrs);
    }

    private void parse(AttributeSet attrs) {
        TypedArray array = this.getContext().obtainStyledAttributes(attrs, R.styleable.OutlinedText);
        this.mStrokeWidth = array.getDimension(R.styleable.OutliendText_strokeWidth, 0.0f);
        this.mStrokeColor =  array.getColor(R.styleable.OutlinedText_strokeColor, Color.TRANSPARENT);
        array.recycle();
    }

    public void setStrokeWidth(float strokeWidth) {
        this.mStrokeWidth = strokeWidth;
    }

    public void setStrokeColor(int strokeColor) {
        this.mStrokeWidth = strokeColor;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
