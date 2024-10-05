package Broker;

import java.time.LocalDateTime;

public class Node {

    private int message_id;
    private String user_id;
    private String content_type;
    private String message;
    private String to;
    private String reply_to;
    private String absolute_expiry_time;
    private LocalDateTime creation_time;
    private String state;
    private Integer priority;

    public Node(
            String user_id,
            String content_type,
            String message,
            String to,
            String reply_to,
            String absolute_expiry_time,
            String state,
            Integer priority
            ) {
            this.user_id = user_id;
            this.content_type = content_type;
            this.message = message;
            this.to = to;
            this.reply_to = reply_to;
            this.absolute_expiry_time = absolute_expiry_time;
            this.state = state;
            this.priority = priority;
            this.creation_time = LocalDateTime.now();
    }

    public void setMessageId(int message_id){
        this.message_id = message_id;
    }

    public int getMessageId(){
        return this.message_id;
    }

    public void setUserId(String user_id){
        this.user_id = user_id;
    }

    public String getUserId(){
        return this.user_id;
    }

    public void setContentType(String content_type){
        this.content_type = content_type;
    }

    public String getContentType(){
        return this.content_type;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public void setTo(String to){
        this.to = to;
    }

    public String getTo(){
        return this.to;
    }

    public void setReplyTo(String reply_to){
        this.reply_to = reply_to;
    }

    public String getReplyTo(){
        return this.reply_to;
    }

    public void setExpiryTime(String absolute_expiry_time){
        this.absolute_expiry_time = absolute_expiry_time;
    }

    public String getExpiryTime(){
        return this.absolute_expiry_time;
    }

    public void setCreationTime(LocalDateTime creation_time){
        this.creation_time = creation_time;
    }

    public LocalDateTime getCreationTime(){
        return this.creation_time;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    public void setPriority(Integer priority){
        this.priority = priority;
    }

    public Integer getPriority(){
        return this.priority;
    }
}
