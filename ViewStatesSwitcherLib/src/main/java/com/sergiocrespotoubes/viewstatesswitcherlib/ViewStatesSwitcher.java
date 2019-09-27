package com.sergiocrespotoubes.viewstatesswitcherlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Sergio Crespo Toubes on 25/11/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
public class ViewStatesSwitcher extends LinearLayout {

    public enum Status{
        IDLE,
        NORMAL,
        LOADING,
        ERROR,
        EMPTY
    }

    Status status = Status.IDLE;

    int ERROR_REF = -1;
    int normalRef;
    int loadingRef;
    int errorRef;
    int emptyRef;

    View normalView;
    View loadingView;
    View errorView;
    View emptyView;

    public ViewStatesSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.view_states_switcher_attributes, 0, 0);

        int stateInt = typedArray.getInt(R.styleable.view_states_switcher_attributes_state, 0);
        normalRef = typedArray.getResourceId(R.styleable.view_states_switcher_attributes_normalView, ERROR_REF);
        loadingRef = typedArray.getResourceId(R.styleable.view_states_switcher_attributes_loadingView, ERROR_REF);
        errorRef = typedArray.getResourceId(R.styleable.view_states_switcher_attributes_errorView, ERROR_REF);
        emptyRef = typedArray.getResourceId(R.styleable.view_states_switcher_attributes_emptyView, ERROR_REF);

        switch (stateInt){
            case 0:
                status = Status.IDLE;
                break;
            case 1:
                status = Status.NORMAL;
                break;
            case 2:
                status = Status.LOADING;
                break;
            case 3:
                status = Status.ERROR;
                break;
            case 4:
                status = Status.EMPTY;
                break;
        }

        this.setOrientation(LinearLayout.VERTICAL);
        typedArray.recycle();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if(normalRef != ERROR_REF){
            normalView = ((View)getParent()).findViewById(normalRef);
        }

        if(loadingRef != ERROR_REF){
            loadingView = ((View)getParent()).findViewById(loadingRef);
        }

        if(errorRef != ERROR_REF){
            errorView = ((View)getParent()).findViewById(errorRef);
        }

        if(emptyRef != ERROR_REF){
            emptyView = ((View)getParent()).findViewById(emptyRef);
        }
        setStatus(status);
    }

    public void setStatus(Status auxStatus){
        status = auxStatus;

        switch(status){
            case IDLE: {
                if(normalView != null) normalView.setVisibility(View.VISIBLE);
                if(loadingView != null)loadingView.setVisibility(View.VISIBLE);
                if(errorView != null)errorView.setVisibility(View.VISIBLE);
                if(emptyView != null)emptyView.setVisibility(View.VISIBLE);
                break;
            }
            case NORMAL: {
                if(normalView != null) normalView.setVisibility(View.VISIBLE);
                if(loadingView != null)loadingView.setVisibility(View.GONE);
                if(errorView != null)errorView.setVisibility(View.GONE);
                if(emptyView != null)emptyView.setVisibility(View.GONE);
                break;
            }
            case LOADING: {
                if(normalView != null) normalView.setVisibility(View.GONE);
                if(loadingView != null)loadingView.setVisibility(View.VISIBLE);
                if(errorView != null)errorView.setVisibility(View.GONE);
                if(emptyView != null)emptyView.setVisibility(View.GONE);
                break;
            }
            case ERROR: {
                if(normalView != null) normalView.setVisibility(View.GONE);
                if(loadingView != null)loadingView.setVisibility(View.GONE);
                if(errorView != null)errorView.setVisibility(View.VISIBLE);
                if(emptyView != null)emptyView.setVisibility(View.GONE);
                break;
            }
            case EMPTY: {
                if(normalView != null) normalView.setVisibility(View.GONE);
                if(loadingView != null)loadingView.setVisibility(View.GONE);
                if(errorView != null)errorView.setVisibility(View.GONE);
                if(emptyView != null)emptyView.setVisibility(View.VISIBLE);
                break;
            }
        }
    }

}