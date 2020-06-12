package io.javabrains.course;

import io.javabrains.topic.Topic;
import io.javabrains.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//   private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spring Framework", "Spring Framework Description"),
//           new Topic("java", "Core Java", "Core Java Description"),
//           new Topic("javascript", "JavaScript", "Javascript Description")
//   ));

    public List<Course> getAllCourses(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }
    public Optional<Course> getCourse(String id){
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
    }



    public void deleteCourse(String id) {
        courseRepository.deleteById(id);

    }
}
