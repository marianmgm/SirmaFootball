package com.example.sirmafinalprojectfootball.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @Column(name = "team_id")
    private int id;

    @Column(name= "name")
    private  String name;

    @Column(name="manager_full_name")
    private String managerFullName;

    @Column(name="group_name")
    private String groupName;

}


