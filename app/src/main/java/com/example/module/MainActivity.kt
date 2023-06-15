package com.example.module

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module.databinding.ActivityMainBinding
import com.example.module.databinding.AllProjectsFileBinding

//import kotlinx.android.synthetic.main.all_projects_file.*

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    private lateinit var projectCardAdapter: projectCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = AllProjectsFileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycleView()
        addAllProjectsDatasource()
    }

    private fun initRecycleView() {
        this.projectCardAdapter = projectCardAdapter()

        binding.AllProjectsRecycleView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.AllProjectsRecycleView.adapter = this.projectCardAdapter
    }

    private fun addAllProjectsDatasource() {
        val allProjectsSourceData = DataSource.generateAllProjectsDataset()
        this.projectCardAdapter.setDataset(allProjectsSourceData)
    }

}
