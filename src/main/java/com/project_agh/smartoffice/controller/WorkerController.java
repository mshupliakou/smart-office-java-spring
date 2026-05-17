package com.project_agh.smartoffice.controller;

import com.project_agh.smartoffice.dto.WorkerCreateDto;
import com.project_agh.smartoffice.model.Worker;
import com.project_agh.smartoffice.serviece.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/smart-office/workers-hub")
public class WorkerController {
    private final WorkerService workerService;

    WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/{id}")
    Worker getWorkerById(@PathVariable UUID id) {
        return workerService.getWorker(id);
    }

    @GetMapping("/workers")
    List<Worker> getWorkers() {
        return new ArrayList<>(workerService.listAllWorkers().values());
    }

    @PostMapping("/add-new-worker-form")
    @ResponseStatus(HttpStatus.CREATED)
    Worker addWorkerToDataBase(@RequestBody WorkerCreateDto workerCreateDto) {
        return workerService.addWorker(workerCreateDto);
    }
}
