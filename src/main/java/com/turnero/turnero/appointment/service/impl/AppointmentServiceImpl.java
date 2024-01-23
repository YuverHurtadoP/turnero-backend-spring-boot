package com.turnero.turnero.appointment.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.access.dao.IUserDao;
import com.turnero.turnero.appointment.dao.IAppointmentDao;
import com.turnero.turnero.appointment.dao.IShiftStatusDao;
import com.turnero.turnero.appointment.dao.ShiftClassificationDao;
import com.turnero.turnero.appointment.dto.request.AcceptAppointmentRequestDto;
import com.turnero.turnero.appointment.dto.request.AppointmentRequestDto;
import com.turnero.turnero.appointment.dto.response.AppointmentDetailResponseDto;
import com.turnero.turnero.appointment.dto.response.AppointmentResponseDto;
import com.turnero.turnero.appointment.entity.AppointmentRequestEntity;
import com.turnero.turnero.appointment.entity.ShiftClassificationEntity;
import com.turnero.turnero.appointment.entity.ShiftStatusEntity;
import com.turnero.turnero.appointment.service.IAppointmentService;
import com.turnero.turnero.exception.BadRequestException;
import com.turnero.turnero.exception.NotFoundException;
import com.turnero.turnero.person.dao.IPersonDao;
import com.turnero.turnero.person.dto.response.PersonResponseDto;
import com.turnero.turnero.person.entity.PersonEntity;
import com.turnero.turnero.person.service.IPersonService;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IAppointmentDao appointmentDao;
	
	@Autowired
	private IPersonService personService;
	
	@Autowired
	private IShiftStatusDao shiftStatusDao;
	
	@Autowired
	private ShiftClassificationDao shiftClassificationDao;
	
	@Autowired
	private  IUserDao  userDao;
	
	@Autowired
	private IPersonDao  personDao ;

	@Override
	public AppointmentResponseDto save(AppointmentRequestDto dto) {
		if (personService.findByPersonId(dto.getPatient()) == null)
			throw new  NotFoundException("El paciente no se encuentra en la base de datos");
	 
		if(!shiftClassificationDao.findByShiftClassificationId(dto.getShiftClassificationId()).isPresent())
			throw new  NotFoundException("La clasificación del turno no se encuentra en la base de datos");
		ShiftClassificationEntity shiftClassificationEntity = new ShiftClassificationEntity();
		shiftClassificationEntity.setShiftClassificationId(dto.getShiftClassificationId());
		
		ShiftStatusEntity shiftStatusEntity = new ShiftStatusEntity();
		shiftStatusEntity.setShiftStatusId(1);
		
		PersonEntity  personEntity  = new PersonEntity();
		
		personEntity.setPersonId(dto.getPatient());
		AppointmentRequestEntity entity = new AppointmentRequestEntity();
		entity.setAppointmentId(0);
		entity.setDeleted(false);
		entity.setShiftClassificationId(shiftClassificationEntity);
		entity.setShiftStatusId(shiftStatusEntity);
		entity.setPatient(personEntity);
		entity.setDateAppointment(null);
		 
		  appointmentDao.save(entity);
		
		return null;
	}

	@Override
	public String acceptAppointment(AcceptAppointmentRequestDto dto) {
		
		Optional<AppointmentRequestEntity> entity = appointmentDao.findByAppointmentId(dto.getAppointmentId());
		
		if(!entity.isPresent())
			throw new  NotFoundException("La cita  no se encuentra en la base de datos");
		if(personService.findByPersonId(dto.getPersonalMedicalId()) == null)
			throw new  NotFoundException("El personal medico no se encuentra  en la base de datos");
		if(entity.get().getPatient().getPersonId() == dto.getPersonalMedicalId())
			throw new  BadRequestException("La persona que solicita la cita no puede ser la misma encarga de atender la cita");
  
		appointmentDao.acceptAppointment(dto.getDateAppointment(), dto.getPersonalMedicalId(), dto.getAppointmentId());
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy HH:mm:ss", new Locale("es", "ES"));
	    String formattedDate = dateFormat.format(dto.getDateAppointment());
		return "La cita con ID "+dto.getAppointmentId()+" fue aceptada con éxito, la cual se llevará a cabo "+ formattedDate;
	}

	@Override
	public String changeStatusAppointment(Integer statusAppointment, Integer appointmentId) {
		Optional<ShiftStatusEntity> shiftStatus = shiftStatusDao.findByShiftStatusId(statusAppointment);
		Optional<AppointmentRequestEntity> entity = appointmentDao.findByAppointmentId(appointmentId);
		if(!entity.isPresent())
			throw new  NotFoundException("La cita  no se encuentra en la base de datos");
		if(!shiftStatus.isPresent())
			throw new  NotFoundException("Id de cambio de estado de la cita  no se encuentra en la base de datos");
		String statusName = shiftStatus.get().getDescription();
		appointmentDao.changeStatusAppointment(statusAppointment, appointmentId);
		return "La cita cambio al estado "+statusName;
	}

	@Override
	public List<AppointmentDetailResponseDto> findByPatientId(String nroDni) {
		Optional<PersonEntity> personEntity = personDao.findByNroDni(nroDni);
		
		
		if(!personEntity.isPresent())
			throw new  NotFoundException("El paciente no se encuentra en la base de datos");
		List<AppointmentRequestEntity> listAppointment = appointmentDao.findByPatientId(personEntity.get().getPersonId());
		
		List<AppointmentDetailResponseDto> listResponse = new ArrayList<>();
		AppointmentDetailResponseDto dto = null;
		for(AppointmentRequestEntity entity:listAppointment) {
			dto = new AppointmentDetailResponseDto();
			dto.setAppointmentId(entity.getAppointmentId());
			dto.setCreatedAp(entity.getCreatedAp());
			dto.setDateAppointment(entity.getDateAppointment());
			dto.setDeleted(entity.isDeleted());
			dto.setPatient(entity.getPatient().getPersonId());
			dto.setPersonalDoctor(entity.getPersonalDoctor());
			dto.setShiftClassificationDescription(entity.getShiftClassificationId().getDescription());
			dto.setShiftClassificationId(entity.getShiftClassificationId().getShiftClassificationId());
			dto.setShiftStatusDescription(entity.getShiftStatusId().getDescription());
			dto.setShiftStatusId(entity.getShiftStatusId().getShiftStatusId());
			dto.setUpdatedAp(entity.getUpdatedAp());
			try {
				Optional<PersonEntity> infoEntityPerson =personDao.findByPersonId(entity.getPersonalDoctor() );
				dto.setNamePersonalMedico(infoEntityPerson.get().getName()+ " "+infoEntityPerson.get().getLastName());
			}catch(Exception e) {
				
			}
			listResponse.add(dto);
			
			
		}
		
		return listResponse;
	}

	@Override
	public List<AppointmentDetailResponseDto> findByPersonalMedicoId(String nroDni) {
	Optional<PersonEntity> personEntity = personDao.findByNroDni(nroDni);
		
		
		if(!personEntity.isPresent())
			throw new  NotFoundException("El paciente no se encuentra en la base de datos");
		List<AppointmentRequestEntity> listAppointment = appointmentDao.findByPersonalMedicoId(personEntity.get().getPersonId());
		
		List<AppointmentDetailResponseDto> listResponse = new ArrayList<>();
		AppointmentDetailResponseDto dto = null;
		for(AppointmentRequestEntity entity:listAppointment) {
			dto = new AppointmentDetailResponseDto();
			dto.setAppointmentId(entity.getAppointmentId());
			dto.setCreatedAp(entity.getCreatedAp());
			dto.setDateAppointment(entity.getDateAppointment());
			dto.setDeleted(entity.isDeleted());
			dto.setPatient(entity.getPatient().getPersonId());
			dto.setPersonalDoctor(entity.getPersonalDoctor());
			dto.setShiftClassificationDescription(entity.getShiftClassificationId().getDescription());
			dto.setShiftClassificationId(entity.getShiftClassificationId().getShiftClassificationId());
			dto.setShiftStatusDescription(entity.getShiftStatusId().getDescription());
			dto.setShiftStatusId(entity.getShiftStatusId().getShiftStatusId());
			dto.setUpdatedAp(entity.getUpdatedAp());
			dto.setNroDni(entity.getPatient().getNroDni());
			dto.setNamePatient(entity.getPatient().getName()+ " "+entity.getPatient().getLastName());
			 
			listResponse.add(dto);
			
			
		}
		
		return listResponse;
	}

}
