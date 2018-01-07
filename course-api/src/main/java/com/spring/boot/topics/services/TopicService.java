package com.spring.boot.topics.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.topics.beans.Topic;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring Framework Course"),	
			new Topic("Core Java", "Core Java 8", "Core Java Course"),	
			new Topic("JavaScript", "JavaScript", "JavaScript Course")	
			));
	
	public List<Topic> getAllTopics()
	{
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++)
		{
			Topic tpic = topics.get(i);
			if(tpic.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
