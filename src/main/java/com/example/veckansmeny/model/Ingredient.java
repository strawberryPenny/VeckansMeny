package com.example.veckansmeny.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "ingredients")
    List<Dish> dishes;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        if (dishes == null) {
            dishes = new ArrayList<>();
        }
        return dishes;
    }

    public void addDish(Dish dish) {
        getDishes().add(dish);
        dish.getIngredients().add(this);
    }

    public void removeDish(Dish dish) {
        getDishes().remove(dish);
        dish.getIngredients().remove(this);
    }

    public void removeIngredientFromDishes(){
        for(Dish dish : dishes){
            dish.getIngredients().remove(this);
        }
    }

    @Override
    public String toString() {
        return name.trim();
    }
}
