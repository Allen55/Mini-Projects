package com.example.restdemo.course;

// in Spring, business services are typically Singleton, when the application starts up Spring creates and instance of the service
// and keeps it in the memory and keeps it in that instance.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("spring", "Spring Framework", "Spring framework description"),  // Calls constructor on the topic class to create
            new Course("java", "Core Java", "Core Java description"),                  // a new topic object
            new Course("javascript", "Javascript", "Javascript description")
    ));

    public List<Course> getAllCourses(String id) {
        List<Course> topics = new ArrayList();
        courseRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Optional<Course> getCourse(String id){

        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);  //  save can do both add and update. repository knows if there's arleady a row in the table with the id.
    }

    public void deleteCourse(String id) {

        courseRepository.deleteById(id);
    }
}
