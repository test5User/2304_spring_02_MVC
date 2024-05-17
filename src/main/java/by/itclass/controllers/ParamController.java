package by.itclass.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {
    @GetMapping("/getParams")
    public String getParam() {
        return "main";
    }

    @GetMapping("/getParamsOld")
    public String getParamsOldApproach(HttpServletRequest request) {
        var strParam = request.getParameter("param1");
        var intParam = Integer.parseInt(request.getParameter("param2"));
        request.setAttribute("strParam", strParam);
        request.setAttribute("intParam", intParam);
        return "main";
    }

    @GetMapping("/getParamsSpring")
    public String getParamsSpringApproach(
            @RequestParam(name = "param1") String strParam,
            @RequestParam(name = "param2") int intParam,
            HttpServletRequest request) {
        request.setAttribute("strParam", strParam);
        request.setAttribute("intParam", intParam);
        return "main";
    }

    @GetMapping("/getParamsSpringNotRequired")
    public String getParamsSpringApproachNotRequired(
            @RequestParam(name = "param1", required = false) String strParam,
            @RequestParam(name = "param2") Integer intParam,
            HttpServletRequest request) {
        request.setAttribute("strParam", strParam);
        request.setAttribute("intParam", intParam);
        return "main";
    }

    @GetMapping("/getParamsSpringSessionStore")
    public String getParamsSpringSessionStore (
            @RequestParam(name = "param1") String strParam,
            @RequestParam(name = "param2") Integer intParam,
            HttpSession session) {
        session.setAttribute("strParam", strParam);
        session.setAttribute("intParam", intParam);
        return "main";
    }

    @GetMapping("/urlPart/{param1}/{param2}")
    public String getParamsAsPath(
            @PathVariable(name = "param1") String param1,
            @PathVariable(name = "param2") Integer param2,
            HttpServletRequest request) {
        request.setAttribute("strParam", param1);
        request.setAttribute("intParam", param2);
        return "main";
    }

    @GetMapping("/usingModel")
    public String getParamsUsingModel (
            @RequestParam(name = "param1") String strParam,
            @RequestParam(name = "param2") Integer intParam,
            Model model) {
        model.addAttribute("strParam", strParam);
        model.addAttribute("intParam", intParam);
        return "main";
    }

    @GetMapping("/usingModelAndView")
    public ModelAndView getParamsUsingModelAndView (
            @RequestParam(name = "param1") String strParam,
            @RequestParam(name = "param2") Integer intParam) {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("strParam", strParam);
        modelAndView.addObject("intParam", intParam);
        return modelAndView;
    }
}
