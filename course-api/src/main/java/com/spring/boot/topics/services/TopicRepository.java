package com.spring.boot.topics.services;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.topics.beans.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
