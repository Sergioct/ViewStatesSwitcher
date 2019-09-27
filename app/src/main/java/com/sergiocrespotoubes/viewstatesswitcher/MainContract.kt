package com.sergiocrespotoubes.viewstatesswitcher

/**
 * Created by Sergio Crespo Toubes on 08/04/2018.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
interface MainContract {

    interface View{
        fun showError()
        fun showLoading()
        fun showEmpty()
        fun showData(user: List<User>)
    }

}