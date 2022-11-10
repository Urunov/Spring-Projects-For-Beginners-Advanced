package uz.education.springsoapws.loaneligibility;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.javatechie.spring.soap.api.loaneligibility
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerRequest }
     *
     */
    public CustomerRequest createCustomerRequest() {
        return new CustomerRequest();
    }

    /**
     * Create an instance of {@link Acknowledgement }
     *
     */
    public Acknowledgement createAcknowledgement() {
        return new Acknowledgement();
    }

}
