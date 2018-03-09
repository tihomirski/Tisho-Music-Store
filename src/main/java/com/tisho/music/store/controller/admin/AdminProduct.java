package com.tisho.music.store.controller.admin;

import com.tisho.music.store.model.Product;
import com.tisho.music.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    private Path path;

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {

        //We are doing this way because we want to set the default values.
        //If we initialize some vars here, the will appear set in the radio buttons.
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("New");
        product.setProductStatus("Active");

        model.addAttribute("product", product);

        //Basically, this method is called before the page loads.
        //We set the defaults and attach it to the model of the page.
        //Then with this model we go to addProduct page where we are going to read these.
        return "addProduct";
    }

    //@Valid to check the validity of the fields. Remember we have some constraints on some fields.. Here is a sort of a check.
    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product,
                                 BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "addProduct";
        }

        productService.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        //Basically, this method is called before the page loads.
        //We set the defaults and attach it to the model of the page.
        //Then with this model we go to addProduct page where we are going to read these.
        return "editProduct";
    }

    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product,
                                 BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()) {
            return "editProduct";
        }

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }
}
