//package framework.qa.utils;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class FileContentReader {
//    public static String jsonBody;
//    private static String getFileFromResources(String filePath){
//        File file = new File(filePath);
//        String absolutePath = file.getAbsolutePath();
//        return absolutePath;
//    }
//    public  String jsonFile(String filePath){
//        try {
//            jsonBody = new String(Files.readAllBytes(Paths.get(getFileFromResources(filePath))), StandardCharsets.UTF_8);
//            return jsonBody;
//        } catch (IOException var3) {
//            throw new RuntimeException(var3);
//        }
//    }
//
//
//
//}
//
//
