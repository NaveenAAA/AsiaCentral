package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;



@WebServlet(urlPatterns= "/ImageUpload")
@MultipartConfig(maxRequestSize = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 5)
public class ImageUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
			Part t = req.getPart("myFile");
		
			System.out.println(t.getSize());
			
			String path = req.getRealPath("");
			
			System.out.println( path );
			
			String imagePath = path + "/sample.jpg";
			
			File f = new File(imagePath);
			
			if( !f.exists() ) f.createNewFile();
			
		    byte[] b = new byte[ (int)t.getSize() ];
			
			t.getInputStream().read(b);
			
			FileOutputStream fos = new FileOutputStream(f);
			
			fos.write(b);
			
			fos.close();
			
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
					 "cloud_name", "dprfajsao",
					  "api_key", "851431824591627",
					  "api_secret", "YI_zbxDXLLB6tNN_8xM4-WBrU0E"));
			
			Map uploadResult = cloudinary.uploader().upload(f, ObjectUtils.emptyMap());
			
			System.out.println(uploadResult.get("secure_url"));
	}

	
}
