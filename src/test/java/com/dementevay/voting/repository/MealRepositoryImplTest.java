package com.dementevay.voting.repository;

import com.dementevay.voting.model.Meal;
import com.dementevay.voting.util.TimeUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Andrey Dementev on 01.08.17.
 */
public class MealRepositoryImplTest extends AbstractTest{

    @Test
    public void getForRestaurantByDay() throws Exception {
        List<Meal> meals = mealRepository.getForRestaurantByDay(100005, TimeUtil.stringToLocalDateTime("2017-07-26 10:00:00"));
        List<Meal> m = meals;
//        assertArrayEquals();
    }

}