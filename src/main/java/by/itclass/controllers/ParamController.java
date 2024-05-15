package by.itclass.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam(name = "param1", required = false) String strParam,
            @RequestParam(name = "param2", required = false) Integer intParam,
            HttpSession session) {
        session.setAttribute("strParam", strParam);
        session.setAttribute("intParam", intParam);
        return "main";
    }
}
