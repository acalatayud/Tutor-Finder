'use strict';
define([], function() {

	return {
		SEARCH: 'Buscar...',
		PROFESSOR: 'Profesor',
		COURSE: 'Curso',
		AREA: 'Área',
		SEARCH_CATEGORY: 'Seleccione una categoría',
		REGISTER: 'Registrarse',
		LOGIN: 'Iniciar sesión',
		USERNAME: 'Usuario:',
		PASSWORD: 'Contraseña:',
		REPEAT_PASSWORD: 'Repetir contraseña:',
		REMEMBER_ME: 'Recordarme',
		LOGIN_ERROR: 'La combinación usuario contraseña es incorrecta.',
		FORGOT_PASSWORD: 'Olvido su contraseña',
		PROFILE: 'Perfil',
		CLASS_REQUESTS: 'Pedidos de clases',
		REGISTER_PROFESSOR: 'Registrarse como profesor',
		RESERVATIONS: 'Mis Reservas',
		CONVERSATIONS: 'Conversaciones',
		LOGOUT: 'Cerrar Sesión',
		CONTACT: 'Contactar',
 		COMMENT: 'Comentar',
		COMMENT_TITLE: 'Comentarios',
		SENT_TIME: 'Enviado: {{date | date: "dd/MM/yy hh:mm:ss"}}',
		SEND: 'Enviar',
		BODY: 'Mensaje:',
		APP_NAME: 'Tu Teoria',
		COMMENT_BODY: 'Comentario:',
		RATING: 'Puntaje:',
		MODIFY_PROFESSOR: 'Modifica tu perfil',
		PROFILE_COURSES: 'Tus Clases',
		PROFILE_COURSES_DESCRIPTION: 'Esta es la lista de clases que usted da',
		PROFESSOR_COURSES: 'Clases del profesor', 
		PROFESSOR_COURSES_DESCRIPTION: 'Aquí puede ver las clases dictadas por el profesor.',
		ADD_COURSE: 'Agregar Clase',
		DELETE_COURSE: 'Eliminar Clase',
		FILES: 'Ver Material',
		MODIFY_COURSE: 'Modificar Curso',
		NO_COURSES: 'El profesor no dicta ningun curso',
		SUBJECT: 'Materia:',
		SELECT_SUBJECT: 'Seleccione una materia',
		DESCRIPTION: 'Descripción: ',
		PRICE: 'Precio por hora:',
		MODIFY: 'Modificar',
		CREATE: 'Crear',
		MODIFY_DESCRIPTION: 'Modifica tu descripción',
		MODIFY_PICTURE: 'Sube una nueva foto de perfil',
		REGISTER_PICTURE: 'Foto de perfil:',
		RESTORE_PASSWORD: 'Restaurar contraseña',
		EMAIL: 'Correo:',
		FORGOT_PASSWORD_SENT: 'Se envió un correo electrónico a su cuenta, siga los pasos para restaurar su contraseña',
		NAME: 'Nombre:',
		LASTNAME: 'Apellido:',
		NO_RESERVATIONS: 'No tiene reservas',
		RESERVATION_DAY: 'Día {{date | date: "dd/MM/yy"}}',
		RESERVATION_FROM: 'Horario: {{date | date: "hh:mm"}}',
		RESERVATION_TO: '-{{date | date: "hh:mm"}}',
		PENDING: 'Pendiente',
		DENIED: 'Rechazada',
		APPROVED: 'Aceptada',
		REQUESTS: 'Tus pedidos de clases',
		NO_REQUESTS: 'No tiene pedidos de clases',
		DENY: 'Rechazar',
		APPROVE: 'Aceptar',
		RESERVATION_PROFESSOR: 'Profesor: {{name}}',
		REQUEST_STUDENT: 'Alumno: {{name}}',
		PRICE_SPEC: '$ {{price}} /hr',

		CONTACT_SUCCESS: '¡El mensaje fue enviado!',
		FORBIDDEN_COMMENT: 'No puede comentar en una clase a la que no asistió',

		MESSAGE_SIZE_ERROR: 'El mensaje debe tener entre {{min}} y {{max}} caracteres',
		DESCRIPTION_SIZE_ERROR: 'La descripción debe tener entre {{min}} y {{max}} caracteres',
		COMMENT_SIZE_ERROR: 'El comentario debe tener entre {{min}} y {{max}} caracteres',
		RATING_ERROR: 'El rating debe estar entre entre {{min}} y {{max}}',
		PRICE_ERROR: 'El precio debe ser mayor que {{min}}',
		SUBJECT_ERROR: 'Debe seleccionar una materia',
		PICTURE_ERROR: 'Debe subir una foto de perfil con un tamaño máximo de {{size}}',
		EMAIL_FORMAT_ERROR: 'La direccion de correo electronica debe ser valida',
		EMAIL_SIZE_ERROR: 'La dirección de correo electrónico debe tener entre {{min}} y {{max}} caracteres',
		FORGOT_PASSWORD_ERROR: 'El correo electrónico no se encuentra registrado',
		PASSWORD_SIZE_ERROR: 'La contraseña debe tener entre {{min}} y {{max}} caracteres',
		REPEAT_PASSWORD_ERROR: 'Las contraseñas deben coincidir',
		INVALID_TOKEN: 'El token para restaurar la contraseña es inválido.',
		PASSWORD_RESTORE_ERROR: 'Ocurrió un error al restaurar la contraseña',
		NAME_SIZE_ERROR: 'El nombre debe tener entre {{min}} y {{max}} caracteres',
		LASTNAME_SIZE_ERROR: 'El apellido debe tener entre {{min}} y {{max}} caracteres',
		USERNAME_SIZE_ERROR: 'El usuario debe tener entre {{min}} y {{max}} caracteres',
		NAME_PATTERN_ERROR: 'El nombre debe contener unicamente caracteres alfabeticos',
		LASTNAME_PATTERN_ERROR: 'El apellido debe contener unicamente caracteres alfabeticos'
	};
});
