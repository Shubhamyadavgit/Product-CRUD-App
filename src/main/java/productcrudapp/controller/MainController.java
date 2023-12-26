package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.entity.Product;
import productcrudapp.service.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/index")
	public String home(Model m) {
		List<Product> product = productService.getAllProduct();
		System.out.println(product);
		m.addAttribute("products", product);
		return "index.jsp";
	}
	
	@RequestMapping("/addproduct")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add-Product");
		return "add-product-form.jsp";
	}
	@RequestMapping(value = "/handleproduct",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest req) {
		productService.createProduct(product);
		RedirectView view = new RedirectView();
		view.setUrl(req.getContextPath()+"/index");
		return view;
	}
	@RequestMapping("/delete/{id}")
	public RedirectView deleteProduct(@PathVariable("id") int id,HttpServletRequest req) {
		productService.deleteProduct(id);
		RedirectView view = new RedirectView();
		view.setUrl(req.getContextPath()+"/index");
		return view;
	}
}
