package com.project_agh.smartoffice.serviece;

import com.project_agh.smartoffice.dto.WorkerCreateDto;
import com.project_agh.smartoffice.dto.WorkerReadDto;
import com.project_agh.smartoffice.model.Worker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class WorkerService {
    private final ConcurrentHashMap<UUID, Worker> workers = new ConcurrentHashMap<>();

    public Worker addWorker(WorkerCreateDto workerCreateDto) {
        Worker worker = new Worker();
        WorkerReadDto workerReadDto = createWorker(workerCreateDto);
        worker.setId(workerReadDto.getId());
        worker.setName(workerReadDto.getName());
        worker.setLastname(workerReadDto.getLastname());
        worker.setJobTitle(workerReadDto.getJobTitle());
        workers.put(worker.getId(), worker);
        log.info("Worker with id " + worker.getId() + " has been added to the map");
        return worker;
    }

    public WorkerReadDto createWorker(WorkerCreateDto workerCreateDto) {
        WorkerReadDto worker = new WorkerReadDto();
        worker.setName(workerCreateDto.getName());
        worker.setLastname(workerCreateDto.getLastname());
        worker.setJobTitle(workerCreateDto.getJobTitle());
        worker.setId(UUID.randomUUID());
        return worker;
    }

    public ConcurrentHashMap<UUID, Worker> listAllWorkers() {
        return  workers;
    }

    public Worker getWorker(UUID id) {
        return workers.get(id);
    }
}
