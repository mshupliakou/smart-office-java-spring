package com.project_agh.smartoffice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class WorkerReadDto {
    UUID id;
    String name;
    String lastname;
    String jobTitle;
}
