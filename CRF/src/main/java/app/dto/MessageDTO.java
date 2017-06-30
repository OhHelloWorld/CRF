package app.dto;

/**
 * Created by 52400 on 2017/6/30.
 */
public class MessageDTO {

    private Long id;

    private String content;

    private Long received_user_id;

    private String status;

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

    public Long getReceived_user_id() {
        return received_user_id;
    }

    public void setReceived_user_id(Long received_user_id) {
        this.received_user_id = received_user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
