package com.example.reminder_api.services;

import com.example.reminder_api.dtos.ReminderDto;
import com.example.reminder_api.models.ReminderModel;
import com.example.reminder_api.repositories.ReminderRepository;
import com.example.reminder_api.validators.ReminderValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public ReminderModel deleteReminder(UUID id) {
        Optional<ReminderModel> optionalReminderModel = reminderRepository.findById(id);
        if (optionalReminderModel.isPresent()) {
            reminderRepository.deleteById(id);
            return optionalReminderModel.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reminder not found");
        }
    }

}
