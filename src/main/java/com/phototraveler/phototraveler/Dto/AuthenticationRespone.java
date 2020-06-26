package com.phototraveler.phototraveler.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRespone {
    private String authenticationToken;
    private String username;
}
