package point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
@Entity
public class Diagnosis implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String diagnosis;
    private String diagnosed_by; // ale to chyba nie potrzeba bo jest doctor.
    private Date diagnosis_date;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Disease disease;

    public Diagnosis(){

    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosed_by() {
        return diagnosed_by;
    }

    public void setDiagnosed_by(String diagnosed_by) {
        this.diagnosed_by = diagnosed_by;
    }

    public Date getDiagnosis_date() {
        return diagnosis_date;
    }

    public void setDiagnosis_date(Date diagnosis_date) {
        this.diagnosis_date = diagnosis_date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", diagnosis='" + diagnosis + '\'' +
                ", diagnosed_by='" + diagnosed_by + '\'' +
                ", diagnosis_date=" + diagnosis_date +
                ", doctor=" + doctor +
                ", disease=" + disease +
                '}';
    }
}
