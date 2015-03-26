package com.simple.reading.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public  class MD5Converter {
	
    private final static Logger logger = Logger.getLogger(MD5Converter.class);
    static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ne) {
            logger.error("NoSuchAlgorithmException: md5", ne);
        }
    }

    /**
     * ��һ���ļ�������md5ֵ
     * @param f Ҫ��md5ֵ���ļ�
     * @return md5��
     */
    public static String md5(File f) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            //100KB each time
            byte[] buffer = new byte[102400];
            int length;
            long loopCount = 0;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
                loopCount++;
            }
            
            logger.debug("read file to buffer loopCount:"+loopCount);

            return new String(Hex.encodeHex(md.digest()));
        } catch (FileNotFoundException e) {
            logger.error("md5 file " + f.getAbsolutePath() + " failed:" + e.getMessage());
            return null;
        } catch (IOException e) {
            logger.error("md5 file " + f.getAbsolutePath() + " failed:" + e.getMessage());
            return null;
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ��һ���ַ�����md5ֵ
     * @param target �ַ���
     * @return md5 value
     */
    public static String md5(String target) {
        return DigestUtils.md5Hex(target);
    }
    
//    public static void main(String[] args) {
//        long begin =System.currentTimeMillis();
//        System.out.println(md5(new File("G:/BT/PremierePro_6_LS7.7z")));
//        long end =System.currentTimeMillis();
//        System.out.println("time:"+((end-begin)/1000)+"s");
//        
//        System.out.println(md5("hello world"));
//    }
	
}
