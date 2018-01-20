package com.spring.boot.courses.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.courses.beans.Course;


public interface CourseRepository extends CrudRepository<Course, String> {

	/**
	 * Here, We need to find courses related to particular topic. Since we have Topic in Course Class,
	 * To find all rows related to a a property, use findBy< property Name >.
	 * Here property is an object (Topic). So also need to add property for that object to search (name)
	 * Spring JPA will auto generate code for such method 
	 * @param topicId
	 * @return
	 */
	public List<Course> findByTopicId(String topicId);
}
