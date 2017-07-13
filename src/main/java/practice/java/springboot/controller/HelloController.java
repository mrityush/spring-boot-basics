package practice.java.springboot.controller;

/**
 * Created by ttn on 10/7/17.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to
 * handle web requests. @RequestMapping maps / to the index() method. When invoked from a
 * browser or using curl on the command line, the method returns pure text. That’s because
 * @RestController combines @Controller and @ResponseBody, two annotations that results in
 * web requests returning data rather than a view.
 */
@Controller
public class HelloController {

    @Value("${sample.value}")
    private String environmentValue;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/getEnvironment", method = RequestMethod.GET)
    private String getEnvironmentValue(HttpServletRequest request, HttpServletResponse httpServletResponse, Model model){
        model.addAttribute("environment", environmentValue);
        return "environmentPage";
    }

}