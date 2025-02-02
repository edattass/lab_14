package org.aeh.lab13.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;

    @NotBlank(message = "Content cannot be empty")
    @Size(min = 5, message = "Content must be at least 5 characters long")
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
