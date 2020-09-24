package aptech.fpt.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Tên không thể để trống.")
    @Size(min = 8, message = "Tên phải dài hơn 8 ký tự.")
    private String name;
    @Column(name = "age")
    @NotBlank(message = "Tuổi không thể để trống.")
    private String age;
    @Column(name = "salary")
    @NotBlank(message = "Lương không thể để trống.")
    private String salary;

    public User(){

    }

    public User(@NotBlank(message = "Tên không thể để trống.") @Size(min = 8, message = "Tên phải dài hơn 8 ký tự.") String name, @NotBlank(message = "Tuổi không thể để trống.") String age, @NotBlank(message = "Lương không thể để trống.") String salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
