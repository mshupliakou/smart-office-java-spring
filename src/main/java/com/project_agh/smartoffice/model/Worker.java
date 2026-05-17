package com.project_agh.smartoffice.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class Worker {
    private UUID id;
    private String name;
    private String lastname;
    private String jobTitle;
}
