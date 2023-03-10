package models;

import lombok.*;

@Builder
@Data
public class Email {
    private int id;
    private String email;
}
