package com.raman.web.controllers;

import com.raman.dao.DaoException;
import com.raman.dao.ProductDao;
import com.raman.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class ProductController {
    @Autowired
    ProductDao htDao;

    @RequestMapping(method = RequestMethod.GET, path = "/all-products")
    public String getAllProducts(Model model) throws DaoException {
        model.addAttribute("products", htDao.getAllProducts());
        model.addAttribute("pageTitle", "All Products");
        return "show-products";
    }
    
    @RequestMapping("/product-details")
    public String getProductDetails(@RequestParam Integer id, Model model) throws DaoException {
        model.addAttribute("pr", htDao.getProduct(id));
        return "product-details";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products-by-price-range")
    public String getProductsByPriceRange(Model model, @RequestParam Double min, @RequestParam Double max) throws DaoException {
        model.addAttribute("pageTitle", "Products price between $" + min + " and $" + max);
        model.addAttribute("products", htDao.getProductsByPriceRange(min, max));
        return "show-products";
    }

    @RequestMapping(path = "/add-product", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("pr", new Product());
        return "product-form";
    }
    @RequestMapping(path = "/save-product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute Product pr, BindingResult errors, Model model) throws DaoException {
        if(errors.hasErrors()) {
            model.addAttribute("pr", pr);
            return "product-form";
        }
        if(pr.getProductId() == null) {
            htDao.addProduct(pr);
        } else {
            htDao.updateProduct(pr);
        }
        return "redirect:product-details?id=" + pr.getProductId();
    }

    @RequestMapping(value = "/edit-product", method = RequestMethod.GET)
    public String editProduct(Model model, @RequestParam Integer id) throws DaoException {
        model.addAttribute("pr", htDao.getProduct(id));
        return "product-form";
    }
}