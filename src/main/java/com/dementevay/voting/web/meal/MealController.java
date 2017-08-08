package com.dementevay.voting.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * Created by Andrey Dementev on 27.07.17.
 */
@Controller
public class MealController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    /*private final MealService service;

    @Autowired
    public MealController(MealService service) {
        this.service = service;
    }

    @GetMapping("/meal")
    public Meal getMeal (int id) {
        return service.get(id);
    }*/
}
