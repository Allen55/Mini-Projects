package com.example.restdemo.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TopicController {

    @Autowired                           // Marks topicService as something that needs dependency injection
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){   // List<Topic> gets converted to JSON automatically in the http response
        return topicService.getAllTopics();
    }
}
