package co.tiagoaguiar.tutorial.jokerappdev.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(private val category: Category) : Item<CategoryItem.CategoryViewHolder>() {
    class CategoryViewHolder(view: View): GroupieViewHolder(view){

    }

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }

}