package com.example.reminder_api.repositories;

import com.example.reminder_api.models.ReminderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderModel, UUID> {

}
