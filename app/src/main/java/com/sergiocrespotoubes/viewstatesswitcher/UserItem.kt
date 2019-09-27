package com.sergiocrespotoubes.viewstatesswitcher

import coil.api.load
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_user.*

class UserItem(val user: User) : Item(){

    override fun getLayout() = R.layout.item_user

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.tv_first_name.text = user.firstName
        viewHolder.tv_last_name.text = user.lastName
        viewHolder.iv_picture.load(user.picture){
            error(R.drawable.ic_alert_circle_outline)
        }
    }

}