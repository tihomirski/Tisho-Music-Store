package com.tisho.music.store.dao;

import com.tisho.music.store.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

//Doing the DAO with interface, later we can wire it to the data and Spring will inject it as beans.
//The annotation tells Spring that this class is dealing with database.
////////@Repository
public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
