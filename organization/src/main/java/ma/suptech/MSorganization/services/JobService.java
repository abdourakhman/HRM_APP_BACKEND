package ma.suptech.MSorganization.services;

import ma.suptech.MSorganization.entities.Job;

import java.util.List;

public interface JobService {
    Job create(Job job);
    Job update(Job job);
    Job find(Long id);
    List<Job> list();
    void delete(Long id);

}
