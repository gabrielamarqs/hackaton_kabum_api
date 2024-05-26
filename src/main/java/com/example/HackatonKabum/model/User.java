package com.example.HackatonKabum.model;

import com.example.HackatonKabum.model.enumerator.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private UUID id;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_username", unique = true, nullable = false)
    private String username;
    @Column(name = "user_password", nullable = false, updatable = false)
    private String password;
    @Column(name = "user_gender", nullable = false)
    private String gender;
    @Column(name = "user_email", unique = true, nullable = false, updatable = false)
    private String email;
    @Column(name = "user_image")
    private String image;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false, updatable = false)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "card_id", updatable = false)
    private Card card;
    @ManyToOne
    @JoinColumn(name = "event_id", updatable = false)
    private Event event;
    @CreationTimestamp(source = SourceType.DB)
    @Column(name = "user_created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

}
