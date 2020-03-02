package com.sergiocrespotoubes.viewstatesswitcher

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.rxbinding3.view.clicks
import com.sergiocrespotoubes.viewstatesswitcherlib.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadViews()
    }

    @SuppressLint("CheckResult")
    private fun loadViews() {

        dataRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter  = groupAdapter
        }

        presenter.loadData()
        successButton.clicks().subscribe { presenter.loadData() }
        errorButton.clicks().subscribe { presenter.loadError() }
        emptyButton.clicks().subscribe { presenter.loadEmpty() }
    }

    override fun showError() {
        viewStatesSwitcher.error()
    }

    override fun showLoading() {
        viewStatesSwitcher.loading()
    }

    override fun showEmpty() {
        viewStatesSwitcher.empty()
    }

    override fun showData(users: List<User>) {
        groupAdapter.clear()
        val userItems = users.map{ user ->
            UserItem(user)
        }
        groupAdapter.addAll(userItems)
        viewStatesSwitcher.success()
    }

}