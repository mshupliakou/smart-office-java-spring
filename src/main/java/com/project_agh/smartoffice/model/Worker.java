package com.project_agh.smartoffice.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("worker")
@Data
public class Worker implements Persistable<String> {
    @Id
    @Column("id")
    private String id;
    @Column("name")
    private String name;
    @Column("lastname")
    private String lastname;
    @Column("jobtitle")
    private String jobTitle;

    @Transient
    private boolean isNew = true;

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
