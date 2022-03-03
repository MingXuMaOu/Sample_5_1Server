package wyf.ytl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuming
 * @description
 * @date 2022/3/3
 */
public class Sample_5_1Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        DataInputStream din = null;
        DataOutputStream dout = null;
        try{
            ss = new ServerSocket(8888);
            System.out.println("已监听8888端口！");
        }catch (Exception e){
            e.printStackTrace();
        }
        while (true){
            try{
                s = ss.accept();
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
                String msg = din.readUTF();
                System.out.println("ip: " + s.getInetAddress());
                System.out.println("msg: " + msg);
                dout.writeUTF("Hello Client");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    if(dout != null){
                        dout.close();
                    }
                    if(din != null){
                        din.close();
                    }
                    if(s != null){
                        s.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
