package com.example.reminder_api.controllers;

import com.example.reminder_api.models.ReminderModel;
import com.example.reminder_api.services.ReminderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/reminder")
public class ReminderController {

    final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping
    public ResponseEntity<List<ReminderModel>> getAllReminders() {
        return ResponseEntity.status(HttpStatus.OK).body((reminderService.findAll()));
    }

    



}
