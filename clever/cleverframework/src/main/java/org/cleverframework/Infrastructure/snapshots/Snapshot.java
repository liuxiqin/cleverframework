package org.cleverframework.Infrastructure.snapshots;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-04-13 .
 */
public class Snapshot implements Serializable {

    private static final long serialVersionUID = 4907306072373286121L;

    private String snapshotId;

    private String aggregateRootId;

    private int version;

    private byte[] aggregateRootBytes;

    private Date timeStamp;

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getAggregateRootId() {
        return aggregateRootId;
    }

    public void setAggregateRootId(String aggregateRootId) {
        this.aggregateRootId = aggregateRootId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public byte[] getAggregateRootBytes() {
        return aggregateRootBytes;
    }

    public void setAggregateRootBytes(byte[] aggregateRootBytes) {
        this.aggregateRootBytes = aggregateRootBytes;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Snapshot{" +
                "snapshotId='" + snapshotId + '\'' +
                ", aggregateRootId='" + aggregateRootId + '\'' +
                ", version=" + version +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
