package hackathon.uranai_deepblue_teamK.controller;

import hackathon.uranai_deepblue_teamK.form.InputForm;
import hackathon.uranai_deepblue_teamK.service.ResultCreater;
import hackathon.uranai_deepblue_teamK.service.UranaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * Created by rkuser on 2016/07/23.
 */
@Controller
public class UranaiContoller {
	
	@Autowired
	private UranaiService uranaiService;

    @Autowired
    private ResultCreater resultCreater;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get(){
        return "input";
    }

    @RequestMapping(value = "/uranau", method = RequestMethod.GET)
    public String uranau(@ModelAttribute("Uranai") InputForm inputForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors())
            System.out.println("error" + bindingResult.getObjectName());
        LocalDateTime dateTime = LocalDateTime.now();
        int result = uranaiService.uranai(inputForm.getName(), convertDate(inputForm.getBirth()), dateTime);
        model.addAttribute("img", resultCreater.createImagePath(result));
        model.addAttribute("starList", resultCreater.createStarResult(result, dateTime));
        return "output";
    }

    private String convertDate(Date date) {
        return new SimpleDateFormat("yyyyMMdd").format(date.getTime());
    }

}
