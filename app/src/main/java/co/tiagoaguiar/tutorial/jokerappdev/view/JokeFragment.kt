package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokeFragment : Fragment() {
    val presenter = JokePresenter(this)
    private lateinit var txtJoke: TextView
    private lateinit var imgJoke: ImageView
    private lateinit var progressBar: ProgressBar

    companion object {
        const val CATEGORY_KEY = "category"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString(CATEGORY_KEY)
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title =
            categoryName!!.replaceFirstChar { it.uppercase() }
        txtJoke = view.findViewById(R.id.txtJoke)
        imgJoke = view.findViewById(R.id.imgJoke)
        progressBar = view.findViewById(R.id.progressBar)
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            presenter.findRandom(categoryName)
        }

        presenter.findRandom(categoryName)


    }

    fun showJoke(joke: Joke) {
        txtJoke.text = joke.textJoke
        Picasso.get().load(joke.iconUrl).into(imgJoke)
    }

    fun showError(e: String) {
        Toast.makeText(requireContext(),e,Toast.LENGTH_SHORT).show()
    }

    fun progressbar(visibility: Boolean) {
        if (visibility) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }

}