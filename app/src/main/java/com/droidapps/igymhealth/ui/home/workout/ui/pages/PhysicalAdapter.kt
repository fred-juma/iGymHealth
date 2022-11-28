package com.droidapps.igymhealth.ui.home.workout.ui.pages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidapps.igymhealth.databinding.GymItemListBinding
import com.droidapps.igymhealth.helpers.api.WGERJSON

class PhysicalAdapter(private var exerciseList: List<WGERJSON>) : RecyclerView.Adapter<PhysicalAdapter.RecycleView>() {
    inner class RecycleView(val binding: GymItemListBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<WGERJSON>() {
        override fun areContentsTheSame(oldItem: WGERJSON, newItem: WGERJSON): Boolean {
            return oldItem.results!!.get(workouts.size).id == newItem.results!![workouts.size].id
//            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: WGERJSON, newItem: WGERJSON): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    var workouts: List<WGERJSON>
//        var workouts: List<TODOS>
        get() = differ.currentList
        set(value) { differ.submitList(value)}

//    override fun getItemCount() = exerciseList.size

    override fun getItemCount() = workouts.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleView {
        return RecycleView(
            GymItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //BUG API wont fetch list items
    override fun onBindViewHolder(holder: RecycleView, position: Int) {
        holder.binding.apply{
            val exercises = workouts[position]
//            gymContent.text = exercises.title
//            gymTitle.text = exercises.userId.toString()
//            gymTitle.text = exercises.results[position].name
//            gymContent.text = exercises.results[position].description
            gymTitle.text = exerciseList.get(position).results!![position].name
            gymContent.text = exerciseList.get(position).results!![position].category.toString()
        }
    }
}