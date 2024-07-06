package com.accio.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer userId;

    private String userName;
    private Integer age;
    private String emailId;
    private String mobNo;
}
