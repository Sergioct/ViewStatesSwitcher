package com.sergiocrespotoubes.viewstatesswitcherlib

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

/**
 * Created by Sergio Crespo Toubes on 25/11/2018.
 * SergioCrespoToubes@gmail.com
 * www.SergioCrespoToubes.com
 */
class ViewStatesSwitcher2(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    internal var status = Status.IDLE

    internal var ERROR_REF = -1
    internal var successRef: Int = 0
    internal var loadingRef: Int = 0
    internal var errorRef: Int = 0
    internal var emptyRef: Int = 0

    internal var successView: View? = null
    internal var loadingView: View? = null
    internal var errorView: View? = null
    internal var emptyView: View? = null

    enum class Status {
        IDLE,
        SUCCESS,
        LOADING,
        ERROR,
        EMPTY
    }

    init {

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.view_states_switcher_attributes, 0, 0
        )

        val stateInt = typedArray.getInt(R.styleable.view_states_switcher_attributes_state, 0)
        successRef = typedArray.getResourceId(
            R.styleable.view_states_switcher_attributes_successView,
            ERROR_REF
        )
        loadingRef = typedArray.getResourceId(
            R.styleable.view_states_switcher_attributes_loadingView,
            ERROR_REF
        )
        errorRef = typedArray.getResourceId(
            R.styleable.view_states_switcher_attributes_errorView,
            ERROR_REF
        )
        emptyRef = typedArray.getResourceId(
            R.styleable.view_states_switcher_attributes_emptyView,
            ERROR_REF
        )

        when (stateInt) {
            0 -> status = Status.IDLE
            1 -> status = Status.SUCCESS
            2 -> status = Status.LOADING
            3 -> status = Status.ERROR
            4 -> status = Status.EMPTY
        }

        this.orientation = LinearLayout.VERTICAL
        typedArray.recycle()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        if (successRef != ERROR_REF) {
            successView = (parent as View).findViewById(successRef)
        }

        if (loadingRef != ERROR_REF) {
            loadingView = (parent as View).findViewById(loadingRef)
        }

        if (errorRef != ERROR_REF) {
            errorView = (parent as View).findViewById(errorRef)
        }

        if (emptyRef != ERROR_REF) {
            emptyView = (parent as View).findViewById(emptyRef)
        }
        setStatus(status)
    }

    fun setStatus(auxStatus: Status) {
        status = auxStatus

        when (status) {
            ViewStatesSwitcher2.Status.IDLE -> {
                if (successView != null) successView!!.visibility = View.VISIBLE
                if (loadingView != null) loadingView!!.visibility = View.VISIBLE
                if (errorView != null) errorView!!.visibility = View.VISIBLE
                if (emptyView != null) emptyView!!.visibility = View.VISIBLE
            }
            ViewStatesSwitcher2.Status.SUCCESS -> {
                if (successView != null) successView!!.visibility = View.VISIBLE
                if (loadingView != null) loadingView!!.visibility = View.GONE
                if (errorView != null) errorView!!.visibility = View.GONE
                if (emptyView != null) emptyView!!.visibility = View.GONE
            }
            ViewStatesSwitcher2.Status.LOADING -> {
                if (successView != null) successView!!.visibility = View.GONE
                if (loadingView != null) loadingView!!.visibility = View.VISIBLE
                if (errorView != null) errorView!!.visibility = View.GONE
                if (emptyView != null) emptyView!!.visibility = View.GONE
            }
            ViewStatesSwitcher2.Status.ERROR -> {
                if (successView != null) successView!!.visibility = View.GONE
                if (loadingView != null) loadingView!!.visibility = View.GONE
                if (errorView != null) errorView!!.visibility = View.VISIBLE
                if (emptyView != null) emptyView!!.visibility = View.GONE
            }
            ViewStatesSwitcher2.Status.EMPTY -> {
                if (successView != null) successView!!.visibility = View.GONE
                if (loadingView != null) loadingView!!.visibility = View.GONE
                if (errorView != null) errorView!!.visibility = View.GONE
                if (emptyView != null) emptyView!!.visibility = View.VISIBLE
            }
        }
    }

}