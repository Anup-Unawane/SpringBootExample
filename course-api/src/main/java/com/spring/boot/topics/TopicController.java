package com.spring.boot.topics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class TopicController {

	@Autowired
	TopicService service;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return service.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return service.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics" )
	public void addTopic(@RequestBody Topic topic)
	{
		service.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id)
	{
		service.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		service.deleteTopic(id);
	}
	
}
