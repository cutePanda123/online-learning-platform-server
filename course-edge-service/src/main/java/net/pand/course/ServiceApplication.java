package net.pand.course;

import net.pand.course.filter.CourseFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        CourseFilter courseFilter = new CourseFilter();
        filterRegistrationBean.setFilter(courseFilter);

        List<String> urlPatterns = new LinkedList<>();
        urlPatterns.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }
}
