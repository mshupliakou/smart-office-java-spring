package com.project_agh.smartoffice.configuration;

import com.project_agh.smartoffice.beans.Office;
import com.project_agh.smartoffice.beans.WorkPlace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    WorkPlace workPlace;
    @Bean
    public Office office(WorkPlace workPlace) {
        return new Office(workPlace);
    }
}
