package com.jack.msgpush;

import com.jack.msgpush.common.constant.SystemConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MsgPushApplication implements CommandLineRunner {

    @Value("server.port")
    private String serverPort;

    public static void main(String[] args) {
        SpringApplication.run(MsgPushApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info(AnsiOutput.toString(SystemConstant.PROJECT_BANNER, "\n", AnsiColor.GREEN, SystemConstant.PROJECT_NAME, AnsiColor.DEFAULT, AnsiStyle.FAINT));
        log.info("msg-push start succeeded, Index >> http://127.0.0.1:{}/", serverPort);
        log.info("msg-push start succeeded, Swagger Url >> http://127.0.0.1:{}/swagger-ui/index.html", serverPort);
    }
}
