package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) : JokeCallback {


    fun findRandom(categoryName: String) {
        view.progressbar(true)
        dataSource.findRandom(this, categoryName)
    }

    override fun onSuccess(response: Joke) {
        view.progressbar(false)
        view.showJoke(response)
    }

    override fun onError(response: String) {
        view.progressbar(false)
        view.showError(response)
    }

    override fun onComplete() {
        view.progressbar(false)
    }
}