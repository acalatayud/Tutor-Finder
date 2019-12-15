'use strict';
define([], function() {

	return {
    SEARCH: 'Search...',
    PROFESSOR: 'Professor',
    COURSE: 'Course',
    AREA: 'Area',
    HOME: 'Home',
    SEARCH_CATEGORY: 'Choose a category',
    REGISTER: 'Register',
    LOGIN: 'Login',
    USERNAME: 'Username:',
    PASSWORD: 'Password:',
    REPEAT_PASSWORD: 'Repeat password:',
    REMEMBER_ME: 'Remember me',
    LOGIN_ERROR: 'The username and/or password are incorrect.',
    FORGOT_PASSWORD: 'Forgot password',
    PROFILE: 'Profile',
    CLASS_REQUESTS: 'Class requests',
    REGISTER_PROFESSOR: 'Register as professor',
    RESERVATIONS: 'My reservations',
    CONVERSATIONS: 'Conversations',
    LOGOUT: 'Logout',
    CONTACT: 'Contact',
    COMMENT: 'Comment',
    COMMENT_TITLE: 'Comments',
    SENT_TIME: 'Sent: {{date | date: "dd/MM/yy hh:mm"}}',
    SEND: 'Send',
    BODY: 'Message:',
    APP_NAME: 'Tu Teoria',
    COMMENT_BODY: 'Comment:',
    RATING: 'Rating:',
    MODIFY_PROFESSOR: 'Modify profile',
    PROFILE_COURSES: 'Your Classes',
    PROFILE_COURSES_DESCRIPTION: 'These are the classes you offer',
    PROFESSOR_COURSES: 'Professor courses',
    PROFESSOR_COURSES_DESCRIPTION: 'These are the classes the professor offers.',
    ADD_COURSE: 'Add Course',
    DELETE_COURSE: 'Delete Course',
    FILES: 'See Material',
    MODIFY_COURSE: 'Modify Course',
    NO_COURSES: 'The professor does not offer any course right now',
    SUBJECT: 'Subject:',
    SELECT_SUBJECT: 'Select a subject',
    DESCRIPTION: 'Description: {{value}}',
    PRICE: 'Price by the hour:',
    MODIFY: 'Modify',
    CREATE: 'Create',
    MODIFY_DESCRIPTION: 'Modify your description',
    MODIFY_PICTURE: 'Upload a profile photo',
    REGISTER_PICTURE: 'Profile photo:',
    RESTORE_PASSWORD: 'Restore password',
    EMAIL: 'Email:',
    FORGOT_PASSWORD_SENT: 'An email was sent to you, please follow the steps to restore your password',
    NAME: 'Name:',
    LASTNAME: 'Surname:',
    NO_RESERVATIONS: 'You have no reservations',
    RESERVATION_DAY: 'Day {{date | date: "dd/MM/yy"}}',
    RESERVATION_FROM: 'Time: {{date | date: "hh:mm"}}',
    RESERVATION_TO: '-{{date | date: "hh:mm"}}',
    PENDING: 'Pending',
    DENIED: 'Denied',
    APPROVED: 'Accepted',
    REQUESTS: 'Your class requests',
    NO_REQUESTS: 'You have no class requests',
    DENY: 'Deny',
    APPROVE: 'Approve',
    RESERVATION_PROFESSOR: 'Professor: {{name}}',
    REQUEST_STUDENT: 'Student: {{name}}',
    PRICE_SPEC: '$ {{price}} /hr',
    CONVERSATION: 'Conversation',
    NO_CONVERSATIONS: 'You have no active conversations',
    CONVERSATIONS_HELP: 'To start a new conversation, search for a course and get in contact with the professor',
    INBOX: 'Inbox',
    LAST_MESSAGE: 'Last message: {{date | date: "dd/MM/yy hh:mm"}}',
    CONTENTS: 'Class contents',
    NO_CONTENTS: 'The class currently has no content',
    DOWNLOAD: 'Download',
    DELETE: 'Delete',
    FILE_UPLOAD: 'File upload',
    FILE_SELECT: 'File select',
    UPLOAD: 'Upload',
    RATING_SPEC: 'Rating: {{rating}}/5',
    SEARCH_MESSAGE: 'You searched for: {{term}}',
    AREA_SEARCH: 'Courses from {{area}}',
    NO_RESULTS: 'No results',
    RESERVE_CLASS: 'Reserve class',
    RESERVE: 'Reserve',
    SELECT_DAY: 'Select day:',
    SELECT_HOUR: 'Select time range:',
    FUTURE_DATE: 'Reservation must be done for a future date.',
    NOT_AVAILABLE_DAY: 'Professor is not available that day',
    VALID_DATE: 'Date chosen is invalid',
    FROM: 'From',
    UNTIL: 'To',
    SCHEDULE: 'Professor schedule',
    SCHEDULE_DESCRIPTION: 'These are the times the professor is available to teach.',
    PROFILE_SCHEDULE: 'Your Schedule',
    PROFILE_SCHEDULE_DESCRIPTION: 'This is your schedule, this is how your students will see it',
    SCHEDULE_EMPTY: 'Professor\'s schedule is empty.',
    COURSE_FILES: 'Course files',
    SEARCH_RESULTS: 'Search results',
    FILTER_TIME: 'Filter by day of the week and time',
    FILTER_MAX: 'Maximum',
    FILTER_MIN: 'Minimum',
    FILTER_PRICE: 'Filter by price',
    FILTER_DAY: 'Filter by day',
    FILTER_HOUR: 'Filter by hour',
    FILTER: 'Filter',
    MONDAY: 'Monday',
    TUESDAY: 'Tuesday',
    WEDNESDAY: 'Wednesday',
    THURSDAY: 'Thursday',
    FRIDAY: 'Friday',
    SATURDAY: 'Saturday',
    SUNDAY: 'Sunday',
    DAYS: 'Days',
    DAY: 'Day',
    INVALID_PARAMETERS: 'Attempt to access page with invalid parameters',
    SESSION_EXPIRED: 'Session expired, please login',
    ADD_TIMESLOT: 'Add timeslot',
    DELETE_TIMESLOT: 'Delete timeslot',
    SAME_USER_RESERVATION: 'Same user reservation is not allowed',
    REPEATED_USERNAME: 'Username already exists',
    REPEATED_EMAIL: 'Email belongs to an existing account',

    CONTACT_SUCCESS: 'Message sent!',
    RESERVE_SUCCESS: 'Successful reservation',
    FORBIDDEN_COMMENT: 'You need to assist the class to comment',
    DELETE_HELP: 'Timeslots inside the range will be deleted',
    MESSAGE_SIZE_ERROR: 'Message must be between {{min}} and {{max}} characters',
    DESCRIPTION_SIZE_ERROR: 'Description must be between {{min}} and {{max}} characters',
    COMMENT_SIZE_ERROR: 'Comment must be between {{min}} and {{max}} characters',
    RATING_ERROR: 'Rating must be between {{min}} and {{max}}',
    PRICE_ERROR: 'Price must be higher than {{min}}',
    SUBJECT_ERROR: 'You must first select a course',
    PICTURE_ERROR: 'You must upload a picture with a maximum size of {{size}}',
    EMAIL_FORMAT_ERROR: 'Email address must be valid',
    EMAIL_SIZE_ERROR: 'Email address must be between {{min}} and {{max}} characters',
    FORGOT_PASSWORD_ERROR: 'Email does not belong to an existing user',
    PASSWORD_SIZE_ERROR: 'Password must be between {{min}} and {{max}} characters',
    REPEAT_PASSWORD_ERROR: 'Passwords must match',
    INVALID_TOKEN: 'The token to restore the password is invalid.',
    PASSWORD_RESTORE_ERROR: 'An error ocurred while trying to retrieve the password',
    NAME_SIZE_ERROR: 'Name must be between {{min}} and {{max}} characters',
    LASTNAME_SIZE_ERROR: 'Surname must be between {{min}} and {{max}} characters',
    USERNAME_SIZE_ERROR: 'Username must be between {{min}} and {{max}} characters',
    NAME_PATTERN_ERROR: 'Name can only contain letters',
    LASTNAME_PATTERN_ERROR: 'Surname can only contain letters',
    FILE_ERROR: 'You must upload a file with a maximum size of {{size}}',
    PICTURE_TYPE_ERROR: 'File should be a png or jpg',
    START_ERROR: 'You must select a start time',
    END_ERROR: 'You must select an end time',
    FORBIDDEN_ERROR: 'You are not allowed to access this page',
    ERROR_OK: 'Ok',
    NO_CONNECTION: 'No connection',
    OOPS: 'Error, please try again',
    FORBIDDEN_CONVERSATION: 'You are not allowed to access this conversation',
    FORBIDDEN_COURSE_FILES: 'You are not allowed to access these course files',
    ERROR_SENDING_MESSGE: 'An error ocurred while sending the message',
    ERROR_COMMENTING: 'An error ocurred while leaving a comment',
    ERROR_APPROVING: 'An error ocurred while trying to approve the request',
    ERROR_DENYING: 'An error ocurred while trying to deny the request',
    ERROR_MODIFYING: 'An error ocurred while trying to modify your profile',
    ERROR_UPGRADING: 'An error ocurred while trying to register as professor',
    ERROR_RESERVING: 'An error ocurred while trying to reserve the course',
    ERROR_CREATING_COURSE: 'An error ocurred while trying to create the course',
    ERROR_MODIFYING_COURSE: 'An error ocurred while trying to modify the course',
    ERROR_DELETING_COURSE: 'An error ocurred while trying to delete the course',
    ERROR_DELETING_FILE: 'An error ocurred while trying to delete the file',
    ERROR_UPLOADING_FILE: 'An error ocurred while trying to upload the file',
    ERROR_DOWNLOADING_FILE: 'An error ocurred while trying to download the file',
    ERROR_ADDING_TIMESLOT: 'An error ocurred while trying to add a timeslot',
    ERROR_DELETING_TIMESLOT: 'An error ocurred while trying to delete a timeslot',
    ERROR_OOPS: 'Oops! An error ocurred!',
    ERROR_404: 'Error 404, the page you are trying to access does not exist',
    ERROR_403: 'Error 403, you are not allowed to access this page',
    ERROR_500: 'Error 500, we are having technical difficulties. Please wait',
    ERROR_TITLE: 'There has been an error :(',
    ERROR_MSG: 'The requested action could not be executed',
    TIMESLOT_DAY_ERROR: 'You must select a day',
    ADD_TIMESLOT_ERROR: 'The timeslot has already been selected',
    NOT_AVAILABLE_TIME: 'The professor is not available at that time',

    MONTHS: ['January', 'February', 'March', 'April', 'May', 'June',
      'July', 'August', 'September', 'October', 'November', 'December'],
    SHORT_MONTHS: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
      'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
    TRANSLATE_DAYS: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
    SHORT_DAYS: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
    DATE_FORMAT: function (date) {
      return moment(date).format('DD/MM/YYYY');
    },
    DATE_PARSE: function(dateString) {
      var m = moment(dateString, 'DD/MM/YYYY');
      return m.isValid() ? m.toDate() : new Date(NaN);
    }
	};
});
