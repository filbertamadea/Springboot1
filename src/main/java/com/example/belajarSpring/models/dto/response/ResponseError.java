package com.example.belajarSpring.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {
    private Integer status;
    private LocalDateTime timestamp;
    private String message;
    private Object errors;
}
