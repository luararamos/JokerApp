package co.tiagoaguiar.tutorial.jokerappdev.presentation

import co.tiagoaguiar.tutorial.jokerappdev.data.JokeCallback
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeDayRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.JokeRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeDayFragment
import co.tiagoaguiar.tutorial.jokerappdev.view.JokeFragment

class JokeDayPresenter(
    private val view: JokeDayFragment,
    private val dataSource: JokeDayRemoteDataSource = JokeDayRemoteDataSource()
) : JokeCallback {


    fun findJokeDay() {
        view.progressbar(true)
        dataSource.findJokeDay(this)
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