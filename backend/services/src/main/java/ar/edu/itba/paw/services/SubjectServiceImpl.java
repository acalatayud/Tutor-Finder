package ar.edu.itba.paw.services;

import ar.edu.itba.paw.interfaces.persistence.SubjectDao;
import ar.edu.itba.paw.interfaces.service.SubjectService;
import ar.edu.itba.paw.models.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectServiceImpl.class);


    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Subject findSubjectById(final long id) {
        LOGGER.debug("Searching for subject with id {}", id);
        return subjectDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Subject create(final String name, final String description, final Long area_id) {
        LOGGER.debug("Creating subject with name {} for area with id {}", name, area_id);
        return subjectDao.create(name,description, area_id);
    }

    @Override
    public List<Subject> filterSubjectsByName(final String name){
        LOGGER.debug("Searching for subjects with name containing {}", name);
        return subjectDao.filterSubjectsByName(name);
    }

    @Override
    public List<Subject> getAvailableSubjects(long id) {
        LOGGER.debug("Searching for subjects that are not already being taught by professor with id {}", id);
        return subjectDao.getAvailableSubjects(id);
    }

}
