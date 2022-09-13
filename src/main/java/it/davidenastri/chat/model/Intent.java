package it.davidenastri.chat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Intent {
    private Integer intentId;
    private String intentName;
    private String description;
    private Integer replyId;

}
