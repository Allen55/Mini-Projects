package com.example.restdemo.course;

import com.example.restdemo.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class CourseController {

    @Autowired                           // Marks topicService as something that needs dependency injection
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){   // List<Topic> gets converted to JSON automatically in the http response

        return courseService.getAllCourses(id);
    }


    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    // get the post body, convert it to a topic instance, and convert it to a list in the topic service
    // taking request body and converting to topic instance
    @PostMapping("/topics/{topicId}/courses/")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    // taking request body and converting to topic instance

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    // OR @RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
    // taking request body and converting to topic instance
    @DeleteMapping("/topics/{id}/courses/{id}")
    public void deleteTopic(@PathVariable String id){

        courseService.deleteCourse(id);
    }


}
