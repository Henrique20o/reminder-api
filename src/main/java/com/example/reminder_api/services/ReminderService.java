package com.example.reminder_api.services;

import com.example.reminder_api.models.ReminderModel;
import com.example.reminder_api.repositores.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    final ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }


    public List<ReminderModel> findAll() {
        return reminderRepository.findAll();
    }
}
