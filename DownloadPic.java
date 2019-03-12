package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DownloadPic {
	/*
	 * download file from url
	 */
	public static void downloadFromUrl(String fileName, String urlPath, String savePath) throws IOException{
		URL url = new  URL(urlPath);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(3000);
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		InputStream inputstream = conn.getInputStream();
		byte[] indata = bytegenerate(inputstream);
		File saver = new File(savePath);
		if(!saver.exists())
			saver.mkdir();
		File file = new File(savePath+File.separator+fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(indata);
		if(fos!=null)
			fos.close();
		if(inputstream!=null)
			inputstream.close();
		
		System.out.println(url+"download finished. ");
	}
	/*
	 * stream2byte[]
	 */
	public static byte[] bytegenerate(InputStream inputstream) throws IOException {
		byte[] newByte = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while((len = inputstream.read(newByte)) != -1) {  
            bos.write(newByte, 0, len);  
        }  
        bos.close();  
        return bos.toByteArray();  
	}
	
	/*
	 * Show picture
	 */
	public static void showPic(String Picpath){
		JFrame frame = new JFrame();
		//frame.setSize(400,500);
		JPanel pl=new JPanel();
		JLabel Jl=new JLabel();
		ImageIcon icon=new ImageIcon(Picpath);
		Jl.setIcon(icon);
		pl.add(Jl);
		frame.add(pl);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	/*
	 * Main download
	 */
	public static void main(String args[]) throws IOException{
		try{
			Logger logger = Logger.getLogger("src.test.DownloadPic");
			logger.setLevel (Level.FINE);
			logger.setUseParentHandlers(false);
		    FileHandler handler = new FileHandler();
		    logger.addHandler(handler);
		}catch(IOException e){
			 System.out.println(e);;
		}
		downloadFromUrl("Pic.jpg","http://user-gold-cdn.xitu.io/2018/12/13/167a6636b300c41b?w=600&h=600&f=jpeg&s=19857",
				"G:/");
		showPic("G:/Pic.jpg");
	}

}
