package edu.ucam.practicafinaldad.back.MailConnections;

public class IMAPConnection extends Connections {
    
    private int imapId;

    public IMAPConnection(int imapId, String userId, String email, String pswdMail) {
        super(userId, email, pswdMail);
        this.imapId = imapId;
    }

    public int getImapId() {
        return imapId;
    }

    public void setImapId(int imapId) {
        this.imapId = imapId;
    }
}
