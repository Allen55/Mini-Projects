package com.example.restdemo.topics;

// in Spring, business services are typically Singleton, when the application starts up Spring creates and instance of the service
// and keeps it in the memory and keeps it in that instance.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring framework description"),  // Calls constructor on the topic class to create
            new Topic("java", "Core Java", "Core Java description"),                  // a new topic object
            new Topic("javascript", "Javascript", "Javascript description")
    ));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);  //  save can do both add and update. repository knows if there's arleady a row in the table with the id.
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
