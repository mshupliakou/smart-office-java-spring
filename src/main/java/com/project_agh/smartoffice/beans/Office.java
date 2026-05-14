package com.project_agh.smartoffice.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Office {
    private final ObjectProvider<WorkPlace> workPlaceProvider;

    public Office(ObjectProvider<WorkPlace> workPlaceProvider) {
        this.workPlaceProvider = workPlaceProvider;
    }
}
