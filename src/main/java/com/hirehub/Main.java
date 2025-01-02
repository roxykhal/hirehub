package com.hirehub;
import com.hirehub.model.Job;
import com.hirehub.service.JobService;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hirehub!");

        JobService jobService = new JobService();

        //Create a new job
        Job newJob = new Job("Software Developer", "Develops application", "Java", new Date(), new Date(),  "Open");
        jobService.createJob(newJob);
        System.out.println("New job created with ID: " + newJob.getId());

        //get all jobs
        List<Job> allJobs = jobService.getAllJobs();
        System.out.println("All jobs");

        for (Job job: allJobs) {
            System.out.println(job);
    }

        //get a specific job and store it in Job type in variable called retrievedJob
        Job retrievedJob = jobService.getJobById(newJob.getId());
        System.out.println("Retrieved job: " + retrievedJob);

        //Delete the job
        jobService.deleteJob(newJob.getId());

}
}