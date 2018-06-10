package be.ucll.exam.web.config;

import be.ucll.exam.service.TourismService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TourismService tourismService(){return new TourismService("Memory");}
}
