package hackathon.uranai_deepblue_teamK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rkuser on 2016/07/23.
 */
@Controller
public class UranaiContoller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get(){
        return "input.jsp";
    }

}
