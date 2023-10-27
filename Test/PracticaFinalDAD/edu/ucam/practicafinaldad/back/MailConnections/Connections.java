package edu.ucam.practicafinaldad.back.MailConnections;

public abstract class Connections {
    protected String userId;
    protected String email;
    protected String pswdMail;

    protected Connections(String userId, String email, String pswdMail) {
        this.userId = userId;
        this.email = email;
        this.pswdMail = pswdMail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswdMail() {
        return pswdMail;
    }

    public void setPswdMail(String pswdMail) {
        this.pswdMail = pswdMail;
    }
}
