package com.ducnd.demoheart.generic

import android.content.Context
import com.stfalcon.mvphelper.PresenterLoader
import dagger.Module
import dagger.Provides

/**
 * Created by ducnd on 8/21/17.
 */
@Module
class DemoMvpActivityActivityModule {

    @Provides
    fun providePresenterLoader(context: Context, presenter: DemoMvpActivityActivityPresenter)
            : PresenterLoader<DemoMvpActivityActivityContract.Presenter> = PresenterLoader(context, presenter)
}