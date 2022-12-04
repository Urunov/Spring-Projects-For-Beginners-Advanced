package uz.openAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.openAPI.model.users.ListUsers;
import uz.openAPI.model.users.SingleUser;
import uz.openAPI.service.OpenApiServiceImpl;

@RestController
public class OpenApiController {
    //
    @Autowired
    private OpenApiServiceImpl openApiService;

    @GetMapping("/single")
    public ResponseEntity<SingleUser> getSingle(){
        return ResponseEntity.ok(openApiService.singleUser());
    }

    @GetMapping("/getUsers")
    public ResponseEntity<ListUsers> getAll(){
        return ResponseEntity.ok(openApiService.getAll());
    }


}
