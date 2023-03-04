package models;

import com.google.gson.annotations.Expose;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Forks {
    @Expose
    private String name;

}