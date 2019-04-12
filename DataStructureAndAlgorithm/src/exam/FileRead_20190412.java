package exam;

import java.io.*;

/*
 * Java文本文件读取和输出示例
 *
 */
public class FileRead_20190412 {
    public static void main(String[] args){
        try {
            String mainPath = "/Users/mobike/Documents/Projects/Mobike/JavaPractice2/DataStructureAndAlgorithm/src/exam/";
            File file=new File(mainPath + "test01.txt");//L:\io.txt
            //创建一个字节输入流对象
            InputStream inputStream=new FileInputStream(file);
            //FileInputStream fis = new FileInputStream("test.txt");
            //inputStream.read(); //读字节流

            InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader reader = new BufferedReader(isr);

            String line = null;
            String FileContent = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                FileContent += line;
                FileContent += "\r\n"; // 补上换行符
            }
            inputStream.close();

            //文件写入
            FileOutputStream fos = new FileOutputStream(mainPath + "test02.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            osw.write(FileContent);
            osw.flush();
            fos.close();

        }catch (Exception e){
            //FileNotFoundException,IOException
            System.out.println(e);
        }

    }
}
