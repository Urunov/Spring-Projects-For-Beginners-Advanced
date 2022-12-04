package uz.openAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.openAPI.model.users.ListUsers;
import uz.openAPI.model.users.SingleUser;

@Service
public class OpenApiServiceImpl implements OpenApiService {
    //
    @Value("${api.reqres.url}")
    private String BaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public SingleUser singleUser() {

       // SingleUser result = restTemplate.getForEntity("https://reqres.in/api/users/2", SingleUser.class).getBody();
        SingleUser result = restTemplate.getForEntity(BaseUrl+"/2", SingleUser.class).getBody();
        return result;
    }

    @Override
    public ListUsers getAll() {
       //ListUsers result = restTemplate.getForObject("https://reqres.in/api/users" + "?page=2", ListUsers.class);
       ListUsers result = restTemplate.getForObject(BaseUrl + "?page=2", ListUsers.class);
        return result;
    }
}
