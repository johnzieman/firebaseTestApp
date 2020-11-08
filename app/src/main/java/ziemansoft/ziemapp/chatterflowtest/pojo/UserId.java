package ziemansoft.ziemapp.chatterflowtest.pojo;

public class UserId {
    private String userName;
    private String userLastName;
    private int userAge;
    private String userSex;

    public UserId(){}

    public UserId(String userName, String userLastName, int userAge, String userSex) {
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

    public void setUserAge(int userAge) {
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

    public int getUserAge() {
        return userAge;
    }

    public String getUserSex() {
        return userSex;
    }
}
