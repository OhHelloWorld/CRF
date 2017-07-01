package app.entities;

import javax.persistence.*;

/**
 * Created by 52400 on 2017/6/30.
 */

@Entity
@Table(name = "message")
public class MessageDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    @Column(name = "received_user_id")
    private Long receivedUserId;

    @Column(name = "readed")
    private boolean read;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReceivedUserId() {
        return receivedUserId;
    }

    public void setReceivedUserId(Long receivedUserId) {
        this.receivedUserId = receivedUserId;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
