package API.DTO.TestsPOST.CreateUser;

public class UserRequestCreate {

    public String name;
    public String job;

    public UserRequestCreate(String name, String job){
        this.name = name;
        this.job = job;
    }
}
