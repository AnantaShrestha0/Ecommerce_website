package com.box.ecommerce_website.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.box.ecommerce_website.model.CategoryModel;
import com.box.ecommerce_website.model.ProductModel;
import com.box.ecommerce_website.service.CategoryService;
import com.box.ecommerce_website.service.ProductService;

@Controller
public class AdminPageController {
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	
	@GetMapping("/adminHomePage")
	public String getAdminHomePage() {
		return "admin-homepage";
	}
	
	
	@PostMapping("/addCategory")
	public String postCategory(CategoryModel categoryModel) {
		
		categoryService.addCategory(categoryModel);
		
		return "redirect:/adminHomePage";
	}
	
	@GetMapping("/categoryList")
	public String getCategoryList(Model model) {
		List<CategoryModel> catgoryList=categoryService.getCategoryList();
		model.addAttribute("categoryList",catgoryList);
		return "category-list";
	}
	
	@GetMapping("/deleteCategory")
	public String getDeleteCategory(@RequestParam int id) {
		categoryService.deleteCategory(id);
		return "redirect:/categoryList";
	}
	
	
	@GetMapping("/addProducts")
	public String getAddProducts(Model model) {
		List<CategoryModel> catgoryList=categoryService.getCategoryList();
		model.addAttribute("categoryList",catgoryList);
		return "admin-add-product";
	}
	
	
	
	@PostMapping("/addProduct")
	public String postProduct(ProductModel productModel,@RequestParam("img") MultipartFile imagefile,RedirectAttributes redirectAttributes) {
		
		
		String unqiue;
		
		
		if(!imagefile.isEmpty()) {
			try {
				 unqiue=generateUniqueFileName(imagefile.getOriginalFilename());
				Files.copy(imagefile.getInputStream(), Path.of("src/main/resources/static/images"
						+ "/products/"+unqiue), StandardCopyOption.REPLACE_EXISTING);
				productModel.setImage(unqiue);
				int categoryId=productModel.getCategoryId();
				String category=categoryService.findByIdName(categoryId);
			    productModel.setCategory(category);
				
				productService.addProduct(productModel);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			redirectAttributes.addFlashAttribute("message","Product added successfully");
			return "redirect:/addProducts";
			
		}
		

		
		
		redirectAttributes.addFlashAttribute("Error","Image file empty.");
		return "redirect:/addProducts";
	}
	
	
	
	 private String generateUniqueFileName(String originalFileName) {
	        String extension = StringUtils.getFilenameExtension(originalFileName);
	        return UUID.randomUUID().toString() + "." + extension;
	    }
	
	 
	 
	 @GetMapping("/productList")
	 public String getProductList(Model model) {
		 
		 List<ProductModel> productList=productService.getAllProduct();
		 model.addAttribute("productList", productList);
		 return "admin-product-list";
	 }
	 
	 @GetMapping("/removeProduct")
	 public String getRemoveProduct(@RequestParam int id) {
		 
		 String imageName=productService.getProductById(id).getImage();
		 
		 String imagePath = "src/main/resources/static/images/products/"+imageName;
	        Path path = Paths.get(imagePath);

	        try {
	            Files.delete(path);
	        } catch (IOException e) {
	            // Handle the exception
	            e.printStackTrace();
	        }
		 
		 productService.deleteProductById(id);
		 return "redirect:/productList";
	 }
	 
	
	
	
	
	
	
	
}
