package com.pchome.Util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
@Component
public class Base64ImgUtil {

	
	public void convertBase64ToFile(String encodedString,String outputFileName) {
		
		try {
//			byte[] decodedBytes = Base64.getDecoder().decode(encodedString);

			
			final Base64.Decoder decoder = Base64.getDecoder();
			System.out.println(new String(decoder.decode(encodedString), "UTF-8"));
			byte[] xx = decoder.decode(encodedString);
			FileUtils.writeByteArrayToFile(new File(outputFileName), xx);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
