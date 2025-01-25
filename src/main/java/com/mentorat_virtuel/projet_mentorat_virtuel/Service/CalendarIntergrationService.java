package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.RDV;
import jdk.jfr.Event;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.stereotype.Service;

import javax.imageio.spi.IIORegistry;
import java.util.Calendar;
import java.util.Locale;

@Service
public class CalendarIntergrationService {
    private static final String APPLICATION_NAME = "Your Application Name";
    private static IIORegistry GsonFactory;
    private static final IIORegistry JSON_FACTORY = GsonFactory.getDefaultInstance();
    public void createCalendarEvent(RDV rdv) throws Exception {

    /*    EmbeddedLdapProperties.Credential credential = authorizeUser();

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();


        // Calculate end time based on duration
        Event event = new Event()
                .setSummary("Appointment with " + rdv.getMentor())
                .setDescription("Mentoring session")
                .setStart(new EventDateTime().setDateTime(rdv.getDebutduRDV())) // Use your RDV date/time
                .setEnd(new EventDateTime().setDateTime(calculateEndTime(rdv)));


    }*/}
}