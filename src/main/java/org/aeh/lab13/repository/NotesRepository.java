package org.aeh.lab13.repository;

import org.aeh.lab13.model.Note;
import org.aeh.lab13.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {


    @Query("SELECT n FROM Note n WHERE n.user = :user")
    List<Note> findByUser(@Param("user") User user);
}
