package com.tisho.music.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

// Every time Spring starts and sees this annotation it will understand that this is an entity (in the ORM),
// and creates a table in the DB
// This is when we were talking about mapping from table to object.
// So one row in the table is one object.
// So this is the object.
// One instance of this class is one row.
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -3414415024547094514L;

    //This will generate a PK
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotEmpty(message = "Product name cannot be empty.")
    private String productName;
    private String productCategory;

//    @Type(type="text")
    @Column(columnDefinition="text")
    private String productDescription;

    @Min(value = 0, message = "The product price must be positive number.")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The unit in stock must be positive number.")
    private int unitInStock;
    private String productManufacturer;

    //We don't want to be created a field in the DB for the image.
    //Rather, we are going to store it in /resources.
    @Transient
    private MultipartFile productImage;

    //According to the RM diagram, we need to include the CartItems in the Product class.
    //This has to happen in 1-to-many relation.
    //With this annotation we imply this constraint.
    //
    //mappedBy - In the other related class, CartItem, we are going to have a field called product which is refering to this class.
    //cascade - In 1-to-many there is a parent and child. Parent is always the 1 side and child is always the many side.
    //So, in case we have to remove the parent, the child depends on this class. So, the child needs to be removed automatically.
    //fetch - [LAZY | EAGER] - If it was LAZY, means that the system will not go to DB to get this data. That's the default.
    //We need it EAGER because later we will need to convert this Product entity into JSON and we have to read the data.
    //The @JsonIgnore tells that when the object is converted into JSON, this field will be omitted.
    //The reason we use it is because 2 classes refer to each other
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
