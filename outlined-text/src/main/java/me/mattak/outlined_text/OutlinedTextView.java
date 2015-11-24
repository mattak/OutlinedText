package me.mattak.outlined_text;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
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
        this.mStrokeWidth = array.getDimension(R.styleable.OutlinedText_strokeWidth, 0.0f);
        this.mStrokeColor = array.getColor(R.styleable.OutlinedText_strokeColor, Color.TRANSPARENT);
        array.recycle();

        strokePaint.setColor(this.mStrokeColor);
        strokePaint.setTextAlign(Paint.Align.CENTER);
        strokePaint.setTextSize(this.getTextSize());
        strokePaint.setTypeface(Typeface.DEFAULT);
        strokePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        strokePaint.setStrokeWidth(this.mStrokeWidth);
        strokePaint.setAntiAlias(true);
    }

    public void setStrokeWidth(float strokeWidth) {
        this.mStrokeWidth = strokeWidth;
    }

    public void setStrokeColor(int strokeColor) {
        this.mStrokeWidth = strokeColor;
    }

    private Paint strokePaint = new Paint();

    @Override
    public void draw(Canvas canvas) {
        Paint.FontMetrics metrics = strokePaint.getFontMetrics();
        int px = getTextCenterX(strokePaint);
        int py = getTextCenterY(metrics);

        canvas.drawText(this.getText().toString(), px, py, strokePaint);
        super.draw(canvas);
    }

    private int getTextCenterX(Paint paint) {
        float textWidth = paint.measureText(this.getText().toString());
        if ((this.getGravity() & Gravity.LEFT) == Gravity.LEFT) {
            return (int) (textWidth / 2);
        } else if ((this.getGravity() & Gravity.RIGHT) == Gravity.RIGHT) {
            return this.getWidth() - (int) (textWidth / 2);
        } else {
            return this.getWidth() / 2;
        }
    }

    private int getTextCenterY(Paint.FontMetrics metrics) {
        if ((this.getGravity() & Gravity.TOP) == Gravity.TOP) {
            return (int) -metrics.top;
        } else if ((this.getGravity() & Gravity.BOTTOM) == Gravity.BOTTOM) {
            return (int) (this.getHeight() - metrics.bottom);
        } else {
            return (int) (this.getHeight() - metrics.top - metrics.bottom) / 2;
        }
    }
}