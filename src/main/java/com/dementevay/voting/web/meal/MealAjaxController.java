package com.dementevay.voting.web.meal;

import com.dementevay.voting.AuthorizedUser;
import com.dementevay.voting.model.Meal;
import com.dementevay.voting.service.meal.MealService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.dementevay.voting.DateTimeForTests.localDate;

/**
 * Created by Andrey Dementev on 05.10.17.
 */
@RestController
@RequestMapping(value = "/ajax/meals")
public class MealAjaxController extends AbstractMealController {

    public MealAjaxController(MealService serviceMeal) {
        super(serviceMeal);
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Meal.class)
    public List<Meal> getAll() {
        return super.getAll();
    }

    @PostMapping(value = "/saveMeals")
    public void saveMeals(@RequestBody ArrayList<Meal> array) {
        array.forEach(m -> {
            m.setDate(localDate);
            serviceMeal.save(m, AuthorizedUser.id());
        });
    }

    @PostMapping("delete/{id}")
    public void deleteMeal(@PathVariable("id") int id) {
        super.delete(id);
    }

}