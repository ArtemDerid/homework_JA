package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.domain.Subscription;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.MagazineService;
import ua.lviv.lgs.service.SubscriptionService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.MagazineServiceImpl;
import ua.lviv.lgs.service.impl.SubscriptionServiceImpl;
import ua.lviv.lgs.service.impl.UserServiceImpl;


@WebServlet("/subscription")
public class SubscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	private SubscriptionService subscriptionService = SubscriptionServiceImpl.getSubscriptionService();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String magazineId = request.getParameter("magazineId");
		Magazine magazine = magazineService.read(Integer.parseInt(magazineId));
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		User user = userService.read(userId);
		
		Subscription subscription = new Subscription();
		subscription.setMagazine(magazine);
		subscription.setUser(user);
		subscription.setReleaseDate(new Date());
		subscriptionService.create(subscription);
		
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subscriptionId = request.getParameter("subscriptionId");
		subscriptionService.delete(Integer.parseInt(subscriptionId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}


}
