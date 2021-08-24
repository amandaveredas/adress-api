package com.github.amandaveredas.adressapi.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageResponse {
    private String message;
}
