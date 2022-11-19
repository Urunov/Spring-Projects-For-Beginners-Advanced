package uz.edu.springsoapcalculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "", name = "Hello")
public interface HelloService {
    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHello",
                    targetNamespace = "http://service.ws.sample",
                    className = "uz.edu.springsoapcalculator.service")
    @WebMethod(action = "urn:SayHello")
    @ResponseWrapper(
            localName = "sayHelloResponse",
            targetNamespace = "http://service.ws.sample",
            className = "uz.edu.springsoapcalculator.SayHelloResponse")
    String sayHello(@WebParam(name = "name") String name);
}