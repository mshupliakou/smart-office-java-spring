package com.project_agh.smartoffice.serviece;

import com.project_agh.smartoffice.dto.WorkerCreateDto;
import com.project_agh.smartoffice.dto.WorkerReadDto;
import com.project_agh.smartoffice.jdbc.interfaces.WorkerRepository;
import com.project_agh.smartoffice.model.Worker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class WorkerService {
    private final WorkerRepository workerRepository;
    //private final ConcurrentHashMap<UUID, Worker> workers = new ConcurrentHashMap<>();

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker addWorker(WorkerCreateDto workerCreateDto) {
        Worker worker = new Worker();
        WorkerReadDto workerReadDto = createWorker(workerCreateDto);
        worker.setId(workerReadDto.getId());
        worker.setName(workerReadDto.getName());
        worker.setLastname(workerReadDto.getLastname());
        worker.setJobTitle(workerReadDto.getJobTitle());
        workerRepository.save(worker);
        //workers.put(worker.getId(), worker);
        log.info("Worker with id " + worker.getId() + " has been added to the map");
        return worker;
    }

    public WorkerReadDto createWorker(WorkerCreateDto workerCreateDto) {
        WorkerReadDto worker = new WorkerReadDto();
        worker.setName(workerCreateDto.getName());
        worker.setLastname(workerCreateDto.getLastname());
        worker.setJobTitle(workerCreateDto.getJobTitle());
        worker.setId(String.valueOf(UUID.randomUUID()));
        return worker;
    }

    public List<Worker> listAllWorkers() {
        return (List<Worker>) workerRepository.findAll();
    }

    public Worker getWorker(String id) {
        return workerRepository.getById(id);
    }
}
