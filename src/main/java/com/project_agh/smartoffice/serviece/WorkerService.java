package com.project_agh.smartoffice.serviece;

import com.project_agh.smartoffice.dto.WorkerCreateDto;
import com.project_agh.smartoffice.dto.WorkerReadDto;
import com.project_agh.smartoffice.model.Worker;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class WorkerService {
    HashMap<UUID, Worker> workers;
    public WorkerService() {
        workers = new HashMap<>();
    }

    public void addWorker(WorkerCreateDto workerCreateDto) {
        Worker worker = new Worker();
        WorkerReadDto workerReadDto = createWorker(workerCreateDto);
        worker.setId(workerReadDto.getId());
        worker.setName(workerReadDto.getName());
        worker.setLastname(workerReadDto.getLastname());
        worker.setJobTitle(workerReadDto.getJobTitle());
        workers.put(worker.getId(), worker);
        System.out.println("Worker with id " + worker.getId() + " has been added to the map");
    }

    public WorkerReadDto createWorker(WorkerCreateDto workerCreateDto) {
        WorkerReadDto worker = new WorkerReadDto();
        worker.setName(workerCreateDto.getName());
        worker.setLastname(workerCreateDto.getLastname());
        worker.setJobTitle(workerCreateDto.getJobTitle());
        worker.setId(UUID.randomUUID());
        return worker;
    }

    public HashMap<UUID, Worker> listAllWorkers() {
        return workers;
    }

    public Worker getWorker(UUID id) {
        return workers.get(id);
    }
}
