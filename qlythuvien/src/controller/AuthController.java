package controller;
import model.modeluser;
public class AuthController {

	private static modeluser modeluser = new modeluser();

    public AuthController() {
    	modeluser = new modeluser();
    }
    	// hàm gọi khi người dung đăng nhập sau khi đăng ký thành công 
    public static boolean handleLogin(String ten, String matkhau) {
        return modeluser.login(ten, matkhau);
    }
    	// hàm gọi khi người dùng đăng ký thành công
    public static boolean handleRegister(String ten, String matkhau) {
        return modeluser.register(ten, matkhau);
    }
	public static boolean checkEmailExists(String user) {
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean checkPasswordCorrect(String user, String pass) {
		// TODO Auto-generated method stub
		return false;
	}
}
