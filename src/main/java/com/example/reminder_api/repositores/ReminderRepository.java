package com.example.reminder_api.repositores;

import com.example.reminder_api.models.ReminderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderModel,Integer> {

}
