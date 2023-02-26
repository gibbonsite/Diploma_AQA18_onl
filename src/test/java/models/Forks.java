package models;

import com.google.gson.annotations.Expose;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Forks {
    private String owner;
    private String repo;
    @Expose
    private String name;

}
