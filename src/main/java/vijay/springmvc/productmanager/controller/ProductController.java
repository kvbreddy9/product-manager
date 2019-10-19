package vijay.springmvc.productmanager.controller;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vijay.springmvc.productmanager.model.Product;
import vijay.springmvc.productmanager.service.ProductService;

import java.net.Authenticator;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @RequestMapping("/index")
    public String viewHomePage(Model model){
        List<Product> products =productService.listAll();
        model.addAttribute("products",products);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }

    @RequestMapping(value = "/save" ,method= RequestMethod.POST)
    public String save(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/index";
    }
}
