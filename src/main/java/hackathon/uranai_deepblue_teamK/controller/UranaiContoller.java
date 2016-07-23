package hackathon.uranai_deepblue_teamK.controller;

import hackathon.uranai_deepblue_teamK.form.InputForm;
import hackathon.uranai_deepblue_teamK.service.UranaiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by rkuser on 2016/07/23.
 */
@Controller
public class UranaiContoller {
	
	@Autowired
	private UranaiService uranaiService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get(){
        return "input.jsp";
    }

    @RequestMapping(value = "/uranau", method = RequestMethod.POST)
    public String uranau(@ModelAttribute("Uranai") InputForm inputForm, BindingResult bindingResult){
    	String imgPath = uranaiService.uranai(inputForm.getName(), inputForm.getBirth().toString());
        return "output.jsp";
    }

}
