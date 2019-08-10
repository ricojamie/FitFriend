package com.ricoapps.fitfriend

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ricoapps.fitfriend.WorkoutDatabase.WorkoutData
import com.ricoapps.fitfriend.WorkoutDatabase.WorkoutDataDatabase
import kotlinx.android.synthetic.main.track_exercise_list.view.*

class TrackExerciseAdapter (private val exerciseSetInfo: ArrayList<WorkoutData>, val context: Context) :
        RecyclerView.Adapter<TrackExerciseAdapter.MyViewHolder>() {


    var selectedItem = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.track_exercise_list, parent, false))
    }

    override fun getItemCount(): Int {
        return exerciseSetInfo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var setNumber = position +1
        holder.setNumber?.text = setNumber.toString()
        holder.repsAmount?.text = exerciseSetInfo[position].repCount.toString()
        holder.weightAmount?.text = exerciseSetInfo[position].weight.toString()
        holder.infoSetLayout.setOnLongClickListener{
            exerciseSetInfo[position].id
            val builder = AlertDialog.Builder(this.context)
            builder.setTitle("Delete Set")
            builder.setMessage("Do you want to delete this set?")
            builder.setPositiveButton("Yes") {
                dialog, which -> Log.d("Testing", "${exerciseSetInfo[position].id} Deleted")
                WorkoutDataDatabase.getInstance(context).workoutDataDao().deleteSet(exerciseSetInfo[position].id)
                exerciseSetInfo.remove(exerciseSetInfo[position])


            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
            return@setOnLongClickListener true
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val setNumber = view.setCountText
        val weightAmount = view.weightText
        val repsAmount = view.repText
        val infoSetLayout = view.setInfoLayout
    }
}





