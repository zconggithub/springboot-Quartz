package com.example.demo.dataExport;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.example.demo.bean.Friend;
import com.example.demo.excelUtil.ExcelExportUtil;

import ch.qos.logback.classic.Logger;
//单个表导出数据①====》通过POI导出
public class FriendExport {
	
	
	//表头，第一行的列====针对Friend表的相关字段，单表导出数据
	public static final  String Friend_ROW_1[] =  {"姓名","电话","年龄","性别","现住址","户籍","邮箱","备注"};
	 //第一行数据表头填充
	public static void createSheetHeader(HSSFRow row0,HSSFSheet sheet,String[] firstRowColumns){
                for (int i = 0; i < firstRowColumns.length; i++) {
                	row0.createCell(i).setCellValue(firstRowColumns[i]);
				} 
	}
	
	public static void FriendExcel(List<Friend> listData)
            throws IOException, ParseException {
		String fileName="Friend信息表";
		
		HSSFWorkbook workbook = new HSSFWorkbook();//创建工作簿
		 // cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
         HSSFSheet sheet = workbook.createSheet(fileName);//创建第一张表
		sheet.setAutobreaks(true); // 根据长度自动调整单元格宽度 
         HSSFRow row0= sheet.createRow(0);//创建第一行
         FriendExport.createSheetHeader(row0, sheet, Friend_ROW_1);//第一行数据表头填充
         HSSFRow rowNew =null;
         int j=1;//行数
         for(int i =0; i < listData.size(); i++){
        	 rowNew = sheet.createRow(j); //创建行数
        	 rowNew.createCell(0).setCellValue(listData.get(i).getFname());
        	 rowNew.createCell(1).setCellValue(listData.get(i).getFtel());
        	 rowNew.createCell(2).setCellValue(listData.get(i).getAge()==null?"":listData.get(i).getAge().toString());
        	
        	 rowNew.createCell(3).setCellValue(listData.get(i).getSex());
        	 rowNew.createCell(4).setCellValue(listData.get(i).getAddress());
        	 rowNew.createCell(5).setCellValue(listData.get(i).getCensusRegister());
        	 rowNew.createCell(6).setCellValue(listData.get(i).getEmail());
        	 rowNew.createCell(7).setCellValue(listData.get(i).getOther());
        	 j++;
         }
         //ExcelExportUtil.ExcelExport(response, fileName, workbook);//通过浏览器提醒保存到客户端
         ExcelExportUtil.ExcelExportLocal(workbook,fileName);//保存在电脑磁盘
         //ExcelExportUtil.ExcelExportZip(response, fileName, workbook);//zip形式保存
	}
   
	
	
	
  
 


}
