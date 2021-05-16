package en.edu.jxnu.rj.lrf;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Classname TestByteBuffer
 * @Description TODO nio
 * @Date 2021/5/16 10:57
 * @Created by 刘荣飞
 */
public class TestByteBuffer {
    public static void main(String[] args) throws IOException {
        FileChannel channel = new FileInputStream("data.txt").getChannel();
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        //从channel读取数据，向buffer写入
        while(true){
            int len = channel.read(buffer);
            if(len == -1) break;
            buffer.flip();//切换至读模式
            while(buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
        }


    }
}
