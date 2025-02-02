package org.aeh.lab13.controller;

import org.aeh.lab13.model.Note;
import org.aeh.lab13.model.User;
import org.aeh.lab13.service.NotesService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }


    @GetMapping
    public List<Note> getAllNotes() {
        return notesService.getAllNotes();
    }


    @GetMapping("/my")
    public List<Note> getUserNotes(@AuthenticationPrincipal User user) {
        return notesService.getUserNotes(user);
    }


    @PostMapping
    public Note saveNote(@RequestBody Note note, @AuthenticationPrincipal User user) {
        return notesService.saveNote(note, user);
    }

    @GetMapping("/create")
    public String showCreatePage() {
        return "create";
    }

}


