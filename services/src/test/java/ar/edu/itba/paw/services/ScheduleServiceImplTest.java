package ar.edu.itba.paw.services;

import ar.edu.itba.paw.exceptions.InvalidTimeException;
import ar.edu.itba.paw.exceptions.InvalidTimeRangeException;
import ar.edu.itba.paw.interfaces.persistence.ScheduleDao;
import ar.edu.itba.paw.interfaces.service.CourseService;
import ar.edu.itba.paw.interfaces.service.ProfessorService;
import ar.edu.itba.paw.interfaces.service.ScheduleService;
import ar.edu.itba.paw.models.Professor;
import ar.edu.itba.paw.models.Timeslot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ScheduleServiceImplTest {

    @InjectMocks
    @Autowired
    private ScheduleService scheduleService;

    @Mock
    private ScheduleDao scheduleDao;

    @Mock
    private ProfessorService ps;

    Long PROFESSOR_ID = 2l;

    @Before
    public void setUp(){
        Professor professor = mock(Professor.class);
        when(professor.getId()).thenReturn(2l);
        when(scheduleDao.reserveTimeSlot(professor,1, 12)).thenReturn( new Timeslot(1,12));
        when(scheduleDao.reserveTimeSlot(professor,1, 14)).thenReturn( new Timeslot(1,14));
        when(scheduleDao.reserveTimeSlot(professor,1, 15)).thenReturn( new Timeslot(1,15));
        when(scheduleDao.reserveTimeSlot(professor,1, 16)).thenReturn( new Timeslot(1,16));
        when(scheduleDao.reserveTimeSlot(professor,1, -3)).thenReturn( new Timeslot(1,-3));
        when(scheduleDao.reserveTimeSlot(professor,1, 27)).thenReturn( new Timeslot(1,27));
        when(ps.findById(2l)).thenReturn(
                new Professor(2l, "username", "Carlos", "Ramos", "pasword",
                        "carlitos@gmail.com", "test description"
                )
        );
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testValidRange() throws InvalidTimeRangeException, InvalidTimeException {
        Integer DAY = 1;
        Integer START_HOUR = 14;
        Integer END_HOUR = 16;
        List<Timeslot> timeslots = scheduleService.reserveTimeSlot(PROFESSOR_ID, DAY, START_HOUR, END_HOUR);
        assertEquals(2, timeslots.size());
    }

    @Test
    public void testUnitaryRange() throws InvalidTimeRangeException, InvalidTimeException {
        Integer DAY = 1;
        Integer START_HOUR = 14;
        Integer END_HOUR = 15;

        List<Timeslot> timeslots = scheduleService.reserveTimeSlot(PROFESSOR_ID, DAY, START_HOUR, END_HOUR);

        assertEquals(1, timeslots.size());
        Timeslot timeslot = timeslots.iterator().next();

        //The timeslot hour is the start hour and timeslots are all one hr long
        assertEquals(START_HOUR, timeslot.getHour());
        assertEquals(DAY, timeslot.getDay());
    }

    @Test(expected = InvalidTimeRangeException.class)
    public void testInvalidRange() throws InvalidTimeRangeException, InvalidTimeException {
        Integer DAY = 1;
        Integer START_HOUR = 14;
        Integer END_HOUR = 12;

        List<Timeslot> timeslots = scheduleService.reserveTimeSlot(PROFESSOR_ID, DAY, START_HOUR, END_HOUR);
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidHourUpper() throws InvalidTimeRangeException, InvalidTimeException {
        Integer DAY = 1;
        Integer START_HOUR = -3;
        Integer END_HOUR = 12;

        List<Timeslot> timeslots = scheduleService.reserveTimeSlot(PROFESSOR_ID, DAY, START_HOUR, END_HOUR);
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidHourLower() throws InvalidTimeRangeException, InvalidTimeException {
        Integer DAY = 1;
        Integer START_HOUR = 14;
        Integer END_HOUR = 27;

        List<Timeslot> timeslots = scheduleService.reserveTimeSlot(PROFESSOR_ID, DAY, START_HOUR, END_HOUR);
    }


    @Test(expected = InvalidTimeException.class)
    public void testInvalidDayUpper() throws InvalidTimeRangeException, InvalidTimeException {
        Integer DAY = 8;
        Integer START_HOUR = 14;
        Integer END_HOUR = 12;

        List<Timeslot> timeslots = scheduleService.reserveTimeSlot(PROFESSOR_ID, DAY, START_HOUR, END_HOUR);
    }

    @Test(expected = InvalidTimeException.class)
    public void testInvalidDayLower() throws InvalidTimeRangeException, InvalidTimeException {
        Integer DAY = -4;
        Integer START_HOUR = 14;
        Integer END_HOUR = 12;
        List<Timeslot> timeslots = scheduleService.reserveTimeSlot(PROFESSOR_ID, DAY, START_HOUR, END_HOUR);

    }
}