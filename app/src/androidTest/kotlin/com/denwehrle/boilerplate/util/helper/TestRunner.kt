package com.denwehrle.boilerplate.util.helper

import android.app.Application
import android.content.Context
import android.os.Bundle
import com.denwehrle.boilerplate.TestApp
import com.github.tmurakami.dexopener.DexOpenerAndroidJUnitRunner
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers

/**
 * @author Dennis Wehrle
 */
class TestRunner : DexOpenerAndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle) {
        super.onCreate(arguments)
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestApp::class.java.name, context)
    }
}