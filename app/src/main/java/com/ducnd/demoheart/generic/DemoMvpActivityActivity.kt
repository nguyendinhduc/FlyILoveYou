package com.ducnd.demoheart.generic

import com.ducnd.demoheart.R
import com.stfalcon.mvphelper.MvpActivity

/**
 * Created by ducnd on 8/21/17.
 */
class DemoMvpActivityActivity : MvpActivity<DemoMvpActivityActivityContract.Presenter, DemoMvpActivityActivityContract.View>(),
        DemoMvpActivityActivityContract.View {

    override fun getLayoutResId(): Int = R.layout.activity_demo_mvp_activity

}