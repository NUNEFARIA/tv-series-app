package model.entities;

public class User {
    
    private String nickName;
    
    public User(String nickName) {
        setNickName(nickName);
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    @Override
    public String toString() {
        return nickName;
    }
}
