package com.controller;

import com.entity.EmpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @author cj
 * @date 2019/11/13
 */

@Controller
public class ValidationController {

    @RequestMapping("/insert")
    public ModelAndView insert(@Valid EmpEntity empEntity, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();

        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error:errors){
                mav.addObject(error.getField(),error.getDefaultMessage() );
            }
            mav.setViewName("error");

        }else{
            mav.setViewName("ok");
        }
        System.out.println("-----debug: empEntity = " + empEntity);

        return mav;
    }
}
