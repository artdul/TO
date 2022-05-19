package point;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Patient implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private long id;

    private String name;
    private Date birthDate;
    private String sex;
    private Date hospitalization_Date;
    private Integer drugs_received;
    private String diagnosed_diseases;
    private String drug;

    @OneToOne
    private Integer department_id;
    @OneToOne
    private Integer doctor_id;
    @OneToOne
    private Integer disease_id;

    @ManyToOne
    private Department department;
    public Patient() {
    }

    public Patient(String name, Date birthDate, String sex, Date hospitalization_Date, Integer drugs_received, String diagnosed_diseases) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.hospitalization_Date = hospitalization_Date;
        this.drugs_received = drugs_received;
        this.diagnosed_diseases = diagnosed_diseases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getHospitalization_Date() {
        return hospitalization_Date;
    }

    public Patient(String drug) {
        this.drug = drug;
    }

    public void setHospitalization_Date(Date hospitalization_Date) {
        this.hospitalization_Date = hospitalization_Date;
    }

    public Integer getDrugs_received() {
        return drugs_received;
    }

    public void setDrugs_received(Integer drugs_received) {
        this.drugs_received = drugs_received;
    }

    public String getDiagnosed_diseases() {
        return diagnosed_diseases;
    }

    public void setDiagnosed_diseases(String diagnosed_diseases) {
        this.diagnosed_diseases = diagnosed_diseases;
    }


    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", hospitalization_Date=" + hospitalization_Date +
                ", drugs_received=" + drugs_received +
                ", diagnosed_diseases='" + diagnosed_diseases + '\'' +
                ", drug='" + drug + '\'' +
                ", department_id=" + department_id +
                ", doctor_id=" + doctor_id +
                ", disease_id=" + disease_id +
                ", department=" + department +
                '}';
    }
}
