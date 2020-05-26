package com.josealfonsomora.mvvmsample.repositories

import android.util.Log
import com.josealfonsomora.mvvmsample.featureJobs.models.JobPosition
import com.josealfonsomora.mvvmsample.featureJobs.models.RemoteOkJobPosition
import com.josealfonsomora.mvvmsample.network.SourceType
import com.josealfonsomora.mvvmsample.services.GithubService
import com.josealfonsomora.mvvmsample.services.RemoteOkService
import com.josealfonsomora.mvvmsample.services.RemotiveService
import com.josealfonsomora.mvvmsample.services.StackOverflowService
import io.reactivex.Single
import io.reactivex.rxkotlin.Singles
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

class JobsRepository(
    remoteOkService: RemoteOkService,
    stackOverflowService: StackOverflowService,
    githubService: GithubService,
    remotiveService: RemotiveService
) {
    private val TAG = "JobsRepository"

    private val remoteOkJobs: Single<List<JobPosition>> = remoteOkService
        .getJobs()
        .map { list ->
            Log.d("JobsRepository", "remoteOkService")

            list.filterIsInstance<RemoteOkJobPosition>()
        }
        .map { list ->
            list.map {
                JobPosition(
                    id = it.id,
                    epoch = it.epoch,
                    date = it.date,
                    companyLogo = it.companyLogo,
                    position = it.position,
                    company = it.company,
                    tags = it.tags,
                    description = it.description,
                    url = it.url,
                    source = SourceType.REMOTEOK
                )
            }
        }.cache()

    private val stackOverFlowJobs: Single<List<JobPosition>> = stackOverflowService
        .getJobs()
        .map {
            Log.d("JobsRepository", "stackOverflowService")

            it.items
        }
        .map { list ->
            list.map {
                JobPosition(
                    date = it.pubDate, // Wed, 29 Apr 2020 04:51:15 Z
                    position = it.title,
                    company = it.author.name,
                    tags = it.categories,
                    description = it.description,
                    url = it.link,
                    epoch = it.pubDate.formatFromDate("EEE, dd MMM yyyy HH:mm:ss 'Z'"),
                    source = SourceType.STACKOVERFLOW
                )
            }
        }.cache()

    private val gitHubJobs: Single<List<JobPosition>> = githubService
        .getJobs()
        .map { list ->
            Log.d("JobsRepository", "githubService")
            list.map {
                JobPosition(
                    date = it.createdAt, // Wed, 29 Apr 2020 04:51:15 Z
                    position = it.title,
                    company = it.company,
                    companyLogo = it.companyLogo,
                    description = it.description,
                    url = it.url,
                    epoch = it.createdAt.formatFromDate("EEE MMM dd HH:mm:ss 'UTC' yyyy"),
                    source = SourceType.GITHUB
                )
            }
        }.cache()

    private val remotiveJobs: Single<List<JobPosition>> = remotiveService
        .getJobs()
        .map { it.jobs }
        .map { list ->
            list.map {
                Log.d("JobsRepository", "remotiveService")
                JobPosition(
                    id = it.id.toInt(),
                    epoch = it.publicationDate.formatFromDate("yyyy-MM-dd'T'H:mm:ss"),
                    date = it.publicationDate,
                    position = it.title,
                    company = it.companyName,
                    tags = it.tags,
                    description = it.description,
                    url = it.url,
                    source = SourceType.REMOTIVE
                )
            }
        }.cache()

    fun getJobs() = Singles.zip(
        remoteOkJobs,
        stackOverFlowJobs,
        gitHubJobs,
        remotiveJobs
    )
    { remoteOk: List<JobPosition>,
      stackOverflow: List<JobPosition>,
      gitHub: List<JobPosition>,
      remotive: List<JobPosition> ->
        listOf(remoteOk, stackOverflow, gitHub, remotive).flatten()
    }
}

fun String.formatFromDate(dateFormat: String = "EEE MMM dd HH:mm:ss 'UTC' yyyy"): Long {
    return try {
        val formatter = DateTimeFormatter.ofPattern(dateFormat, Locale.getDefault())
        LocalDate.parse(this, formatter).atStartOfDay().toEpochSecond(ZoneOffset.UTC)
    } catch (e: Exception) {
        Log.e("JobsRepository", "FIRST TRY formatFromDate: $e and dateformat: $dateFormat")
        Log.e("JobsRepository", "date $this and dateformat: $dateFormat")
        try {
            val formatter =
                DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'Z'", Locale.getDefault())
            LocalDate.parse(this, formatter).atStartOfDay().toEpochSecond(ZoneOffset.UTC)
        } catch (e: Exception) {
            Log.e("JobsRepository", "SECOND TRY formatFromDate: $e")
            LocalDate.now().atStartOfDay().toEpochSecond(ZoneOffset.UTC)
        }
    }
}
