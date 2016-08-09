package ua.gnatyuk.sweethome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yroslav on 8/4/16.
 */
@Controller
public class IndexPagesController {
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }
}
