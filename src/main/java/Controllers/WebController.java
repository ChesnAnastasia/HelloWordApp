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
        String author = "Chesnovskaya Anastasia";
        model.addAttribute("author", author);
        return "index";
    }

    @RequestMapping(value = "/dateCounting",method = RequestMethod.GET)
    public String dateAndAgeCounting(ModelMap model, @RequestParam(value="date") String strDate){
        final String BIRTHDAY = "birthday";
        final String BERROR = "Invalid format of input date";
        //final String DATE_MSG_FMT = "age is %d years, %d days to next bithday";
        //Date currentTime=new Date();
        //String author = "Gleb Mashkanov";
        //model.addAttribute("author", author);
        //model.addAttribute("time", currentTime);
        //model.addAttribute("version", buildVersion);
        DateCount d = new DateCount(strDate);
        String daysToBirthAndYearsOld = d.daysToBirthAndYearsOld();
        if (daysToBirthAndYearsOld == null) {
            model.addAttribute(BIRTHDAY,BERROR);
        } else {
            model.addAttribute(BIRTHDAY, daysToBirthAndYearsOld);
        }
        return "index";
    }
}
