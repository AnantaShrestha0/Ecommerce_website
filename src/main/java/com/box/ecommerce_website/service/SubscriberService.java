package com.box.ecommerce_website.service;

import java.util.List;

import com.box.ecommerce_website.model.SubscriberModel;


public interface SubscriberService {

	
	void addSubscriber(SubscriberModel subscriberModel);
	
	List<SubscriberModel> getSubscriberList();
}
