package uz.education.springsoapws.endpoint;

import uz.education.springsoapws.loaneligibility.Acknowledgement;
import uz.education.springsoapws.loaneligibility.CustomerRequest;
import uz.education.springsoapws.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {
    //
    private static final String NAMESPACE = "http://localhost:9090/uz/education/springsoapws/loaneligibility";
    @Autowired
    private LoanEligibilityService loanEligibilityService;

    @PayloadRoot(namespace = "NAMESPACE", localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request){
        return loanEligibilityService.checkLoanEligibility(request);
    }
}
