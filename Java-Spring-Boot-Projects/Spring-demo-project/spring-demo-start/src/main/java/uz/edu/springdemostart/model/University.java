package uz.edu.springdemostart.model;

/**
 * Created By hamdamboy
 * Project: spring-demo-start
 * Date: 22/09/22
 * Email: hamdamboy.urunov@gmail.com
 */

public class University {
    //
    private Long id;
    private String name;
    private String courseName;

    public University(Long id, String name, String courseName) {
        super();
        this.id = id;
        this.name = name;
        this.courseName = courseName;
    }

    public University(String name, String courseName){
        this.name = name;
        this.courseName = courseName;
    }
    public University() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}


// Parameters
// 2 methods (GET) and API Postman test qilasiz.