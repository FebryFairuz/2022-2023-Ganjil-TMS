package com.ibik.api.academicservices.students;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ibik.api.academicservices.courses.Courses;
import com.ibik.api.academicservices.program_study.ProgramStudy;
import com.ibik.api.academicservices.programs.Programs;

@Entity
@Table(name="students") //ini nama table
public class Students implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=15, unique=true)
    @NotEmpty(message = "NPM is required")
    private String npm;

    @Column(length=10)
    @NotEmpty(message = "Firstname is required")
    private String firstname;

    @Column(length=10)
    private String middlename;

    @Column(length=10)
    @NotEmpty(message = "Lastname is required")
    private String lastname;

    // @Min(value = 1, message = "Program is required")
    // private int program_id;
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Programs programs;

    // @Min(value = 1, message = "Department is required")
    // private int department_id;

    @ManyToOne
    @JoinColumn(name = "program_study_id")
    private Set<ProgramStudy> programStudy;
    
    @ManyToMany
    @JoinTable(
        name = "student_rel_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Courses> courses;

    public Students() {
    }

    public Students(int id, @NotEmpty(message = "NPM is required") String npm,
            @NotEmpty(message = "Firstname is required") String firstname, String middlename,
            @NotEmpty(message = "Lastname is required") String lastname,
            @NotEmpty(message = "Program is required") int program_id,
            @NotEmpty(message = "Department is required") int department_id) {
        this.id = id;
        this.npm = npm;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Programs getPrograms() {
        return programs;
    }

    public void setPrograms(Programs programs) {
        this.programs = programs;
    }

    public Set<Courses> getCourses() {
        return courses;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public Set<ProgramStudy> getProgramStudy() {
        return programStudy;
    }

    public void setProgramStudy(Set<ProgramStudy> programStudy) {
        this.programStudy = programStudy;
    }


}
