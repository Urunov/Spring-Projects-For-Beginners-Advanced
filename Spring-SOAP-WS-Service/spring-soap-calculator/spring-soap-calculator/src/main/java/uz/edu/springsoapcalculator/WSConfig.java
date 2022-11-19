package uz.edu.springsoapcalculator;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Endpoint;

//@Configuration
public class WSConfig {
    @Autowired
    private Bus bus;

    @Bean
    public Endpoint helloEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloServiceImpl());
        endpoint.publish("Hello");
        return endpoint;
    }
}