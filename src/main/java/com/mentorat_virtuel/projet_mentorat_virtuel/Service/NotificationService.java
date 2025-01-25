package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender emailSender;

   public void sendAppointmentConfirmation(RDV rdv) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your_email@example.com");

        message.setSubject("Appointment Confirmation");
        message.setText("Your appointment with " + rdv.getMentor()+ " is confirmed for " + rdv.getDebutduRDV());
    }

}