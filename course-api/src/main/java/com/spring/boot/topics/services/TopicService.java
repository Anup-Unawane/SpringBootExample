package com.spring.boot.topics.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.topics.beans.Topic;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepo;
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepo.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topicRepo.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepo.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepo.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepo.delete(id);
	}
}
