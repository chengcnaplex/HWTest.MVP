package com.aplex.aplextest.lineview.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;

import com.aplex.aplextest.lineview.computator.PreviewChartComputator;
import com.aplex.aplextest.lineview.gesture.PreviewChartTouchHandler;
import com.aplex.aplextest.lineview.model.LineChartData;
import com.aplex.aplextest.lineview.renderer.PreviewLineChartRenderer;

/**
 * Preview chart that can be used as overview for other LineChart. When you change Viewport of this chart, visible area
 * of other chart will change. For that you need also to use
 * {@link Chart#setViewportChangeListener(lecho.lib.hellocharts.listener.ViewportChangeListener)}
 *
 * @author Leszek Wach
 */
public class PreviewLineChartView extends LineChartView {

    protected PreviewLineChartRenderer previewChartRenderer;

    public PreviewLineChartView(Context context) {
        this(context, null, 0);
    }

    public PreviewLineChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PreviewLineChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        chartComputator = new PreviewChartComputator();
        previewChartRenderer = new PreviewLineChartRenderer(context, this, this);
        touchHandler = new PreviewChartTouchHandler(context, this);
        setChartRenderer(previewChartRenderer);
        setLineChartData(LineChartData.generateDummyData());
    }

    public int getPreviewColor() {
        return previewChartRenderer.getPreviewColor();
    }

    public void setPreviewColor(int color) {


        previewChartRenderer.setPreviewColor(color);
        ViewCompat.postInvalidateOnAnimation(this);
    }

}
