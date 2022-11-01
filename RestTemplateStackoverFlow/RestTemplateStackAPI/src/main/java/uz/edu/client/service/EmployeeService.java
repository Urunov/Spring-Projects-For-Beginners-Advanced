package uz.edu.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.edu.client.model.Employee;

/**
 * @project: RestTemplateStackAPI
 * @Date: 18.10.2022
 * @author: H_Urunov
 **/

@Service
@Component
public class EmployeeService {

    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public String saveEmp(Employee employee){

        HttpEntity<Employee> entity = new HttpEntity<>(employee);
        return restTemplate.exchange("http://localhost:9095/employee-client/save", HttpMethod.POST, entity, String.class).getBody();
    }
}
