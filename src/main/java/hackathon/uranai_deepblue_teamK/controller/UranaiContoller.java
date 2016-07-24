package hackathon.uranai_deepblue_teamK.controller;

import hackathon.uranai_deepblue_teamK.form.InputForm;
import hackathon.uranai_deepblue_teamK.service.UranaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by rkuser on 2016/07/23.
 */
@Controller
public class UranaiContoller {
	
	@Autowired
	private UranaiService uranaiService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get(){
        return "input";
    }

    @RequestMapping(value = "/uranau", method = RequestMethod.GET)
    public String uranau(@ModelAttribute("Uranai") InputForm inputForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors())
            System.out.println("error" + bindingResult.getObjectName());
        String imgPath = uranaiService.uranai(inputForm.getName(), convertDate(inputForm.getBirth()));
        model.addAttribute("img", imgPath);
        return "output";
    }

    private String convertDate(Date date) {
        return new SimpleDateFormat("yyyyMMdd").format(date.getTime());
    }

}
