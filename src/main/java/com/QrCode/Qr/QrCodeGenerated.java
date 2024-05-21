package com.QrCode.Qr;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.QrCode.model.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;



public class QrCodeGenerated {

	public static void generatedQrCode(Student st) throws WriterException, IOException {
		String qrCodePath="C:\\Users\\ravee\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\firststsproject\\.metadata\\QR\\";
		String qrCodeName=qrCodePath+ st.getFirstName()+st.getId()+"QRCODE.png";
		var qrCodeWriter=new QRCodeWriter();
		BitMatrix bitmatrix=qrCodeWriter.encode("Id-> "+st.getId()+"\n"+
		"firstName-> "+st.getFirstName()+"\n"+"lastName-> "+st.getLastName()+"\n"+"Email id-> "+st.getEmail()+"\n"+"Mobile No.-> "+st.getMobile()
		,BarcodeFormat.QR_CODE,400,400);
		Path path=FileSystems.getDefault().getPath(qrCodeName);
		MatrixToImageWriter.writeToPath(bitmatrix, "PNG", path);
	}
}
