package com.example.web;

import com.example.domain.Product;
import com.example.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DaikiTakeuchi on 2016/11/24.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String _index(Model model) {
        return index(model);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("ProductController:[index] Passing through...");
        Iterable<Product> result = productService.findAll(1, 10, "id");
        model.addAttribute("result", result);
        return "product/index";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model) {
        logger.debug("ProductController:[detail] Passing through...");
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }
}