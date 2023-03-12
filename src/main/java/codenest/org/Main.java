package codenest.org;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello world!");
        // 1. JEP 408: Simple File Server
        HttpServer webServer = SimpleFileServer.createFileServer(new InetSocketAddress(8080),
                Path.of("D:\\Projekte\\jdbctemplate\\java18\\src\\main\\resources\\webServer"),
                SimpleFileServer.OutputLevel.VERBOSE);
        webServer.start();

        // 2. create FileHandler to existing WebServer
        HttpHandler fileHandler = SimpleFileServer.createFileHandler(Path.of("D:\\Projekte\\jdbctemplate\\java18\\src\\main\\resources\\webServer"));
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 10, "/someContext/", fileHandler);
        httpServer.start();

        Thread.sleep(100000);
    }
}