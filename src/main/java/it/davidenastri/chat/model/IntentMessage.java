package it.davidenastri.chat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntentMessage {
    private Integer Id;
    private Integer msgId;
    private Integer intentid;
    private Double confidance;
}
