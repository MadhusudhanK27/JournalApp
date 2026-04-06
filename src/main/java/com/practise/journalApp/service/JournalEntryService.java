package com.practise.journalApp.service;

import com.practise.journalApp.entity.JournalEntry;
import com.practise.journalApp.entity.User;
import com.practise.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;


    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try{
            User user = userService.findByUsername(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
//            user.setUsername(null);
            userService.saveUser(user);
        }catch (Exception e){
            log.error("Error : ", e);
            throw new RuntimeException("An error occured while saving the entry.");
        }
    }

    // In mongoDb replication is mandatory for transaction to work.

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id,String userName) {
        boolean removed = false;
       try {
           User user = userService.findByUsername(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
           if(removed) {
               userService.saveUser(user);
               journalEntryRepository.deleteById(id);
           }

       } catch (Exception e) {
           log.error("Error : ", e);
           throw new RuntimeException("An error occured while deleting the entry.",e);
       }
        return removed;

    }

//    public List<JournalEntry> findByUserName(String userName){
//
//    }
}
