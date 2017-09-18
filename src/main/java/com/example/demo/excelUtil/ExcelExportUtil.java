package com.example.demo.excelUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * @author zhoucong 
 *数据导出保存地方工具类
 */
public class ExcelExportUtil {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
	static String time=dateFormat.format(Calendar.getInstance().getTime());
	//数据导出到客户端
	public static void ExcelExport(HttpServletResponse response,String fileName,HSSFWorkbook workbook) throws IOException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time=dateFormat.format(Calendar.getInstance().getTime());
		//保存在客户端
        response.setContentType("application/msexcel;charset=UTF-8");  
		response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(fileName+time, "UTF-8")+".xls");
		response.setCharacterEncoding("UTF-8");
        //通过Response把数据以Excel格式保存  
		OutputStream out = null;
        try {  
            //创建输出流对象   
             out = response.getOutputStream();  
            //将创建的Excel对象利用二进制流的形式强制输出到客户端去  
            workbook.write(out);  
             
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        finally {
        	if (out != null) {
        		 out.flush();  
                 out.close(); 
			}
		}
	}
	
	//数据导出到本地电脑
	public static void ExcelExportLocal(HSSFWorkbook workbook,String fileName) throws IOException{
		
		ExcelExportUtil.judeDirExists();//判断本地文件夹是否存在
        //测试保存在本地
		String savaPath="E:/dataExcel/"+fileName+time + ".xls";
		FileOutputStream fout =null;
         try 
                { 
         fout = new FileOutputStream(savaPath); 
            workbook.write(fout); 
            fout.close(); 
                } 
          catch (Exception e) 
          { 
            e.printStackTrace(); 
           } finally {
        	   if (fout != null) {
          		 fout.flush();  
                   fout.close(); 
  			}
		}

	}

	//数据压缩包形式保存
    public static void ExcelExportZip(HttpServletResponse response,String fileName,HSSFWorkbook workbook) throws IOException{
         response.setContentType("application/octet-stream");
         response.setHeader("Content-disposition", "attachment;filename=export.zip");
         OutputStream out = response.getOutputStream();
         ZipOutputStream zip = new ZipOutputStream(out);
         ZipEntry entry = new ZipEntry(fileName + ".xls");
         zip.putNextEntry(entry);
         workbook.write(zip);
         zip.flush();
         zip.close();
         out.close();
         
    }

 
 // 判断文件夹是否存在
public static void judeDirExists(){
	File file = new File("E:\\dataExcel");
	if  (!file .exists()  && !file .isDirectory()) {
		file .mkdir();
}
}
}
