package com.example.review.service;

import com.example.review.model.Worker;
import com.example.review.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorkerById(int id) {
        return workerRepository.findById(id).orElse(null);
    }

    public Worker addWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker updateWorker(int id, Worker worker) {
        Worker work = getWorkerById(id);
        if (work!=null) {
            work.setName(worker.getName());
            work.setRole(worker.getRole());
            work.setSalaryAllotted(work.getSalaryAllotted());
            return workerRepository.save(work);
        }
        return null;
    }

    public String deleteWorker(int id) {
        if(getWorkerById(id)!=null) {
            workerRepository.deleteById(id);
            return "Deleted";
        }
        return "Worker with given id not found";
    }
}
