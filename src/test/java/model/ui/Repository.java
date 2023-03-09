package model.ui;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Repository {
    private String name;
    private String description;
    private boolean isPublic;
}
