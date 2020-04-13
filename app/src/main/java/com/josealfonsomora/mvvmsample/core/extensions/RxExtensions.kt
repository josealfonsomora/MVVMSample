package com.josealfonsomora.mvvmsample.core.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.disposeWith(disposables: CompositeDisposable): Disposable {
    disposables.add(this)
    return this
}
