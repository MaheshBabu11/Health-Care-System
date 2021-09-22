package com.cg.healthcaresystem.service;




import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.List;
import java.util.Optional;

        @Service
public class AppointmentServiceImpl implements AppointmentService{
            @Autowired
            private AppointmentRepository appointmentrepository;

            @Override
            public Appointment addAppointment(Appointment appointment)
            {

                appointmentrepository.save(appointment);
                return appointment;
            }
            @Override
            public Set<Appointment> viewAppointments(String patientName)
            {


                Optional<List<Appointment>> optionalAppointment= appointmentrepository.findById(id);
                if (optionalAppointment.isPresent())
                    Appointment = optionalAppointment.get();
                return Appointment;
            }
            public Optional<Appointment> viewAppointment (int appointmentid)
            {
                Optional<Appointment> optionalAppointment= appointmentrepository.findById(appointmentid);
                if (optionalAppointment.isPresent())
                        return optionalAppointment;
                else
                    return optionalAppointment;
            }
            public Appointment updateAppointment(Appointment appointment){
                Appointment appointment1 = null;
                Optional<Appointment> optionalAppointment = appointmentrepository.findById(id);
                if (optionalAppointment.isPresent())
                    appointment1 = optionalAppointment.get();
                appointment1.setDate(appointment.getDate());
               appointment1.setApprovalStatus(appointment.getApprovalStatus());

                appointmentrepository.save(appointment1);

            }
            public List<Appointment> getAppointmentList(int centreId ,String test,int status)
            {

              return null;
            }
            public Appointment removeAppointment(Appointment appointment)
            {
                Optional<Appointment> appointmentOptional=appointmentrepository.findById(appointment.getId());
                if(appointmentOptional.isPresent()) {
                    appointmentrepository.deleteById(appointment.getId());
                    return appointment;
                }
                else{
                    return null;
                }
            }

}




