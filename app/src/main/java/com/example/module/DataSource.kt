package com.example.module

import com.example.module.models.projectCard

class DataSource {

    companion object {
        fun generateAllProjectsDataset() : ArrayList<projectCard> {

            val projects = ArrayList<projectCard>()

            projects.add(
                projectCard(
                    cardRow = 0,
                    cardColumn = 0,
                    cardImageURL = "@drawable/projeto1",
                    title = "Meu projeto 1",
                    date = "Criado em 01/03/2023"
                )
            )

            projects.add(
                projectCard(
                    cardRow = 0,
                    cardColumn = 1,
                    cardImageURL = "@drawable/projeto2",
                    title = "Meu projeto 2",
                    date = "Criado em 02/03/2023"
                )
            )

            projects.add(
                projectCard(
                    cardRow = 0,
                    cardColumn = 2,
                    cardImageURL = "@drawable/projeto3",
                    title = "Meu projeto 3",
                    date = "Criado em 03/03/2023"
                )
            )

            projects.add(
                projectCard(
                    cardRow = 1,
                    cardColumn = 0,
                    cardImageURL = "@drawable/projeto1",
                    title = "Meu projeto 4",
                    date = "Criado em 04/03/2023"
                )
            )

            projects.add(
                projectCard(
                    cardRow = 1,
                    cardColumn = 1,
                    cardImageURL = "@drawable/projeto2",
                    title = "Meu projeto 5",
                    date = "Criado em 05/03/2023"
                )
            )

            return projects

        }
    }

}