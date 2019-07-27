package com.ricoapps.fitfriend

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ricoapps.fitfriend.Database.ExerciseInfo
import kotlinx.android.synthetic.main.exercise_list_item.view.*

class ExerciseListAdapter(private val exerciseInfo: ArrayList<ExerciseInfo>, val context: Context) :
    RecyclerView.Adapter<ExerciseListAdapter.MyViewHolder>() {
    val intent = Intent(context, TrackExerciseActivity::class.java)
    override fun getItemCount(): Int {
        return exerciseInfo.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.exercise_list_item, parent, false))
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.muscleName?.text = exerciseInfo[position].bodyPart
        holder.exerciseName?.text = exerciseInfo[position].exerciseName

        holder.exerciseName.setOnClickListener { view ->
            intent.putExtra("exercise", holder.exerciseName.text.toString())
            Log.d("Hello", "You clicked ${holder.exerciseName.text}")
            context.startActivity(intent)
        }
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val exerciseName = view.exerciseNameText
        val muscleName = view.muscleNameText

    }

}


