package com.example.restdemo.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TopicController {

    @Autowired                           // Marks topicService as something that needs dependency injection
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){   // List<Topic> gets converted to JSON automatically in the http response
        return topicService.getAllTopics();
    }


    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")                        // get the post body, convert it to a topic instance, and convert it to a list in the topic service
    public void addTopic(@RequestBody Topic topic){  // taking request body and converting to topic instance
        topicService.addTopic(topic);
    }
    @RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){  // taking request body and converting to topic instance
        topicService.updateTopic(id, topic);
    }

    // OR @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id){  // taking request body and converting to topic instance
        topicService.deleteTopic(id);
    }


}
