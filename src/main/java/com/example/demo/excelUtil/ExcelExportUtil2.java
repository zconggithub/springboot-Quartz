package com.example.demo.excelUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/**
 * 使用jxl操作Excel的工具类
 * 
 * @authorzc
 */
@Component
public class ExcelExportUtil2 {
	//表头，第一行的列====针对Friend表的相关字段，单表导出数据。数据库对应字段{编号，类型，姓名，电话，年龄，性别，月薪，年终奖，现住址，邮箱，备注，户籍}
//fname, ftel, age, sex, address,census_register, email, other
	public static final  String Friend_ROW_1[] = {"姓名","电话","年龄","性别","现住址","户籍","邮箱","备注"};
	//表头对应的字段名
	public static final String Friend_ROW_1_Keys[]={"fname","ftel","age","sex","address","census_register","email","other"};
	//列对应的数据在Map中的key
/*public static final List<String> keys=new ArrayList<String>(){
private static final long serialVersionUID = 1L;
							{add("fname");
							add("ftel");
							add("age");
							add("sex");
							add("address");
							add("census_register");
							add("email");
							add("other");
							}};*/
	/**
     * 将List集合中的对象导入到Excel文件中===>>导入到本地磁盘
     * @author ：zhoucong
     * @date ：2017年3月6日 上午9:19:16
     * @param bean
     * @param fileName
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws IOException 
     * @throws WriteException 
     */

 public static void excleOut(List<?> listData, String fileName) throws IllegalArgumentException, IllegalAccessException, WriteException, IOException {
	 ExcelExportUtil.judeDirExists();//判断本地文件夹是否存在
        //测试保存在本地
		String savaPath="E:/dataExcel/"+fileName+ ".xls";
        WritableWorkbook book = null;// 编写WritableWorkbook对象，该对象代表了excel对象
        WritableSheet sheet =null;
			book = Workbook.createWorkbook(new File(savaPath));// 创建文件路径str到本地
		/**
		 * 根据传进来的file对象创建可写入的Excel工作薄到客户端
            OutputStream os = response.getOutputStream();
            book= Workbook.createWorkbook(os);输出到客户端时候
		 */
	        sheet = book.createSheet("sheetName", 0);// 获取sheet对象，sheetName为工作表的名称
	      //创建单元格样式
	        WritableCellFormat wcf = new WritableCellFormat();
           // wcf.setBackground(jxl.format.Colour.GREEN);// 背景颜色
            wcf.setAlignment(Alignment.CENTRE); // 平行居中
            wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直居中
	        
	        // 判断一下表头数组是否有数据，并将表头数据添加到sheet中
            String[] columns=ExcelExportUtil2.Friend_ROW_1;//表头数据
            if (columns != null && columns.length > 0) {
                // 循环写入表头
                for (int i = 0; i < columns.length; i++) {
                	sheet.addCell(new Label(i, 0, columns[i], wcf));
                }
            }
          //判断集合是否有数据  
			if (listData != null && listData.size() > 0) { 
            // 对集合进行遍历
            for (int i = 0; i < listData.size(); i++) {
            	// 转换成map集合
                @SuppressWarnings("unchecked")
				Map<String, Object> map = (Map<String, Object>) listData.get(i);
             // 循环输出map中的子集：既列值
                for (int j = 0; j < columns.length; j++) {
                    sheet.addCell(new Label(j, i + 1, String.valueOf(map
                            .get(Friend_ROW_1_Keys[j]) == null ? "" : map
                            .get(Friend_ROW_1_Keys[j])),wcf));
                }
            }
			}
			//	Label la  = new Label(j, i+1, (fi[j].get(ob)) == null ? "" : String.valueOf(fi[j].get(ob)),wcf);
            
				book.write(); // 写入Exel工作表
				book.close(); // 关闭流
 }
}