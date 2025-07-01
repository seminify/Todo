package org.seminify.application.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TodoDTO {
    private Long id;
    private String title;
    private Boolean done;
}
