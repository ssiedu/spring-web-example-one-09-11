package com.ssi;

import org.springframework.stereotype.Service;

@Service
public class InterestService {
	
	public InterestModel computeInterest(int amount, int time) {
		int interest=(amount*time*10)/100;
		int net=amount+interest;
		InterestModel model=new InterestModel();
		model.setAmount(amount);
		model.setTime(time);
		model.setInterest(interest);
		model.setNet(net);
		return model;
	}
	
}
