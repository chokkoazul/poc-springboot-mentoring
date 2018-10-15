package com.chokkoazul.pocspringbootmentoring.controller;

import com.chokkoazul.pocspringbootmentoring.model.Product;
import com.chokkoazul.pocspringbootmentoring.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Cristian Osorio (cristian.osorio@globant.com).
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") ObjectId id) {
        return productRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyProductbyId(@PathVariable("id") ObjectId id, @Valid @RequestBody Product product) {
        product.set_id(id);
        productRepository.save(product);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestBody Product product) {
        product.set_id(ObjectId.get());
        productRepository.save(product);
        return product;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable ObjectId id) {
        productRepository.delete(productRepository.findBy_id(id));
    }




}
