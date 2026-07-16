package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    private Integer id;
    private Integer memberId;
    private String serviceType;
    private String note;
    private Integer slotId;
    private Timestamp createdAt;


}
