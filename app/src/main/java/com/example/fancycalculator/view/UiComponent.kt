package com.example.fancycalculator.view

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.view.View
import android.view.ViewManager
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.custom.ankoView
import androidx.fragment.app.Fragment as supportFragment

/**
MIT License

Copyright (c) 2017 Jimmy Robz

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
typealias SupportFragment = supportFragment

abstract class UiComponent : AnkoComponent<Context> {
    lateinit var context: AnkoContext<Context> private set
    lateinit var view: View private set

    override fun createView(ui: AnkoContext<Context>): View {
        context = ui
        view = createView()
        onViewCreated()
        return view
    }

    abstract fun createView(): View

    protected open fun onViewCreated() {}
}

fun UiComponent.layout(block: AnkoContext<Context>.() -> View) = with(context, block)

fun UiComponent.createView(context: Context) = createView(AnkoContext.create(context))
fun UiComponent.createView(fragment: Fragment) = createView(AnkoContext.create(fragment.activity))
fun UiComponent.createView(fragment: SupportFragment) = createView(AnkoContext.create(fragment.context!!))

fun Activity.setContentView(ui: UiComponent) = ui.createView(AnkoContext.create(this, true))

fun <T : UiComponent> ViewManager.include(block: () -> T) = include(block) {}
inline fun <T : UiComponent> ViewManager.include(block: () -> T, init: T.() -> Unit) = include(block(), init)

fun <T : UiComponent> ViewManager.include(component: T) = include(component) {}
inline fun <T : UiComponent> ViewManager.include(component: T, init: T.() -> Unit): T {
    ankoView({
        component.createView(it)
    }, 0, {
        init(component)
    })
    return component
}

fun createUi(block: AnkoContext<Context>.() -> View) = object : UiComponent() {
    override fun createView() = layout(block)
}
