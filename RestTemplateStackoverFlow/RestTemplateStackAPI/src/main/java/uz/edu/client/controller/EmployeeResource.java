package uz.edu.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.edu.client.model.Employee;
import uz.edu.client.service.EmployeeService;

/**
 * @project: RestTemplateStackAPI
 * @Date: 18.10.2022
 * @author: H_Urunov
 **/

@RestController
@RequestMapping("/employee-client")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmp(employee);
    }
}
