package url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download implements Runnable {
    String link;
    File out;
    public Download(String link, File out) {
        this.link = link;
        this.out = out;
    }

    @Override
    public void run() {
        try{
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(this.out);
            BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
            byte[] buffer = new byte[1024];
            int read = 0;
            while((read = in.read(buffer, 0, 1024)) >= 0) {
                bout.write(buffer, 0, read);
            }
            bout.close();
            in.close();
            System.out.println("Downloaded complete");
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
