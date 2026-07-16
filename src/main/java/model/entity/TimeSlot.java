package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    private Integer id;
    private Date bookingDate;
    private Time startTime;
    private Time endTime;
    private Boolean isBooked;


}
