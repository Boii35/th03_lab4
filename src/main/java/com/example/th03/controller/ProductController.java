package com.example.th03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.th03.models.Product;
import com.example.th03.services.CategoryService;
import com.example.th03.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String list(Model model) {

        model.addAttribute(
            "products",
            productService.findAll()
        );

        return "products/products-list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {

        model.addAttribute(
            "product",
            new Product()
        );

        model.addAttribute(
            "categories",
            categoryService.findAll()
        );

        return "products/add-product";
    }

    @PostMapping("/add")
    public String add(
            @ModelAttribute Product product) {

        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editForm(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
            "product",
            productService.findById(id)
        );

        model.addAttribute(
            "categories",
            categoryService.findAll()
        );

        return "products/update-product";
    }

    @PostMapping("/edit")
    public String update(
            @ModelAttribute Product product) {

        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id) {

        productService.deleteById(id);

        return "redirect:/products";
    }
}