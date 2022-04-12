package com.example.restdemo.topics;

// in Spring, business services are typically Singleton, when the application starts up Spring creates and instance of the service
// and keeps it in the memory and keeps it in that instance.

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring framework description"),  // Calls constructor on the topic class to create
            new Topic("Java", "Core Java", "Core Java description"),                  // a new topic object
            new Topic("Javascript", "Javascript", "Javascript description")
    );

    public List<Topic> getAllTopics() {
        return topics;
    }
}
