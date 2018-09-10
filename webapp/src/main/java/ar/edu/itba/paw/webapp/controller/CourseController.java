package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.interfaces.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CourseController {

    @Autowired
    @Qualifier("courseServiceImpl")
    private CourseService cs;


    @RequestMapping("/Course")
    public ModelAndView course(
            @RequestParam(value="professor", required=true) final Long professor_id,
            @RequestParam(value="subject", required=true) final Long subject_id
    ){
        final ModelAndView mav = new ModelAndView("course");
        mav.addObject("course", cs.findCourseByIds(professor_id, subject_id));
        return mav;
    }
}
