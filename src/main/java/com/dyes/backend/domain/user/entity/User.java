package com.dyes.backend.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String accessToken;
    private String refreshToken;
}