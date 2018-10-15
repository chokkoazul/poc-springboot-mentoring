package com.chokkoazul.pocspringbootmentoring.controller;

import com.chokkoazul.pocspringbootmentoring.model.Product;
import com.chokkoazul.pocspringbootmentoring.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Product>> getAllProducts() {
        HttpStatus status = HttpStatus.OK;
        List<Product> list = null;
        try {
            list = productRepository.findAll();
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(list, status);
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
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        HttpStatus status = HttpStatus.CREATED;
        try {
            product.set_id(ObjectId.get());
            productRepository.save(product);
        } catch (Exception e) {
            product = null;
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(product, status);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable ObjectId id) {
        productRepository.delete(productRepository.findBy_id(id));
    }


}
