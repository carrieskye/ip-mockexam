package be.ucll.exam.web.controller;

import be.ucll.exam.domain.Country;
import be.ucll.exam.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/country")
public class CountryController {
    private final TourismService service;

    public CountryController(@Autowired TourismService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCountries() {
        return new ModelAndView("country-overview", "countries", service.getCountries());
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNewForm() {
        return new ModelAndView("country-form", "country", new Country());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid Country country, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("country-form", "country", country);
        } else {
            if (country.getId() == 0) {
                service.addCountry(country);
            } else {
                service.updateCountry(country);
            }
            return new ModelAndView("redirect:/country.htm");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable long id) {
        return new ModelAndView("country-form", "country", service.getCountry(id));
    }

    @RequestMapping(value = "/remove{id}", method = RequestMethod.POST)
    public ModelAndView remove(@PathVariable long id) {
        service.removeCountry(id);
        return new ModelAndView("redirect:/country.htm");
    }
}
