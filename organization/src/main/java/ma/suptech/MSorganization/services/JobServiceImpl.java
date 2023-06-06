package ma.suptech.MSorganization.services;

import ma.suptech.MSorganization.entities.Job;
import ma.suptech.MSorganization.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job create(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job update(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job find(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public List<Job> list() {
        List<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(job -> jobs.add(job));
        return jobs;
    }

    @Override
    public void delete(Long id) {
        jobRepository.deleteById(id);
    }
}
