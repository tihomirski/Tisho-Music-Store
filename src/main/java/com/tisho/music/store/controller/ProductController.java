package com.tisho.music.store.controller;

import com.tisho.music.store.model.Product;
import com.tisho.music.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList/all")
    public String getProducts(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }



    //Seen that the ability to see the details of a product is available also to a guest,
    //it will be implemented here.
    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }

    //Added the last. Seen that we have already the same mapping,
    //we have to change the mapping of the getProducts() above.
    //Then change also the links in the header under the "Products" link in the navbar.
    //Not this one, the one above.
    @RequestMapping("/productList")
    public String getProductByCategory(@RequestParam("searchCondition") String searchCondition, Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        model.addAttribute("searchCondition", searchCondition);

        return "productList";
    }

}
