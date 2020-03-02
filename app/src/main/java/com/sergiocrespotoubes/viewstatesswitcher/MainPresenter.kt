package com.sergiocrespotoubes.viewstatesswitcher

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(private val view: MainContract.View) {

    fun loadData() = MainScope().launch {
        view.showLoading()
        delay(2000)

        val json = mockUsers()
        val listType = object : TypeToken<List<User>>() {}.type
        val users = Gson().fromJson<List<User>>(json, listType)

        handleSuccess(users)
    }

    fun loadError() = MainScope().launch {
        view.showLoading()
        delay(2000)
        handleError()
    }

    fun loadEmpty() = MainScope().launch {
        view.showLoading()
        delay(2000)
        handleSuccess(listOf())
    }

    private fun handleError() {
        GlobalScope.launch {
            withContext(Main) {
                view.showError()
            }
        }
    }

    private fun handleSuccess(users: List<User>) = MainScope().launch {
        if (users.isNotEmpty()) {
            view.showData(users)
        } else {
            view.showEmpty()
        }
    }
}

fun mockUsers() = """[{
  "first_name": "Lyndell",
  "last_name": "Tumbelty",
  "picture": "https://robohash.org/doloremquequisesse.bmp?size=50x50&set=set1"
}, {
  "first_name": "Gleda",
  "last_name": "Easeman",
  "picture": "https://robohash.org/cupiditatererumut.png?size=50x50&set=set1"
}, {
  "first_name": "Tiffany",
  "last_name": "Kretchmer",
  "picture": "https://robohash.org/eumevenietconsequatur.bmp?size=50x50&set=set1"
}, {
  "first_name": "Dolores",
  "last_name": "Bilton",
  "picture": "https://robohash.org/enimestsint.png?size=50x50&set=set1"
}, {
  "first_name": "Maddalena",
  "last_name": "Deamer",
  "picture": "https://robohash.org/molestiaemollitiaconsequatur.jpg?size=50x50&set=set1"
}, {
  "first_name": "Trixie",
  "last_name": "Ebi",
  "picture": "https://robohash.org/sintaliquidipsam.jpg?size=50x50&set=set1"
}, {
  "first_name": "Brew",
  "last_name": "Packer",
  "picture": "https://robohash.org/voluptatibusfacilisest.bmp?size=50x50&set=set1"
}, {
  "first_name": "Danita",
  "last_name": "Riquet",
  "picture": "https://robohash.org/autemquiaaliquam.png?size=50x50&set=set1"
}, {
  "first_name": "Ludvig",
  "last_name": "Portingale",
  "picture": "https://robohash.org/quidemquibusdamvoluptas.bmp?size=50x50&set=set1"
}, {
  "first_name": "Dale",
  "last_name": "Skilling",
  "picture": "https://robohash.org/minusimpeditrecusandae.bmp?size=50x50&set=set1"
}, {
  "first_name": "Harli",
  "last_name": "Sillito",
  "picture": "https://robohash.org/magnioditomnis.png?size=50x50&set=set1"
}, {
  "first_name": "Rufe",
  "last_name": "Ilyinski",
  "picture": "https://robohash.org/reprehenderitiureest.bmp?size=50x50&set=set1"
}, {
  "first_name": "Lefty",
  "last_name": "Pittson",
  "picture": "https://robohash.org/laborumcupiditatereiciendis.jpg?size=50x50&set=set1"
}, {
  "first_name": "Gibby",
  "last_name": "Blackshaw",
  "picture": "https://robohash.org/doloremculpavero.jpg?size=50x50&set=set1"
}, {
  "first_name": "Mada",
  "last_name": "Cholmondeley",
  "picture": "https://robohash.org/commodiinut.jpg?size=50x50&set=set1"
}, {
  "first_name": "Kent",
  "last_name": "Lyle",
  "picture": "https://robohash.org/eosvoluptatemtotam.bmp?size=50x50&set=set1"
}, {
  "first_name": "Piotr",
  "last_name": "Aitken",
  "picture": "https://robohash.org/eossintqui.jpg?size=50x50&set=set1"
}, {
  "first_name": "Ethel",
  "last_name": "Winch",
  "picture": "https://robohash.org/iurerecusandaeiusto.png?size=50x50&set=set1"
}, {
  "first_name": "Blondelle",
  "last_name": "Chislett",
  "picture": "https://robohash.org/velitvelitautem.png?size=50x50&set=set1"
}, {
  "first_name": "Chanda",
  "last_name": "Chiommienti",
  "picture": "https://robohash.org/illoconsequaturveritatis.jpg?size=50x50&set=set1"
}]"""
