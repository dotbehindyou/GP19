package Model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class OrderHead {
    public UUID ID;
    public Integer ContactID;
    public Timestamp Created;
    public Date Modify;
    public Integer CreatorID;
    public Integer ModifierID;
    public UUID ContactPersonID;
    public Integer WorkerID;
    public UUID AppointmentID;
    public Boolean IsDone;
    public Boolean IsAborted;
}
