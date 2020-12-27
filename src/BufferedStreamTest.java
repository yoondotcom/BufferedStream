import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BufferedStreamTest {

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        int c;
        try {
            out = new BufferedOutputStream(new FileOutputStream("/Users/kimjiyun/IdeaProjects/BufferedStreamTest/StreamFile.txt"));
            for(int i=0;i<10;i++) {
                out.write(i);
            }
            // flush() : 버퍼를 수동으로 비우기 위해 사용하는 메서드
            out.flush(); //버퍼의 내용을 파일에 쓴다.
            in = new BufferedInputStream(new FileInputStream("/Users/kimjiyun/IdeaProjects/BufferedStreamTest/StreamFile.txt"));
            while((c = in.read()) != -1) {
                System.out.print(c + " ");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}