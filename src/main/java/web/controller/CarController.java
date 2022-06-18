package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.DAO.CarDAO;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping()
    public String showCars(@RequestParam(value = "count", required = false, defaultValue = "0") Long count, Model model) {
        model.addAttribute("car", carDAO.showCars(count));
        return "cars";
    }
}
