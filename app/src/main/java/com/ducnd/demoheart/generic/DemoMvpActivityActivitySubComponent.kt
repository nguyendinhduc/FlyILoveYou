package com.ducnd.demoheart.generic

import android.app.Activity
import dagger.Binds
import dagger.Subcomponent
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by ducnd on 8/21/17.
 */
@Subcomponent(modules = arrayOf(DemoMvpActivityActivityModule::class))
interface DemoMvpActivityActivitySubComponent : AndroidInjector<DemoMvpActivityActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DemoMvpActivityActivity>()

    //TODO REMINDER: move the line below to AppModule's @Module(...) annotation
    //DemoMvpActivityActivitySubComponent::class

    //TODO REMINDER: move this to ActivitiesInjectorFactories module
    @Binds
    @IntoMap
    @ActivityKey(DemoMvpActivityActivity::class)
     abstract fun bindDemoMvpActivityActivityInjectorFactory(
            builder: DemoMvpActivityActivitySubComponent.Builder): AndroidInjector.Factory<out Activity>
}