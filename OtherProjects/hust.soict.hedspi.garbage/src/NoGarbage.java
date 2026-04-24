import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    public static void main (String [] args){
        String filename = "C:\\Users\\Admin\\Desktop\\IT3280\\202416929_LamQuangHung_GiuaKy.docx";
        byte[] inputBytes = {0};
        long startTime, endTime;
        try{
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            for (byte b : inputBytes) {
                outputStringBuilder.append((char) b);
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time with StringBuilder: " + (endTime - startTime) + "ms");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
