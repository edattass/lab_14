package org.aeh.lab13.service;

import org.aeh.lab13.model.Note;
import org.aeh.lab13.model.User;
import org.aeh.lab13.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public List<Note> getAllNotes() {
        return notesRepository.findAll();
    }

    public List<Note> getUserNotes(User user) {
        return notesRepository.findByUser(user);
    }

    public Note saveNote(Note note, User user) {
        note.setUser(user);
        return notesRepository.save(note);
    }
}


