package com.ibik.api.academicservices.products;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ibik.api.academicservices.students.Students;

@Entity
@Table(name="products")
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    @NotEmpty(message = "Name is required")
    private String name;
    
    @Column(columnDefinition = "TEXT")
    @NotEmpty(message = "Description is required")
    private String description;
    
    @Column(length = 10)
    @Min(value = 1, message = "Stock is required")
    private int stock;

    @Column(length = 50)
    @NotEmpty(message = "Price is required")
    private String price;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean is_active;

    @Column(columnDefinition = "TEXT")
    private String images;

    // @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    // @JsonBackReference
    // private Set<Students> students;


    public Products() {
    }

    public Products(int id, @NotEmpty(message = "Name is required") String name,
            @NotEmpty(message = "Description is required") String description,
            @Min(value = 1, message = "Stock is required") int stock,
            @NotEmpty(message = "Price is required") String price, boolean is_active, String images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.is_active = is_active;
        this.images = images;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    // public Set<Students> getStudents() {
    //     return students;
    // }

    // public void setStudents(Set<Students> students) {
    //     this.students = students;
    // }
    
}
