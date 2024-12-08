package API.DTO.TestsPOST.RegAndLogin;

public class UserRequestRegAndLogin {

    public String email;
    public String password;

    public UserRequestRegAndLogin(String email){
        this.email = email;
    }

    public UserRequestRegAndLogin(String email, String password){
        this.email = email;
        this.password = password;
    }
}
