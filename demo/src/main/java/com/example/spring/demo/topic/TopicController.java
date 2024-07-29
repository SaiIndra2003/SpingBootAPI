package com.example.spring.demo.topic;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")   
    public List<Topic> getAllTopics(){ //No need to import the Topic class (due to class scan by spring)
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);  
    }

    @PutMapping("topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {   
        topicService.updateTopic(id,topic);
    }

    @RequestMapping(method=RequestMethod.DELETE,value = "/topics/{id}")
    public void requestMethodName(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
    

}
