package com.example.web;

import com.example.domain.Product;
import com.example.domain.ProductLine;
import com.example.service.ProductLineService;
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
@RequestMapping(value = "/productline")
public class ProductLineController {

    final static Logger logger = LoggerFactory.getLogger(ProductLineController.class);

    @Autowired
    ProductLineService productLineService;

    @RequestMapping(method = RequestMethod.GET)
    public String _index(Model model) {
        return index(model);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("ProductLineController:[index] Passing through...");
        Iterable<ProductLine> result = productLineService.findAll(1, 10, "id");
        model.addAttribute("result", result);
        return "product_line/index";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model) {
        logger.debug("ProductLineController:[detail] Passing through...");
        ProductLine productLine = productLineService.findById(id);
        model.addAttribute("product_line", productLine);
        return "product_line/detail";
    }
}