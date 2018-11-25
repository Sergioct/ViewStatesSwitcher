package com.sergiocrespotoubes.viewstatesswitcherlib

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout

/**
 * Created by Sergio Crespo Toubes on 25/11/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
class ViewStatesSwitcher(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs){

    enum class Status{
        NORMAL,
        LOADING,
        ERROR,
        EMPTY
    }

    var normalRef : Int? = null
    var loadingRef : Int? = null
    var errorRef : Int? = null
    var emptyRef : Int? = null

    var mainView : View? = null
    var loadingView : View? = null
    var errorView : View? = null
    var emptyView : View? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs,
            R.styleable.view_states_switcher_attributes, 0, 0)

        normalRef = typedArray.getResourceId(R.styleable.view_states_switcher_attributes_normalView, -1);
        loadingRef = typedArray.getResourceId(R.styleable.view_states_switcher_attributes_loadingView, -1);
        errorRef = typedArray.getResourceId(R.styleable.view_states_switcher_attributes_errorView, -1);
        emptyRef = typedArray.getResourceId(R.styleable.view_states_switcher_attributes_emptyView, -1);

        typedArray.recycle()

        /*val title = resources.getText(typedArray
                 .getResourceId(R.styleable
                     .custom_component_attributes_custom_component_title,
                     R.string.component_one))

             my_title.text = title
             my_edit.hint =
                     "${resources.getString(R.string.hint_text)} $title"

             typedArray.recycle()

             context.theme.obtainStyledAttributes(
                 attrs,
                 R.styleable.ViewStatesSwitcher,
                 0, 0).apply {

                 try {
                     normalView = resources.(R.styleable.ViewStatesSwitcher_mainView, false)
                     mTextPos = resources.getR(R.styleable.ViewStatesSwitcher_mainView, 0)
                 } finally {
                     recycle()
                 }
             }*/
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        if(normalRef != null){
            mainView = (this.parent as View).findViewById(normalRef!!)
        }

        if(loadingRef != null){
            loadingView = (this.parent as View).findViewById(loadingRef!!)
        }

        if(errorRef != null){
            errorView = (this.parent as View).findViewById(errorRef!!)
        }

        if(emptyRef != null){
            emptyView = (this.parent as View).findViewById(emptyRef!!)
        }

        setStatus(Status.LOADING)
    }

    fun setStatus(status: Status){
        when(status){
            Status.NORMAL -> {
                mainView?.visibility = View.VISIBLE
                loadingView?.visibility = View.GONE
                errorView?.visibility = View.GONE
                emptyView?.visibility = View.GONE
            }
            Status.LOADING -> {
                mainView?.visibility = View.GONE
                loadingView?.visibility = View.VISIBLE
                errorView?.visibility = View.GONE
                emptyView?.visibility = View.GONE
            }
            Status.ERROR -> {
                mainView?.visibility = View.GONE
                loadingView?.visibility = View.GONE
                errorView?.visibility = View.VISIBLE
                emptyView?.visibility = View.GONE
            }
            Status.EMPTY -> {
                mainView?.visibility = View.GONE
                loadingView?.visibility = View.GONE
                errorView?.visibility = View.GONE
                emptyView?.visibility = View.VISIBLE
            }
        }
    }


}