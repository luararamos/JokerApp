package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.graphics.Color
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Category

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
    ) : ListCategoryCallback{
    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val diff = (end - start) / response.size

        val categories = response.mapIndexed() { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                1000.0f
            )
            val name = s
            Category(s, Color.HSVToColor(hsv).toLong())
        }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}