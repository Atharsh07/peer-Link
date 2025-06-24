package p2p.service;
import p2p.utils.UploadUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;

public class FileSharer {

    private HashMap<Integer, String > availableFiles;

    public FileSharer(){
        availableFiles = new HashMap<>();
    }

    public  int offerFile(String filePath){
        int port;
        while (true){
            port = UploadUtils.generateCode();
            if(!availableFiles.containsKey(port)){
                availableFiles.put(port, filePath);
                return port;
            }
        }
    }

    public void startFileServer(int port) throws IOException {
        String filePath = availableFiles.get(port);
        if(filePath == null){
            System.out.println("No file is associated with port :  " + port);
            return;
        }
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Severing file" + new );
        }
    }


}
