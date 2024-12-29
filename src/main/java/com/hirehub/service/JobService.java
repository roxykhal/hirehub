//logic of application and validating data, service > communicates with dao > to perform operations on database
package com.hirehub.service;
import com.hirehub.dao.JobDAO;
import com.hirehub.dao.JobDAOIMPL;
import com.hirehub.model.Job;
import java.util.List;


public class JobService {
    private JobDAO jobDAO;
    
    public JobService() {
        this.jobDAO = new JobDAOIMPL();

    }

    public void createJob(Job job) {
        jobDAO.add(job);

    }

    public void updateJob(Job job) {
        jobDAO.update(job);
    }

    public void deleteJob(int id) {
        jobDAO.delete(id);
    }

    public Job getJobById(int id) {
        return jobDAO.getId(id);
    }

    public List<Job> getAllJobs(){
        return jobDAO.getAll();

}   
}