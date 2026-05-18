package com.project_agh.smartoffice.model;

import lombok.Data;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("worker")
@Data
public class Worker {
    @Id
    private UUID id;
    private String name;
    private String lastname;
    private String jobTitle;
}
