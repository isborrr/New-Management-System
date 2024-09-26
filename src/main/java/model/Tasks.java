package model;

import jakarta.persistence.*;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "taskId")
    private int id;
    private String title;
    private String description;
    private String status;
}
