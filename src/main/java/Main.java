import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

//        makeFiles();

        print(new File("./Directory"), "", true);

    }

    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());
        File[] files = file.listFiles();
        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            subDirTotal++;
        }
        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirTotal == ++subDirCounter);
            }
            if(files[i].isFile()){

                File[] files1 = files[i].getParentFile().listFiles();


                int subDirTotalFile = 0;
                for (int w = 0; w < files1.length; w++) {
                    subDirTotalFile++;
                }
                for (int j = 0; j < files1.length; j++) {
                    System.out.print(indent);

                    if (subDirTotalFile == ++subDirCounter) {
                        System.out.print("└─");
                        indent += "  ";
                    } else {
                        System.out.print("├─");
                    }
                    System.out.println(files1[j].getName());
                }
                break;
            }
        }
    }








    public static void makeFiles(){
        for (int i = 0; i < 10; i++) {
            String path = "File_" + i;
            try(FileOutputStream fileOutputStream = new FileOutputStream(path)){
                fileOutputStream.write(("This is " + i).getBytes(StandardCharsets.UTF_8));
                System.out.println("Файл успешно создан");
            }catch (Exception e){
                System.out.println("Ошибка создания файла");
            }
        }
    }
}
