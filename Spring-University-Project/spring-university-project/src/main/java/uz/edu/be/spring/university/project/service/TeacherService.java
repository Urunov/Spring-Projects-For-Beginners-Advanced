package uz.edu.be.spring.university.project.service;

import uz.edu.be.spring.university.project.exception.TeacherNotFoundException;
import uz.edu.be.spring.university.project.model.Teachers;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    public Teachers saveTeacher(Teachers teachers);

    public List<Teachers> fetchTeacherList() throws TeacherNotFoundException;

    Optional<Teachers> getOnlyTeacherById(Long id) throws TeacherNotFoundException;

    Teachers updateTeacherInfo(Long id, Teachers teachers);

    void deleteTeacherId(Long teacherId);

    Teachers fetchTeacherByName(String name) throws TeacherNotFoundException;


}
