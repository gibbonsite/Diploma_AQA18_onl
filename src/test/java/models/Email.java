package models;

import com.google.gson.annotations.Expose;
import lombok.*;

@Builder
@Data
@Getter
public class Email {
        private int id;
        private String email;
}
