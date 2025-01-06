package com.hirehub;
import com.hirehub.model.Candidates;
import com.hirehub.model.Job;
import com.hirehub.model.Users;
import com.hirehub.service.JobService;
import com.hirehub.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.hirehub.service.CandidateService;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static JobService jobService = new JobService();
    private static CandidateService candidateService = new CandidateService();
    private static UserService userService = new UserService();

    private static void displayMainMenu() {
        System.out.println("HireHub Main Menu");
        System.out.println("1. Manage Candidates");
        System.out.println("2. Manage Jobs");
        System.out.println("3. Manage Interviews");
        System.out.println("4. Manage Applications");
        System.out.println("5. Exit");

    }

    private static void displayCandidateMenu() {
        System.out.println("Candidate Management Menu");
        System.out.println("1. Register Candidate");
        System.out.println("2. View all Candidates");
        System.out.println("3. Update Candidates");
        System.out.println("4. Delete Candidates");
        System.out.println("5. Find Candidate by ID");
        System.out.println("1. Return to Main Menu");
    }

    private static void displayJobsMenu() {
        System.out.println("Job Management Menu");
        System.out.println("1. Create Job");
        System.out.println("2. View all Job");
        System.out.println("3. Update Job");
        System.out.println("4. Delete Job");
        System.out.println("5. Find Job by ID");
        System.out.println("6. Return to Main Menu");

    }

    private static void displayInterviewsMenu() {
        System.out.println("Interview Management Menu");
        System.out.println("1. Create Interview");
        System.out.println("2. View all Interviews");
        System.out.println("3. Update Interviews");
        System.out.println("4. Delete Interview");
        System.out.println("5. Find Interview");
        System.out.println("6. Return to Main Men");

    }

    private static void addJob() {
        System.out.println("Create new job");
        System.out.println("Enter job title: ");
        String title = scanner.nextLine();
        System.out.println("Requirements needed for Job");
        String requirements = scanner.nextLine();
        System.out.println("Job Description");
        String description = scanner.nextLine();

        Job job = new Job(title, description, requirements, new Date(), null, "Open");
        jobService.createJob(job);
        System.out.println("Job created successfully!" + job.getId());

    }

    private static void addCandidate() {
        System.out.println("Add new Candidate");
        System.out.println("Enter Candidate first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter Candidate last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter Candidate email address");
        String email = scanner.nextLine();
        System.out.println("Enter Candidate phone number");
        int phoneNumber = scanner.nextInt();
        System.out.println("Enter Candidate resume URL");
        String resumeUrl = scanner.nextLine();
        System.out.println("Enter Candidate ID");
        int id = scanner.nextInt();

        Candidates candidate = new Candidates(id, resumeUrl, firstName, lastName, email, phoneNumber, resumeUrl, null);
        candidateService.createCandidate(candidate);
        System.out.println("Candidate created successfully!" + candidate.getId());


    }

    private static void addUsers() {
        System.out.println("Add new User");
        System.out.println("Enter Username: ");
        String userName = scanner.nextLine();

        System.out.println("Enter user Role");
        String role = scanner.nextLine();

        System.out.println("Enter user email address");
        String email = scanner.nextLine();

        System.out.println("Enter User ID");
        int userId = scanner.nextInt();

        System.out.println("Enter Password");
        String password = scanner.nextLine();

        Users user = new Users(userId, userName, password, email, role);
        userService.createUsers(user);

        System.out.println("User created successfully!" + user.getuserId());
    

    }



        
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