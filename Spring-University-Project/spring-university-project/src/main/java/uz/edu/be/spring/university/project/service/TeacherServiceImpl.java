package uz.edu.be.spring.university.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.edu.be.spring.university.project.exception.TeacherNotFoundException;
import uz.edu.be.spring.university.project.model.Teachers;
import uz.edu.be.spring.university.project.repository.TeachersRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeachersRepository teachersRepository;

    @Override
    public Teachers saveTeacher(Teachers teachers) {
        return teachersRepository.save(teachers);
    }

    @Override
    public List<Teachers> fetchTeacherList() throws TeacherNotFoundException {
        List<Teachers> teacherList = teachersRepository.findAll();

        if (teacherList.isEmpty()){
            throw new TeacherNotFoundException("There is not teacher in DB");
        }
        return teacherList;
    }

    @Override
    public Optional<Teachers> getOnlyTeacherById(Long id) throws TeacherNotFoundException {
        Optional<Teachers> teachers = teachersRepository.findById(id);

        if (teachers.isEmpty()){
            throw new TeacherNotFoundException("Teacher not available ....");
        }

        return teachers;
    }

    @Override
    public Teachers updateTeacherInfo(Long id, Teachers teachers) {
        Teachers teacherDB = teachersRepository.findById(id).get();

        if (Objects.nonNull(teachers.getName()) &&
                !"".equalsIgnoreCase(teachers.getName())){
            teacherDB.setName(teachers.getName());
        }
        if (teachers.getAge()>0&&teachers.getAge()<65){
            teacherDB.setAge(teachers.getAge());
        }
        return teachersRepository.save(teacherDB);
    }

    @Override
    public void deleteTeacherId(Long teacherId) {
        if(Objects.nonNull(teacherId)){
            teachersRepository.deleteById(teacherId);
        }
        else {
            System.out.println("Teacher already delete ");
        }

    }

    @Override
    public Teachers fetchTeacherByName(String name) throws TeacherNotFoundException {
        Teachers teachers = teachersRepository.findByName(name);
        if(teachers==null||teachers.equals("")){
            throw new TeacherNotFoundException("Coud not find the same name teacher . . . ");
        }
        return teachers;
    }

}
