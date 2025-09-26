package com.example.reminder_api.services;

import com.example.reminder_api.dtos.ReminderDto;
import com.example.reminder_api.models.ReminderModel;
import com.example.reminder_api.repositores.ReminderRepository;
import com.example.reminder_api.validators.ReminderValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final ReminderValidator reminderValidator;

    public ReminderService(ReminderRepository reminderRepository, ReminderValidator reminderValidator) {
        this.reminderRepository = reminderRepository;
        this.reminderValidator = reminderValidator;
    }


    public List<ReminderModel> findAll() {
        return reminderRepository.findAll();
    }

    public ReminderModel saveReminder(ReminderDto reminderDto){
        reminderValidator.validate(reminderDto);
        ReminderModel reminderModel = new ReminderModel();
        reminderModel.setTitle(reminderDto.getTitle());
        reminderModel.setDate(reminderDto.getDate());
        return  reminderRepository.save(reminderModel);
    }
}
