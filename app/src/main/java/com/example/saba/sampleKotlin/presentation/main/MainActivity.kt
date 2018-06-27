package com.example.saba.sampleKotlin.presentation.main

import android.os.Bundle
import com.example.saba.sampleKotlin.R.id.frame_main
import com.example.saba.sampleKotlin.R.layout.activity_main
import com.example.saba.sampleKotlin.mvi.activity.BaseActivity
import com.example.saba.sampleKotlin.mvi.anotations.LayoutResourceId
import com.example.saba.sampleKotlin.presentation.add.AddingFragment
import com.example.saba.sampleKotlin.presentation.get.ResultFragment

@LayoutResourceId(activity_main)
class MainActivity : BaseActivity<MainViewState, MainPresenter>(), MainView {

    override fun reflectState(state: MainViewState) {
        when (state.state) {
            MAIN_VIEW_DRAW_ADDING_SCREEN_STATE -> onAddingScreenNavigationState()
            MAIN_VIEW_DRAW_RESULT_SCREEN_STATE -> onResultScreenNavigationState()
        }
    }

    override fun onPresenterReady(presenter: MainPresenter) {
        presenter.attach(this)
    }

    override fun renderView(savedInstanceState: Bundle?) {}

    private fun onResultScreenNavigationState() {
        supportFragmentManager
                .beginTransaction()
                .replace(frame_main, ResultFragment.newInstance())
                .commit()
    }

    private fun onAddingScreenNavigationState() {
        supportFragmentManager
                .beginTransaction()
                .replace(frame_main, AddingFragment.newInstance())
                .commit()
    }

}