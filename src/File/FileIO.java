package File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO读取文件大致分为以下三个步骤
 * 1.从FileInputStream，FileOutputStream中获取Channel对象
 * 2.创建Buffer
 * 3.将数据从Channel读取到Buffer之中
 */
public class FileIO {
    public static void main(String[] args) throws IOException {
//        1.获取Channel对象
        FileInputStream fileInputStream = new FileInputStream("zhujian.txt");
        FileOutputStream fileOutputStream=new FileOutputStream("tiaotizhe.txt");

        FileChannel fcin = fileInputStream.getChannel();//获取输入Channel对象
        FileChannel fcout=fileOutputStream.getChannel();//获取输出Channel对象
//        2.创建Buffer,大小为1024
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
//        3.将数据从Channel读取到Buffer之中，从Buffer之中读取数据到Channel
        while(true){
            byteBuffer.clear();//清空缓存区
            int b=fcin.read(byteBuffer);
            if(b==-1){
                break;//读完了跳出循环
            }
            byteBuffer.flip();//由写状态转换成读状态
            fcout.write(byteBuffer);
        }
    }
}
