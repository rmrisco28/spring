package com.example.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
@Transactional
@RequiredArgsConstructor
public class Service9 {
    public void action1(String username, MultipartFile upload) {
        System.out.println("username = " + username);
        System.out.println("upload = " + upload.getOriginalFilename());

        try {
            InputStream is = upload.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

            String filePath = "C:/Temp/uploadFiles/" + upload.getOriginalFilename();

            OutputStream os = new FileOutputStream("");
            BufferedOutputStream bos = new BufferedOutputStream(os);
            try (bos; os; bis; is) {
                byte[] buffer = new byte[1024];
                int length;

                while ((length = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, length);
                }
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new RuntimeException(e);
        }

    }

    public void action2(String address, MultipartFile upload) {
        System.out.println("address = " + address);
        System.out.println("uploadFile = " + upload);

        if (upload != null) {
            // 파일이 업로드 되어있는상태라면
            if (upload.getSize() > 0) {
                try {                // inputStream
                    // outputStream
                    String path = "C:/Temp/uploadFiles/" + upload.getOriginalFilename();
                    OutputStream os = new FileOutputStream(path);
                    BufferedOutputStream bos = new BufferedOutputStream(os);

                    InputStream is = upload.getInputStream();


                    try (is; bos; os;) {
//                        is.transferTo(bos);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) != -1) {
                            bos.write(buffer, 0, length);
                        }
                        bos.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void action3(MultipartFile[] upload) {
        if (upload != null) {
            for (MultipartFile file : upload) {
                if (file.getSize() > 0) {
                    try {
                        String path = "C:/Temp/uploadFiles/" + file.getOriginalFilename();
                        var bis = new BufferedInputStream(file.getInputStream());
                        var bos = new BufferedOutputStream(new FileOutputStream(path));
                        try (bos; bis) {
                            byte[] buffer = new byte[1024];
                            int length;
                            while ((length = bis.read(buffer)) != -1) {
                                bos.write(buffer, 0, length);
                            }
                            bos.flush();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}