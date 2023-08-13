package com.box.ecommerce_website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.ecommerce_website.model.SubscriberModel;
import com.box.ecommerce_website.repo.SubscriberRepo;
import com.box.ecommerce_website.service.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService{

	
	@Autowired
	private SubscriberRepo subscriberRepo;
	
	@Override
	public void addSubscriber(SubscriberModel subscriberModel) {
		// TODO Auto-generated method stub
		subscriberRepo.save(subscriberModel);
	}

	@Override
	public List<SubscriberModel> getSubscriberList() {
		// TODO Auto-generated method stub
		return subscriberRepo.findAll();
	}

}
