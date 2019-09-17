package com.sun.newlanguage.design;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

public class TranslucentBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    /**标题栏的高度*/
    private float deltaY;

    public TranslucentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    /**
     * 必须要加上  layout_anchor，对方也要layout_collapseMode才能使用
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Toolbar child, View dependency) {

        if (deltaY == 0) {
            deltaY = dependency.getY() - child.getHeight();
        }

        float dy = dependency.getY() - child.getHeight();
        dy = dy < 0 ? 0 : dy;
        float alpha = 1 - (dy / deltaY);
        child.setAlpha(alpha);

        return true;
    }
}