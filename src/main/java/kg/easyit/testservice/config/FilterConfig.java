package kg.easyit.testservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Value("${operation.id}")
    private String operationId;

    @Bean
    public FilterRegistrationBean< CustomURLFilter > filterRegistrationBean() {
        FilterRegistrationBean < CustomURLFilter > registrationBean = new FilterRegistrationBean();
        CustomURLFilter customURLFilter = new CustomURLFilter();
        customURLFilter.setOperationId(operationId);
        registrationBean.setFilter(customURLFilter);
        registrationBean.addUrlPatterns("/api/v1/test/*");
        registrationBean.setOrder(1); //set precedence
        return registrationBean;
    }
}


