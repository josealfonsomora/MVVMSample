package com.josealfonsomora.mvvmsample.network

import com.google.gson.annotations.SerializedName

class RemotiveResponse(
    @SerializedName("0-legal-notice")
    val legalText: String,
    @SerializedName("job-count")
    val jobCount: Int,
    val jobs: List<RemotiveJob>
) : JobServiceResponse

class RemotiveJob(
    val id: Long, // Unique Remotive ID
    val url: String, //"https://remotive.io/remote-jobs/product/lead-developer-123" Job listing detail url
    val title: String, // "Lead Developer", // Job title
    @SerializedName("company_name")
    val companyName: String, // "Remotive", // Name of the company which is hiring
    val category: String, // "Software Development", // See https://remotive.io/api/remote-jobs/categories for existing categories
    val tags: List<String>, //["python", "back end"], // list of tags. See https://remotive.io/api/remote-jobs/tags for existing tags
    @SerializedName("job_type")
    val jobType: String, //"full_time",  // "full_time" or "contract" here
    @SerializedName("publication_date")
    val publicationDate: String,// "2020-02-15T10:23:26", // Publication date and time on https://remotive.io
    @SerializedName("candidate_required_location")
    val candidateRequiredLocation: String,//"Worldwide", // Geographical restriction for the remote candidate, if any.
    val salary: String, //"$40,000 - $50,000", // salary description, usually a yearly salary range, in USD.
    val description: String // "The full HTML job description here", // HTML full description of the job listing
)

/**
{
"0-legal-notice": "Remotive API Legal Notice",
"job-count": 1, // Number or jobs matching the query == length of 'jobs' list
"jobs": [ // The list of all jobs retrieved. Then for each job, you get:
{
"id": 123, // Unique Remotive ID
"url": "https://remotive.io/remote-jobs/product/lead-developer-123", // Job listing detail url
"title": "Lead Developer", // Job title
"company_name": "Remotive", // Name of the company which is hiring
"category": "Software Development", // See https://remotive.io/api/remote-jobs/categories for existing categories
"tags": ["python", "back end"], // list of tags. See https://remotive.io/api/remote-jobs/tags for existing tags
"job_type": "full_time",  // "full_time" or "contract" here
"publication_date": "2020-02-15T10:23:26", // Publication date and time on https://remotive.io
"candidate_required_location": "Worldwide", // Geographical restriction for the remote candidate, if any.
"salary": "$40,000 - $50,000", // salary description, usually a yearly salary range, in USD.
"   description": "The full HTML job description here", // HTML full description of the job listing
},
]
}
 */
