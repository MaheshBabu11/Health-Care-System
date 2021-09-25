package com.cg.healthcaresystem.service;




import com.cg.healthcaresystem.model.Appointment;
import com.cg.healthcaresystem.model.DiagnosticCenter;
import com.cg.healthcaresystem.model.Patient;
import com.cg.healthcaresystem.repository.AppointmentRepository;
import com.cg.healthcaresystem.repository.DiagnosticCenterRepository;
import com.cg.healthcaresystem.repository.DiagnosticTestRepository;
import com.cg.healthcaresystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository appointmentrepository;
    private PatientRepository patientRepository;
    private DiagnosticCenterService diagnosticCenterService;
    private DiagnosticCenterRepository diagnosticCenterRepository;
    private DiagnosticTestRepository diagnosticTestRepository;

    @Override
    public Appointment addAppointment(Appointment appointment)
    {

        appointmentrepository.save(appointment);
        return appointment;
    }
    @Override
    public Set<Appointment> viewAppointments(String patientName)
    {
        Patient patient=patientRepository.findByName(patientName).get(0);
        return (Set<Appointment>) patient.getAppointmentList();

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
        Optional<Appointment> optionalAppointment = appointmentrepository.findById(appointment.getId());
        if (optionalAppointment.isPresent())
            appointment1 = optionalAppointment.get();
        appointment1.setDate(appointment.getDate());
        appointment1.setApprovalStatus(appointment.isApprovalStatus());

        appointmentrepository.save(appointment1);
        return appointment1;

    }
    public List<Appointment> getAppointmentList(int centreId ,String test,boolean status)
    {
        Optional<DiagnosticCenter> diagnosticCenter=diagnosticCenterRepository.findById(centreId);
        List<Appointment> appointments=diagnosticCenterService.getListOfAppointments(diagnosticCenter.get().getName());
        List<Appointment> appointments1=appointments.stream().filter(appointment -> appointment.isApprovalStatus()==status).filter(appointment -> appointment.getTestResults().equals(diagnosticTestRepository.findByTestName(test))).collect(Collectors.toList());
        return appointments1;
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



