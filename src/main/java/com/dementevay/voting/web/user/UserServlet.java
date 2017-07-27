package com.dementevay.voting.web.user;

import com.dementevay.voting.model.Restaurant;
import com.dementevay.voting.repository.RestaurantRepositoryImpl;
import com.dementevay.voting.service.RestaurantService;
import com.dementevay.voting.service.RestaurantServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
