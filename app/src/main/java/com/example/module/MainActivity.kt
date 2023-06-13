package com.example.module

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.all_projects_file.*

class MainActivity : AppCompatActivity() {

    private lateinit var projectCardAdapter: projectCardAdapter
    /*private lateinit var binding: ActivityMainBinding*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.all_projects_file)

        /*binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)*/

        initRecycleView()
        addAllProjectsDatasource()
    }

    private fun initRecycleView() {
        this.projectCardAdapter = projectCardAdapter()
        AllProjectsRecycleView.layoutManager = LinearLayoutManager(this@MainActivity)
        AllProjectsRecycleView.adapter = this.projectCardAdapter
    }

    private fun addAllProjectsDatasource() {
        val allProjectsSourceData = DataSource.generateAllProjectsDataset()
        this.projectCardAdapter.setDataset(allProjectsSourceData)
    }

}
