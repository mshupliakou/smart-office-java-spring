package com.project_agh.smartoffice.model;

import lombok.Data;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("worker")
@Data
public class Worker {
    @Id
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("lastname")
    private String lastname;
    @Column("jobtitle")
    private String jobTitle;
}
