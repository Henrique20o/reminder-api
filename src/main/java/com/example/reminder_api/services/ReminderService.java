package com.example.reminder_api.services;

import com.example.reminder_api.repositores.ReminderRepository;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {

    final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }



}
