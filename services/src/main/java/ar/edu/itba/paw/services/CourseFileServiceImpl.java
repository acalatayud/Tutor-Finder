package ar.edu.itba.paw.services;

import ar.edu.itba.paw.exceptions.UserAuthenticationException;
import ar.edu.itba.paw.interfaces.persistence.CourseFileDao;
import ar.edu.itba.paw.interfaces.service.ClassReservationService;
import ar.edu.itba.paw.interfaces.service.CourseFileService;
import ar.edu.itba.paw.models.Course;
import ar.edu.itba.paw.models.CourseFile;
import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CourseFileServiceImpl implements CourseFileService {

    @Autowired
    CourseFileDao cfd;

    @Autowired
    ClassReservationService crs;


    @Override
    public List<CourseFile> findForCourse(Course course) {
        return cfd.findForCourse(course);
    }

    @Override
    public CourseFile findByIdForUser(long id, User user) throws UserAuthenticationException {
        CourseFile courseFile = cfd.findById(id);
        if(!canReadFile(courseFile,user)){
            throw new UserAuthenticationException();
        }
        return courseFile;
    }

    @Override
    public void save(CourseFile document) {
        cfd.save(document);
    }

    @Override
    public void deleteById(long id) {
        cfd.deleteById(id);
    }

    private boolean canReadFile(CourseFile courseFile, User user){
        if(crs.hasAcceptedReservation(user, courseFile.getCourse()) || courseFile.getCourse().getProfessor().getId().compareTo(user.getId()) == 0)
            return true;
        return false;
    }

}
