package com.example.CRMProject.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JWDResponse {

    private String jwdToken;
    private String username;
}
