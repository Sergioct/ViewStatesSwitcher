package com.sergiocrespotoubes.viewstatesswitcher

import com.google.gson.annotations.SerializedName

/**
 * Created by Sergio Crespo Toubes on 27/09/2019.
 *     SergioCrespoToubes@gmail.com
 *     www.SergioCrespoToubes.com
 */
class User(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val picture: String
)
