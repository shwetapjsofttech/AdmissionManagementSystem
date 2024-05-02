package com.example.CRMProject.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JWDRequest {

    private String email;
    private String password;
}
