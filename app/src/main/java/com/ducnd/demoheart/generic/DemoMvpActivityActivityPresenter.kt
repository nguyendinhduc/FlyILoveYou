package com.ducnd.demoheart.generic

import com.stfalcon.mvphelper.Presenter
import javax.inject.Inject

/**
 * Created by ducnd on 8/21/17.
 */
class DemoMvpActivityActivityPresenter @Inject constructor()
    : Presenter<DemoMvpActivityActivityContract.View>(), DemoMvpActivityActivityContract.Presenter {

    override fun onViewAttached(view: DemoMvpActivityActivityContract.View, created: Boolean) {
        super.onViewAttached(view, created)
    }

    override fun onViewDetached() {
        super.onViewDetached()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}