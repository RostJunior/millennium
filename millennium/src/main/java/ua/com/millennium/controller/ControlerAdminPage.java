package ua.com.millennium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.com.millennium.domain.Product;
import ua.com.millennium.domain.Role;
import ua.com.millennium.domain.Type;
import ua.com.millennium.domain.User;
import ua.com.millennium.service.CartService;
import ua.com.millennium.service.OrderingService;
import ua.com.millennium.service.ProductService;
import ua.com.millennium.service.RoleService;
import ua.com.millennium.service.TypeService;
import ua.com.millennium.service.UserService;

@Controller
public class ControlerAdminPage {

	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService users;
	
	@Autowired
	private TypeService typs;

	@Autowired
	private OrderingService orderService;
	
	@Autowired
	private RoleService roles;
	

	@RequestMapping(value="/adminList" ) 
	public String adminList() {
		
		return "admin/adminList";
		
}
	
	@RequestMapping(value="/adminProduct" ) 
	public String adminProduct(Model model) {
		
		List<Product> products = productService.getAllProduct();
				
		List<Type> typeList = typs.getAllType();
		model.addAttribute("productList", products);
		model.addAttribute("typeList", typeList);
		
		
		return "admin/adminProducts";
		
}
	
	@RequestMapping(value = "/newType", method = RequestMethod.POST)
	public String newTypePost(@RequestParam (value="nameType") String type){
		typs.createType(type);
		
		return "redirect:/adminProduct";
		
	}
	@RequestMapping(value = "deleteType/{typelistIdType}")
	public String deleteType(@PathVariable String typelistIdType){
		int typeId = Integer.parseInt(typelistIdType);
		typs.deleteType(typeId);
		
		return "redirect:/adminProduct";
		
	}
	
	@RequestMapping(value = "/adminNewProduct")
	public String adminNewProductGet(Model model) {
		
		List<Type> typeList = typs.getAllType();
		
		model.addAttribute("typeList", typeList);
		
		
		return "admin/adminNewProduct";
		
	}
	
	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String newProduct(
			@RequestParam(value = "nameProduct") String nameProduct,
			@RequestParam(value = "priceProduct") String priceProduct,
			@RequestParam(value = "standardProduct") String standardProduct,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "idType") String idType,
			@RequestParam(value = "pictureArray", required = false) MultipartFile uploadedFile
			){
		
		int price = Integer.parseInt(priceProduct);
		int idtype = Integer.parseInt(idType);
		
		if (!ProductImageUpload.getFileName(uploadedFile).isEmpty()) {
			String imageName = ProductImageUpload.getFileName(uploadedFile);
			productService.createProduct(nameProduct, price, description, standardProduct, typs.findByIdType(idtype), imageName);
			ProductImageUpload.fileUpload(uploadedFile);
		} else if (ProductImageUpload.getFileName(uploadedFile).isEmpty()) {
			String imageName = "NoPhoto.png";
			productService.createProduct(nameProduct, price, description, standardProduct, typs.findByIdType(idtype), imageName);
		}
		
		
		return "redirect:/adminProduct";
	}
	
	
	@RequestMapping(value = "deleteProduct/{productsIdProduct}")
	public String deleteProduct(@PathVariable String productsIdProduct) {
		int idProduct = Integer.parseInt(productsIdProduct);
		productService.deleteProduct(idProduct);
		return "redirect:/adminProduct";
	}
	

	@RequestMapping(value="editProduct/{productId}") 
	public String editProductGet(@PathVariable String productId, Model model) {
		int idProduct = Integer.parseInt(productId);
		List<Type> type = typs.getAllType();
		model.addAttribute("editProduct", productService.findById(idProduct));
		model.addAttribute("allTyps", type);
		
		return "admin/adminEditProduct";
	}
	
	
	

	@RequestMapping(value = "editProduct/{editProductIdProduct}", method = RequestMethod.POST)
	public String editProductPost(@PathVariable String editProductIdProduct, 
			@RequestParam(value = "newNameProduct") String nameProduct,
			@RequestParam(value = "newStandardProduct") String standardProduct,
			@RequestParam(value = "newPriceProduct") String priceProduct,
			@RequestParam(value = "newdescription") String newdescription,
			@RequestParam(value = "newIdType") String idType,
			@RequestParam(value = "pictureArrays", required = false) MultipartFile uploadedFile
					
			) {
		
		int idProduct = Integer.parseInt(editProductIdProduct);
		int idTyp = Integer.parseInt(idType);
		int price = Integer.parseInt(priceProduct);
		
		
		if (!ProductImageUpload.getFileName(uploadedFile).isEmpty()) {
			
			String newImageName = ProductImageUpload.getFileName(uploadedFile);
			
			productService.updateProduct(idProduct, nameProduct, price, newdescription, standardProduct, typs.findByIdType(idTyp), newImageName);
						
			ProductImageUpload.fileUpload(uploadedFile);
			
		} else if (ProductImageUpload.getFileName(uploadedFile).isEmpty()) {
			
			String namePhoto = uploadedFile.getName();
			
			productService.updateProduct(idProduct, nameProduct, price, newdescription, standardProduct, typs.findByIdType(idTyp), namePhoto);
		}
		
		return "redirect:/adminProduct";
	}
	
	@RequestMapping(value="/adminUsers" ) 
	public String adminUsers(Model model) {
		
		List<User> userlist = users.getAllUser();
				
		List<Role> roleList = roles.getAllRole();
		
		model.addAttribute("userList", userlist);
		model.addAttribute("roleList", roleList);
		
		
		return "admin/adminUsers";
		
}
	@RequestMapping(value = "deleteUser/{userIdUser}")
	public String deleteUser(@PathVariable String userIdUser) {
		int idUser = Integer.parseInt(userIdUser);
		
		users.deleteUser(idUser);
		
		return "redirect:/adminUsers";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String newUser(
			@RequestParam(value = "nameUser") String nameUser,
			@RequestParam(value = "emailUser") String emailUser,
			@RequestParam(value = "telephoneUser") String telephoneUser,
			@RequestParam(value = "loginUser") String loginUser,
			@RequestParam(value = "passwordUser") String passwordUser,
			@RequestParam(value = "idRole") String idRole
			){
		int id = Integer.parseInt(idRole);
		
		users.createUserFull(nameUser, telephoneUser, emailUser, loginUser, passwordUser, roles.findById(id));
		
		
		return "redirect:/adminUsers";
	}
	
}
