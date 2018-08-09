package com.pchome.Util;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

    //@Autowired
    //MailConfig mailConfig;

    /**
     * 发送邮件
     * 文本内容支持html标签
     *
     * @param senderName sender name default dplatform
     * @param to         if exist more than one receiver using , splite
     * @param cc         if exist more than one receiver using , splite
     * @param subject
     * @param content
     * @param bytes      annex array
     * @param names      annex names
     * @throws MessagingException
     * @throws IOException
     */
    public void sendMail(String senderName, String to, String cc, String subject, String content, byte[][] bytes, String[] names) throws MessagingException, IOException {

        // 属性对象
        Properties properties = properties();
        // 环境信息
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 在session中设置账户信息，Transport发送邮件时会使用W
                return new PasswordAuthentication("bryant05053@gmail.com", "pca05053rd");
            }
        });

        //邮件
        MimeMessage msg = new MimeMessage(session);
        //设置主题
        msg.setSubject(subject);
        //发件人，注意中文的处理
        msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText(senderName) + "\"<" +"bryant05053@gmail.com" + ">"));
        //设置邮件回复人
//        msg.setReplyTo(new Address[]{new InternetAddress("harry.hu@derbysoft.com")});

        msg.setRecipients(Message.RecipientType.TO, to);
//        if (!StringUtil.isEmpty(cc)) {
//            msg.setRecipients(Message.RecipientType.CC, cc);
//        }
        //整封邮件的MINE消息体
        MimeMultipart msgMultipart = new MimeMultipart("mixed");//混合的组合关系
        //设置邮件的MINE消息体
        msg.setContent(msgMultipart);

        // 装载附件
        if (bytes != null && names != null) {
            for (int i = 0; i < bytes.length; i++) {
                MimeBodyPart attch = new MimeBodyPart(); // 附件
                msgMultipart.addBodyPart(attch);         // 将附件添加到MIME消息体中
                ByteArrayDataSource dataSource = new ByteArrayDataSource(bytes[i], "text/data"); //数据源
                attch.setDataHandler(new DataHandler(dataSource));
                attch.setFileName(names[i]);
            }
        }

        //html代码部分
        MimeBodyPart htmlPart = new MimeBodyPart();
        msgMultipart.addBodyPart(htmlPart);
        //html代码
        htmlPart.setContent(content, "text/html;charset=utf-8");
        //发送邮件
        Transport.send(msg, msg.getAllRecipients());

    }

    protected Properties properties() {
        // 属性对象
        Properties properties = new Properties();
        // 开启debug调试 ，打印信息
        properties.setProperty("mail.debug", "false");
        // 发送服务器需要身份验证
       // properties.setProperty("mail.smtp.auth", mailConfig.getAuth());
        // 发送服务器端口，可以不设置，默认是25
        properties.setProperty("mail.smtp.port", "587");
        // 发送邮件协议名称
        properties.setProperty("mail.transport.protocol", "stmp");
        // 设置邮件服务器主机名
        properties.setProperty("mail.host", "smtp.gmail.com");

        return properties;
    }

}
