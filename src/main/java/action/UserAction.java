package action;

import dao.UserDao;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import po.User;


public class UserAction extends DefaultActionSupport {


    private String username;
    private String password;
    private String passwordAgain;
    private String phone;
    private String email;

    private UserDao userDao;

    UserAction() {
    }


    public String singUp() throws Exception {
        if (validateUsername() && validatePassword()) {

            if (!password.equals(passwordAgain)) {
                addFieldError("passwordAgain", "两次密码输入不一致");
            }

            User user = userDao.findUserByID(username);
            if (user != null) {
                addFieldError("username", "用户名已经被占用");
                return INPUT;
            }

            user = new User(username, phone, password.hashCode());

            userDao.addUser(user);
            return SUCCESS;

        }
        return INPUT;
    }


    /**
     * 校验用户名
     */
    private boolean validateUsername() {
        if (username != null && username.matches("^[a-z0-9_-]{3,15}$")) {
            return true;
        }
        addFieldError("username", "用户名不符合规范");
        return false;
    }

    /**
     * 校验密码，只能包含数字、字母、下划线、符号，长度为6-20位
     */
    private boolean validatePassword() {
        if (!password.isEmpty() && password.matches("[0-9a-zA-Z!@#$%^?,./]{6,20}")) {
            return true;
        }
        addFieldError("password", "密码不符合规范");
        return false;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}



