package Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class WebController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String view(ModelMap model){
        //String author = "Chesnovskaya Anastasia";
        //model.addAttribute("author", author);
        return "index";
    }

    @RequestMapping(value = "/dateCounting",method = RequestMethod.GET)
    public String dateAndAgeCounting(ModelMap model, @RequestParam(value="date") String strDate){
        DateCount d = new DateCount(strDate);
        String daysToBirthAndYearsOld = d.daysToBirthAndYearsOld();
        System.out.println(daysToBirthAndYearsOld);
        if (daysToBirthAndYearsOld == null) {
            model.addAttribute("daysToBirthAndYearsOld","Invalid format of input date");
        } else {
            model.addAttribute("daysToBirthAndYearsOld", daysToBirthAndYearsOld);
        }
        return "index";
    }
}
