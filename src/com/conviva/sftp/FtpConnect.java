package com.conviva.sftp;

import org.apache.commons.net.ftp.*;

import java.io.IOException;

/**
 * Created by adixith on 11/28/16.
 */
public class FtpConnect {
    public static void main(String args[]) {
        FTPClient ftp = new FTPClient();
        FTPClientConfig config = new FTPClientConfig();
        // config.setServerTimeZoneId("Pacific/Pitcairn")
        ftp.configure(config);
        boolean error = false;
        try {
            int reply;
            String server = Constants.FTP_ADDRESS;
            ftp.connect(server);
            System.out.println("Connected to " + server + ".");
            System.out.print(ftp.getReplyString());
            ftp.login(Constants.FTP_USERNAME, Constants.FTP_PASSWORD);

            // After connection attempt, check the reply code to verify success.
            reply = ftp.getReplyCode();

            if(!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.err.println("FTP server refused connection.");
                System.exit(1);
            }
            // transfer files
            new FtpConnect().listContent(ftp, "/", 10);
            ftp.logout();
        } catch(IOException e) {
            error = true;
            e.printStackTrace();
        } finally {
            if(ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch(IOException ioe) {
                }
            }
            System.exit(error ? 1 : 0);
        }
    }

    public void listContent(FTPClient ftp, String path, int limit) throws IOException {
        FTPListParseEngine engine = ftp.initiateListParsing(path);
        while (engine.hasNext()) {
            FTPFile[] files = engine.getNext(limit);
            for(FTPFile file: files) {
                System.out.println(file.getName());
            }
            //System.out.println("===============");
        }
    }
}
