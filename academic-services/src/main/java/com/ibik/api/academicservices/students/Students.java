package com.ibik.api.academicservices.students;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ibik.api.academicservices.courses.Courses;
import com.ibik.api.academicservices.products.Products;
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

    @Column(length=20)
    @NotEmpty(message = "Firstname is required")
    private String firstname;

    @Column(length=20)
    private String middlename;

    @Column(length=20)
    @NotEmpty(message = "Lastname is required")
    private String lastname;

    @Column(length=50)
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(columnDefinition = "DATE")
    @NotEmpty(message = "Birthdate is required")
    private String birthdate;

    // @Min(value = 1, message = "Program id is required")
    // private int program_id;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Programs programs;

    // @Min(value = 1, message = "Program Study ID is required")
    // private int program_study_id;

    @ManyToOne
    @JoinColumn(name = "program_study_id")
    private ProgramStudy programStudy;
    
    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinTable(
    //     name = "student_rel_courses",
    //     joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
    //     inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    // )
    // @JsonManagedReference
    // private Set<Courses> courses;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_rel_product",
        joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    //@JsonManagedReference
    private Set<Products> products;

    public Students() {
    }

    public Students(int id, @NotEmpty(message = "NPM is required") String npm,
            @NotEmpty(message = "Firstname is required") String firstname, String middlename,
            @NotEmpty(message = "Lastname is required") String lastname,
            @NotEmpty(message = "Email is required") String email,
            @NotEmpty(message = "Birthdate is required") String birthdate,
            @NotEmpty(message = "Program is required") int program_id,
            @NotEmpty(message = "Program Study ID is required") int program_study_id) {
        this.id = id;
        this.npm = npm;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        //this.program_id = program_id;
        //this.program_study_id = program_study_id;
    }


    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    // public Set<Courses> getCourses() {
    //     return courses;
    // }

    // public void setCourses(Set<Courses> courses) {
    //     this.courses = courses;
    // }

    public ProgramStudy getProgramStudy() {
        return programStudy;
    }

    public void setProgramStudy(ProgramStudy programStudy) {
        this.programStudy = programStudy;
    }



}
