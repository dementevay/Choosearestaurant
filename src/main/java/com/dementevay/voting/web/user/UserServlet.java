package com.dementevay.voting.web.user;

import com.dementevay.voting.repository.restaurant.RestaurantRepositoryImpl;
import com.dementevay.voting.service.restaurants.RestaurantService;
import com.dementevay.voting.service.restaurants.RestaurantServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Andrey Dementev on 24.07.17.
 */
public class UserServlet extends HttpServlet {
    //private static final Logger log = LoggerFactory.getLogger(UserServlet.class);


    private RestaurantService service = new RestaurantServiceImpl(new RestaurantRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
       // List<Restaurant> rests = service.getSS();
        //System.out.println("aa");
        req.getRequestDispatcher("/jsp/vote.jsp").forward(req, resp);
    }
}
