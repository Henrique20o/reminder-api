package com.example.reminder_api.validators;

import com.example.reminder_api.dtos.ReminderDto;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReminderValidator {

    public void validate(ReminderDto reminderDto) {
        LocalDate localDate = LocalDate.now();

        if (reminderDto.getDate().isBefore(localDate)) {
            throw new IllegalArgumentException("Data invalida");
        }
    }
}
