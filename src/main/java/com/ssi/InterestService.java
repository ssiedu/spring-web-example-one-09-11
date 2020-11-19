package com.ssi;

import org.springframework.stereotype.Service;

@Service
public class InterestService {
	
	public void computeInterest(InterestModel model) {
		int interest=(model.getAmount()*model.getTime()*10)/100;
		int net=model.getAmount()+interest;
		model.setInterest(interest);
		model.setNet(net);
	}
	
}
