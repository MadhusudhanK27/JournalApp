package com.practise.journalApp.repository;

import com.practise.journalApp.entity.ConfigJournalAppEntity;
import com.practise.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}
