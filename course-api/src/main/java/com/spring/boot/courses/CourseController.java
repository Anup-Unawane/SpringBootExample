package com.spring.boot.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.courses.beans.Course;
import com.spring.boot.courses.services.CoursesService;
import com.spring.boot.topics.beans.Topic;
import com.spring.boot.topics.services.TopicService;

/**<table border="1"><tr><td>Method</td><td>URL</td><td>Description</td></tr>
 *	<tr><td>GET</td><td>/topics</td><td>Gets All Topics</td></tr>
 *	<tr><td>GET</td><td>/topics/id</td><td>Gets Particular Topic</td></tr>
 *	<tr><td>POST</td><td>/topics</td><td>Creates new Topic</td></tr>
 *	<tr><td>PUT</td><td>/topics/id</td><td>Updates PArticular Topic</td></tr>
 *	<tr><td>DELETE</td><td>/topics/id</td><td>Deletes Particular Topic</td></tr>
 *	</table>
 *
 */

@RestController
public class CourseController {

	@Autowired
	CoursesService service;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return service.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	//here we are ignoring topic id. As all courses have unique id.
	public Course getCourse(@PathVariable String id)
	{
		return service.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses" )
	public void addCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId, "", ""));
		service.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId )
	{
		course.setTopic(new Topic(topicId, "", ""));
		service.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		service.deleteCourse(id);
	}
	
}
