package com.hirehub;
import com.hirehub.model.Candidates;
import com.hirehub.model.Interviews;
import com.hirehub.model.Job;
import com.hirehub.model.Users;
import com.hirehub.service.JobService;
import com.hirehub.service.OffersService;
import com.hirehub.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.hirehub.service.CandidateService;
import com.hirehub.service.InterviewsService;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final JobService jobService = new JobService();
    private static final CandidateService candidateService = new CandidateService();
    private static final UserService userService = new UserService();
    private static final InterviewsService interviewsService = new InterviewsService();
    private static final OffersService offersService = new OffersService();

    public static void main(String[] args) {
        System.out.println("Welcome to Hirehub!");
        boolean running = true;

        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1 -> handleJobOperations();
                case 2 -> handleCandidateOperations();
                case 3 -> handleApplicationOperations();
                case 4 -> handleInterviewOperations();
                case 5 -> handleOfferOperations();
                case 6 -> handleUserOperations();
                case 7 -> {
                    System.out.println("Thank you for using Hirehub!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();
    }

    private static void displayMainMenu() {
        System.out.println("HireHub Main Menu");
        System.out.println("1. Candidate Management");
        System.out.println("2. Job Management");
        System.out.println("3. Interview Management");
        System.out.println("4. Application Management");
        System.out.println("5. User Management");
        System.out.println("6. Offer Management");
        System.out.println("7. Exit");
    }

    // Job operations
    private static void handleJobOperations() {
        while (true) {
            System.out.println("\n === Job Management ===");
            System.out.println("1. Create New Job");
            System.out.println("2. View all Jobs");
            System.out.println("3. View by ID");
            System.out.println("4. Update Job");
            System.out.println("5. Delete Job");
            System.out.println("6. Back to Main menu");

            int choice = getIntInput("Enter your choice: ");
            try {
                switch (choice) {
                    case 1 -> createJob();
                    case 2 -> viewAllJobs();
                    case 3 -> viewById();
                    case 4 -> updateJob();
                    case 5 -> deleteJob();
                    case 6 -> return; // Exit job management
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace(); // Or some other logging method
            }
        }
    }

    // Candidate operations
    private static void handleCandidateOperations() {
        while (true) {
            System.out.println("\n === Candidate Management ===");
            System.out.println("1. Register Candidate");
            System.out.println("2. View all Candidates");
            System.out.println("3. Update Candidates");
            System.out.println("4. Delete Candidates");
            System.out.println("5. Find Candidate by ID");
            System.out.println("6. Return to Main Menu");

            int choice = getIntInput("Enter your choice: ");
            try {
                switch (choice) {
                    case 1 -> createCandidate();
                    case 2 -> viewAllCandidates();
                    case 3 -> updateCandidate();
                    case 4 -> deleteCandidate();
                    case 5 -> findById();
                    case 6 -> return; // Exit candidate management
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace(); // Or some other logging method
            }
        }
    }

    // User operations
    private static void handleUserOperations() {
        while (true) {
            System.out.println("\n === User Management ===");
            System.out.println("1. Create User");
            System.out.println("2. View all Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Find User by ID");
            System.out.println("6. Return to Main Menu");

            int choice = getIntInput("Enter your choice: ");
            try {
                switch (choice) {
                    case 1 -> createUser();
                    case 2 -> viewAllUsers();
                    case 3 -> updateUser();
                    case 4 -> deleteUser();
                    case 5 -> findUserById();
                    case 6 -> return; // Exit user management
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace(); // Or some other logging method
            }
        }
    }

    // Interview operations
    private static void handleInterviewOperations() {
        while (true) {
            System.out.println("\n === Interview Management ===");
            System.out.println("1. Create Interview");
            System.out.println("2. View all Interviews");
            System.out.println("3. Update Interviews");
            System.out.println("4. Delete Interview");
            System.out.println("5. Find Interview");
            System.out.println("6. Return to Main Menu");

            int choice = getIntInput("Enter your choice: ");
            try {
                switch (choice) {
                    case 1 -> createInterview();
                    case 2 -> viewAllInterviews();
                    case 3 -> updateInterview();
                    case 4 -> deleteInterview();
                    case 5 -> findInterview();
                    case 6 -> return; // Exit interview management
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace(); // Or some other logging method
            }
        }
    }

    // Application operations
    private static void handleApplicationOperations() {
        while (true) {
            System.out.println("\n === Application Management ===");
            System.out.println("1. Create Application");
            System.out.println("2. View all Applications");
            System.out.println("3. Update Application");
            System.out.println("4. Delete Application");
            System.out.println("5. Find Application");
            System.out.println("6. Return to Main Menu");

            int choice = getIntInput("Enter your choice: ");
            try {
                switch (choice) {
                    case 1 -> createApplication();
                    case 2 -> viewAllApplications();
                    case 3 -> updateApplication();
                    case 4 -> deleteApplication();
                    case 5 -> findApplication();
                    case 6 -> return; // Exit application management
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace(); // Or some other logging method
            }
        }
    }

    // Offer operations
    private static void handleOfferOperations() {
        while (true) {   
        System.out.println("\n === Offer Management ===");
        System.out.println("1. Create Offer");
        System.out.println("2. View all Offers");
        System.out.println("3. Update Offer");
        System.out.println("4. Delete Offer");
        System.out.println("5. Find Offer");
        System.out.println("6. Return to Main Menu");

        int choice = getIntInput("Enter your choice: ");
        try {
            switch (choice) {
                case 1 -> createOffer();
                case 2 -> viewAllOffers();
                case 3 -> updateOffer();
                case 4 -> deleteOffer();
                case 5 -> findOffer();
                case 6 -> return; // Exit application management
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Or some other logging method
        }
    }
}

    //Job logic 

    private static void createJob() {
    
    }

    private static void viewAllJobs() {

    }

    private static void viewById() {

    }

    private static void updateJob() {

    }

    private static void deleteJob() {

    }

     //Candidate logic

     private static void createCandidate() {
    
     }
 
     private static void viewAllCandidates() {
 
     }
 
     private static void updateCandidate() {
 
     }
 
     private static void deleteCandidate() {
 
     }
 
     private static void findById() {
     }


     //User logic

     private static void createUser() {
    
     }
 
     private static void viewAllUsers() {
 
     }
 
     private static void updateUser() {
 
     }
 
     private static void deleteUser() {
 
     }
 
     private static void findUserById() {
     }

     //Interview logic 

     private static void createInterview() {
    
     }
 
     private static void viewAllInterviews() {
 
     }
 
     private static void updateInterview() {
 
     }
 
     private static void deleteInterview() {
 
     }
 
     private static void findInterview() {
     }

     //Application logic 

     private static void createApplication() {
    
     }
 
     private static void viewAllApplications() {
 
     }
 
     private static void updateApplication() {
 
     }
 
     private static void deleteApplication() {
 
     }
 
     private static void findApplication() {
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

    private static void addInterviews() {
        System.out.println("Add new Interview");

        System.out.println("Enter Interview ID");
        int interviewID = scanner.nextInt();

        System.out.println("Enter Application ID");
        int applicationID = scanner.nextInt();

        System.out.println("Enter Interview Date");
        int interviewDate = scanner.nextInt();

        System.out.println("Enter Interview Feedback");
        String feedback = scanner.nextLine();

        Interviews interview = new Interviews(interviewID, applicationID, null, feedback, feedback);
        interviewsService.createInterviews(interviews);

    
                

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