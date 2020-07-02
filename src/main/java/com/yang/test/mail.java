package com.yang.test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author: yangcj
 * @date: 2020/6/24 12:00 上午
 * @description:
 */
public class mail {


    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.163.com";

    public static String reallyFromEmailAddress = "B40033697@163.com";

    public static String reallyToEmailAddress = "yangcjcjlu@126.com";

    public static String password ="PTWNWGZESMPMAAPP";


    public static String fromPs ="ADGOYREBUSYXCRZX";



    public static void main(String[] args) throws Exception{
        //创建参数，用于连接邮件服务器的参数配置
        Properties properties = new Properties();

        //使用协议，javaMail要求
        properties.setProperty("mail.transport.protocol","smtp");
        properties.setProperty("mail.smtp.host",myEmailSMTPHost);
        //需要认证请求
        properties.setProperty("mail.smtp.auth","true");

        //开启 SSL 连接

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(properties);
        session.setDebug(true);

        //创建一封邮件
        MimeMessage mimeMessage = new MimeMessage(session);
        /*
         * 也可以根据已有的eml邮件文件创建 MimeMessage 对象
         * MimeMessage message = new MimeMessage(session, new FileInputStream("MyEmail.eml"));
         */

        // 2. From: 发件人
        //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        //    真正要发送时, 邮箱必须是真实有效的邮箱。

        mimeMessage.setFrom(new InternetAddress(reallyFromEmailAddress,"yang","UTF-8"));


        // 3. To: 收件人
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(reallyToEmailAddress, "USER_CC", "UTF-8"));
        //    To: 增加收件人（可选）
//        mimeMessage.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
        //    Cc: 抄送（可选）
//        mimeMessage.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
        //    Bcc: 密送（可选）
//        mimeMessage.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));


        mimeMessage.setSubject("测试主体","UTF-8");

        mimeMessage.setContent("正文可以使用Httml","text/html;charset=UTF-8");

        mimeMessage.setSentDate(new Date());

        mimeMessage.saveChanges();


        //4.根据Session 获取传输对象
        Transport transport = session.getTransport();
        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        //
        //    PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
        //           仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
        //           类型到对应邮件服务器的帮助网站上查看具体失败原因。
        //
        //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
        //           (1) 邮箱没有开启 SMTP 服务;
        //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
        //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
        //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
        //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
        //
        //    PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。

        //这里应该选择发件地址！！
        transport.connect(reallyFromEmailAddress,fromPs);

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        // 7. 关闭连接
        transport.close();
    }
}
