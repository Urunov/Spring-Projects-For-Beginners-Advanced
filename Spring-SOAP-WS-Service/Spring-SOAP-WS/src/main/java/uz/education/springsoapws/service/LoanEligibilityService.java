package uz.education.springsoapws.service;

import uz.education.springsoapws.loaneligibility.Acknowledgement;
import uz.education.springsoapws.loaneligibility.CustomerRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibilityService {
    //
   public Acknowledgement checkLoanEligibility(CustomerRequest request) {

		Acknowledgement acknowledgement = new Acknowledgement();
		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

		if (!(request.getAge() > 30 && request.getAge() <= 60)) {
			mismatchCriteriaList.add("Person age should in between 30 to 60");
		}
		if (!(request.getYearlyIncome() > 200000)) {
			mismatchCriteriaList.add("minimum income should be more than 200000");
		}
		if (!(request.getCibilScore() > 500)) {
			mismatchCriteriaList.add("Low CIBIL Score please try after 6 month");
		}
		if (mismatchCriteriaList.size() > 0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		} else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		return acknowledgement;
	}
}