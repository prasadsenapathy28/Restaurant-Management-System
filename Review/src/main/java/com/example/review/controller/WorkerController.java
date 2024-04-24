package com.example.review.controller;

import com.example.review.model.Worker;
import com.example.review.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/all")
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("get/{id}")
    public Worker getWorkerById(@PathVariable int id) {
        return workerService.getWorkerById(id);
    }

    @PostMapping("/add")
    public Worker addWorker(@RequestBody Worker worker) {
        return workerService.addWorker(worker);
    }

    @PutMapping("/update/{id}")
    public String updateWorker(@PathVariable int id, @RequestBody Worker worker) {
        Worker updatedWorker = workerService.updateWorker(id, worker);
        return updatedWorker != null ? "Updated" : "Worker with given id not found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWorker(@PathVariable int id) {
        return workerService.deleteWorker(id);
    }
}
