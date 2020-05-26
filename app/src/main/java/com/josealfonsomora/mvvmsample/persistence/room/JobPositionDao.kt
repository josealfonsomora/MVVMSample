package com.josealfonsomora.mvvmsample.persistence.room

import androidx.room.*
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition

@Dao
interface JobPositionDao {
    @Query("SELECT * FROM saved_job_positions ORDER BY ID")
    fun loadJobPositions(): List<JobPosition>

    @Insert

    fun insertJobPosition(jobPosition: JobPosition)

    @Update
    fun updateJobPosition(jobPosition: JobPosition)

    @Delete
    fun deleteJobPosition(jobPosition: JobPosition)
}
