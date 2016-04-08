package ua.com.millennium.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

import sun.print.resources.serviceui;
import ua.com.millennium.domain.Cart;
import ua.com.millennium.domain.Ordering;
import ua.com.millennium.domain.Product;
import ua.com.millennium.domain.Type;
import ua.com.millennium.domain.User;
import ua.com.millennium.service.CartService;
import ua.com.millennium.service.OrderingService;
import ua.com.millennium.service.ProductService;
import ua.com.millennium.service.TypeService;
import ua.com.millennium.service.UserService;

@Controller
public class ComtrollerPages {

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

	@RequestMapping(value = "/loginPage")
	public String loginPage() {

		return "loginPage";
	}

	@RequestMapping(value = "/")
	public String start() {

		return "redirect:/index";
	}

	@RequestMapping(value = "/index")
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/menuClients")
	public String menuPage() {

		return "client/menu";
	}

	@RequestMapping(value = "/kitchenPage")
	public String kitchenPage() {

		return "client/kitchen";
	}

	@RequestMapping(value = "/contacts")
	public String contactPage() {

		return "contact";
	}

	@RequestMapping(value = "/idminPage")
	public String adminPage() {

		return "client/adminPage";
	}

	@RequestMapping(value = "/pizzaAll")
	public String pizzaAllPage(ModelMap model) {
		List<Product> products = productService.getAllProduct();
		List<Product> pizzaList = new ArrayList<Product>();
		for (Product product : products) {
			if (product.getType().getName().equalsIgnoreCase("pizza")) {
				pizzaList.add(product);
			}
		}

		model.addAttribute("allPizza", pizzaList);

		return "client/pizzaAll";
	}

	@RequestMapping(value = "pizzaAll/{pizzaId}", method = RequestMethod.POST)
	public String addPizza(@PathVariable String pizzaId, @RequestParam(value = "count") String countPizza,
			HttpServletRequest req, HttpSession session) {

		session = req.getSession(true);
		int idPizza = Integer.parseInt(pizzaId);
		int count = Integer.parseInt(countPizza);

		List<Cart> cart = (List<Cart>) session.getAttribute("cart");

		if (cart == null) {
			cart = new ArrayList<Cart>();
			cart.add(new Cart(productService.findById(idPizza), count, (cart.size() + 1)));
			session.setAttribute("cart", cart);
		} else {

			cart.add(new Cart(productService.findById(idPizza), count, (cart.size() + 1)));
		}

		return "redirect:/pizzaAll";

	}

	@RequestMapping(value = "/cart")
	public String cartPage(Model model, HttpSession session) {
		try {
			List<Cart> cart = (List<Cart>) session.getAttribute("cart");
			int total = 0;
			for (Cart cart2 : cart) {
				total += cart2.getTotalPrice();
			}
			model.addAttribute("cart", cart);
			model.addAttribute("total", total);
			if (cart.isEmpty()) {
				String str = "Ви не обрали жодного товару!!!";
				model.addAttribute("total", total);
				model.addAttribute("cartNull", str);
			}
			return "client/cart";
		} catch (NullPointerException e) {
			String str = "Ви не обрали жодного товару!!!";
			int total = 0;
			model.addAttribute("total", total);
			model.addAttribute("cartNull", str);
			return "client/cart";
		}

	}

	@RequestMapping(value = "deleteCart/{idTemp}", method = RequestMethod.GET)
	public String deleteCart(@PathVariable String idTemp, HttpSession session) {

		int id = Integer.parseInt(idTemp);
		List<Cart> cartss = (List<Cart>) session.getAttribute("cart");

		Iterator<Cart> iter = cartss.iterator();

		while (iter.hasNext()) {
			Cart c = iter.next();
			if (c.getIdTemp() == id) {
				iter.remove();
			}
		}

		session.setAttribute("cart", cartss);

		return "redirect:/cart";

	}

	@RequestMapping(value = "/orderNew", method = RequestMethod.POST)
	public String newOrder(HttpSession session) {
		List<Cart> cartss = (List<Cart>) session.getAttribute("cart");
		int total = 0;
		try{
		for (Cart cart2 : cartss) {
			total += cart2.getTotalPrice();
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User user = users.findByName(username);

		List<Ordering> listOrder = orderService.getAllOrder();

		String numberOrder = user.getIdUser() + "-" + listOrder.size();

		orderService.createOrder(user, total, numberOrder);

		Ordering order = orderService.findByNumberOrder(numberOrder);
		for (Cart cart2 : cartss) {
			cartService.createCart(order, cart2.getProd(), cart2.getCount());
		}

		session.removeAttribute("cart");

		return "redirect:/menuClients";
		}
		catch(NullPointerException e) {
			return "redirect:/cart?newCarts=error";
		}

	}

	@RequestMapping(value = "/kitchenList")
	public String kitchenList() {
		return "kitchen/kitchenList";

	}

	@RequestMapping(value = "/kitchenListWait")
	public String kitchenListWait(Model model) {

		List<Ordering> orders = orderService.getAllOrder();
		List<Ordering> orderWait = new LinkedList<Ordering>();

		for (Ordering ordering : orders) {
			if (ordering.getStatus().equals("waiting")) {
				orderWait.add(ordering);
			}
		}

		model.addAttribute("orders", orderWait);

		return "kitchen/kitchenListWait";
	}

	@RequestMapping(value = "/kitchenListDone")
	public String kitchenListDone(Model model) {

		List<Ordering> orders = orderService.getAllOrder();
		List<Ordering> orderWait = new LinkedList<Ordering>();

		for (Ordering ordering : orders) {
			if (ordering.getStatus().equals("done")) {
				orderWait.add(ordering);
			}
		}

		model.addAttribute("orders", orderWait);

		return "kitchen/kitchenListDone";
	}

	@RequestMapping(value = "/kitchenOrder/{orderidOrder}")
	public String getKitchenOrder(@PathVariable String orderidOrder, Model model) {
		int idOrder = Integer.parseInt(orderidOrder);
		Ordering order = orderService.findById(idOrder);

		List<Cart> ordersKitchen = cartService.getAllCart();
		List<Cart> orderCart = new LinkedList<Cart>();
		String number = order.getNumberOrder();
		for (Cart cart : ordersKitchen) {
			if (cart.getOrder().getIdOrder() == order.getIdOrder()) {
				orderCart.add(cart);
			}
		}

		model.addAttribute("orderCart", orderCart);
		model.addAttribute("numberOrder", number);

		return "kitchen/kitchenOrder";
	}

	@RequestMapping(value = "confirm/{numberOrder}")
	public String confirmOrder(@PathVariable String numberOrder) {

		Ordering order = orderService.findByNumberOrder(numberOrder);

		if (order.getStatus().equals("done")) {
			return "redirect:/kitchenListDone";
		} else {
			orderService.updateStatus(order.getIdOrder());

			return "redirect:/kitchenList";
		}
	}
	
	@RequestMapping(value = "/contact")
	public String contact() {
		return "client/contact";

	}
	
	

}
