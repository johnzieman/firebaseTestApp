package ziemansoft.ziemapp.chatterflowtest.pojo;

public class UserId {
    private String userName;
    private String userLastName;
    private String userAge;
    private String userSex;

    public UserId(){}

    public UserId(String userName, String userLastName, String userAge, String userSex) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userSex = userSex;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserAge() {
        return userAge;
    }

    public String getUserSex() {
        return userSex;
    }
}
