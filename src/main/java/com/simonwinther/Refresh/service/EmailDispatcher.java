package com.simonwinther.Refresh.service;

import aj.org.objectweb.asm.TypeReference;
import com.simonwinther.Refresh.utility.FileUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static java.nio.file.Files.readAllBytes;
import static org.springframework.util.ResourceUtils.getFile;


@Service
@Slf4j
@AllArgsConstructor
public class EmailDispatcher {
    public final JavaMailSender emailSender;

    public void sendSimpleMail() {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("sender@example.com");
            helper.setTo("recipient@example.com");
            helper.setSubject("Testing JavaMailSender");

            // read the contents of the HTML file
            ClassPathResource resource = new ClassPathResource("static/mail/content.html");
            String htmlContent = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);

            // set the HTML content as the message body
            helper.setText(htmlContent, true);
            emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }

    }



}
