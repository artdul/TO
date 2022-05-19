package point;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Department  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String department_name;
    private Integer number_of_beds;
    private String headed_by;



    @OneToOne
    private Doctor doctor;

    public Department() {
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Integer getNumber_of_beds() {
        return number_of_beds;
    }

    public void setNumber_of_beds(Integer number_of_beds) {
        this.number_of_beds = number_of_beds;
    }

    public String getHeaded_by() {
        return headed_by;
    }

    public void setHeaded_by(String headed_by) {
        this.headed_by = headed_by;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Patient> patients = new ArrayList<>();

    public Department(String department_name, Integer number_of_beds, String headed_by, Doctor doctor, List<Patient> patients) {
        this.department_name = department_name;
        this.number_of_beds = number_of_beds;
        this.headed_by = headed_by;
        this.doctor = doctor;
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department_name='" + department_name + '\'' +
                ", number_of_beds=" + number_of_beds +
                ", headed_by='" + headed_by + '\'' +
                ", patients=" + patients +
                ", doctor=" + doctor +
                '}';
    }
}
