package com.project_agh.smartoffice.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Office {
    WorkPlace workPlace;

    @Autowired
    public Office(WorkPlace workPlace) {
        this.workPlace = workPlace;
    }
}
