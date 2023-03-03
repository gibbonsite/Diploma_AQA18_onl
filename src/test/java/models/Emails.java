package models;

import com.google.gson.annotations.Expose;
import lombok.*;
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Emails {
        @Expose
        private String[] email;
}
