package com.example.restdemo.topics;

// in Spring, business services are typically Singleton, when the application starts up Spring creates and instance of the service
// and keeps it in the memory and keeps it in that instance.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().toLowerCase().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
