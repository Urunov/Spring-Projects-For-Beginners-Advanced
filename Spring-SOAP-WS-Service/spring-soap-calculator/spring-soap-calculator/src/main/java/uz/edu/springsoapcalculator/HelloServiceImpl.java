package uz.edu.springsoapcalculator;

import javax.jws.WebService;

@WebService(
        serviceName = "HelloService",
        portName = "HelloPort",
        targetNamespace = "http://service.ws.sample",
        endpointInterface = "uz.edu.springsoapcalculator.service"
   )
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello: " + name;
    }
}