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

    private var status = Status.IDLE

    private var ERROR_REF = -1
    private var successRef: Int = 0
    private var loadingRef: Int = 0
    private var errorRef: Int = 0
    private var emptyRef: Int = 0

    private var successView: View? = null
    private var loadingView: View? = null
    private var errorView: View? = null
    private var emptyView: View? = null

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

        status = when (stateInt) {
            0 -> Status.IDLE
            1 -> Status.SUCCESS
            2 -> Status.LOADING
            3 -> Status.ERROR
            4 -> Status.EMPTY
            else -> Status.IDLE
        }

        this.orientation = VERTICAL
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
            Status.IDLE -> {
                successView?.visibility = View.VISIBLE
                loadingView?.visibility = View.VISIBLE
                errorView?.visibility = View.VISIBLE
                emptyView?.visibility = View.VISIBLE
            }
            Status.SUCCESS -> {
                successView?.visibility = View.VISIBLE
                loadingView?.visibility = View.GONE
                errorView?.visibility = View.GONE
                emptyView?.visibility = View.GONE
            }
            Status.LOADING -> {
                successView?.visibility = View.GONE
                loadingView?.visibility = View.VISIBLE
                errorView?.visibility = View.GONE
                emptyView?.visibility = View.GONE
            }
            Status.ERROR -> {
                successView?.visibility = View.GONE
                loadingView?.visibility = View.GONE
                errorView?.visibility = View.VISIBLE
                emptyView?.visibility = View.GONE
            }
            Status.EMPTY -> {
                successView?.visibility = View.GONE
                loadingView?.visibility = View.GONE
                errorView?.visibility = View.GONE
                emptyView?.visibility = View.VISIBLE
            }
        }
    }

}

fun ViewStatesSwitcher2.success() {
    this.setStatus(ViewStatesSwitcher2.Status.SUCCESS)
}

fun ViewStatesSwitcher2.error() {
    this.setStatus(ViewStatesSwitcher2.Status.ERROR)
}

fun ViewStatesSwitcher2.empty() {
    this.setStatus(ViewStatesSwitcher2.Status.EMPTY)
}

fun ViewStatesSwitcher2.idle() {
    this.setStatus(ViewStatesSwitcher2.Status.IDLE)
}

fun ViewStatesSwitcher2.loading() {
    this.setStatus(ViewStatesSwitcher2.Status.LOADING)
}