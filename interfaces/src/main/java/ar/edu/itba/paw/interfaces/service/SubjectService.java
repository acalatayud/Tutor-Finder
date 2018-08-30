package ar.edu.itba.paw.interfaces.service;

import ar.edu.itba.paw.models.Subject;

import java.util.List;

public interface SubjectService {
    Subject findSubjectById(final long id);

    Subject create(final String name, final String description);

    List<Subject> filterSubjectsByName(String name);
}
