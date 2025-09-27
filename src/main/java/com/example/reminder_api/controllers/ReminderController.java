package com.example.reminder_api.controllers;

import com.example.reminder_api.dtos.ReminderDto;
import com.example.reminder_api.models.ReminderModel;
import com.example.reminder_api.services.ReminderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping
    public ResponseEntity<Object> saveReminder(@Valid @RequestBody ReminderDto reminderDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reminderService.saveReminder(reminderDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable(value = "id") UUID id) {
        reminderService.deleteReminder(id);
        return ResponseEntity.noContent().build();
    }



}
