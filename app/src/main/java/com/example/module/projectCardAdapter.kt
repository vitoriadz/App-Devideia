package com.example.module

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module.models.projectCard

import kotlinx.android.synthetic.main.project_card_adapter.view.*

import kotlin.math.atan

class projectCardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var projectCards: List<projectCard> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProjectCardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.project_card_adapter, parent, false)
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is ProjectCardViewHolder -> {
                holder.bind( projectCards[position] )
            }
        }
    }


    override fun getItemCount(): Int {
        return projectCards.size
    }

    fun setDataset(projectsData: List<projectCard>){
        this.projectCards = projectsData
    }


    class ProjectCardViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        /*private val projectCard = itemView.ProjectCard*/
        /*private val projectImage = itemView.ProjectImage*/
        private val projectTitle = itemView.ProjectTitle
        private val projectDate = itemView.ProjectDate

        fun bind (projectCardObject : projectCard) {
            /*projectCard.*/
            /*projectImage.*/
            projectTitle.text = projectCardObject.title
            projectDate.text = projectCardObject.date
        }
    }

}