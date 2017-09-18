package com.example.demo.excelUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * 使用jxl操作Excel的工具类
 * @author zhoucong
s */

public class ExcelImportUtil {
	
	//Excel表头对应的数据库列名
	public static final  String Friend_ROW_1_Keys[] = {"fname","ftel","age","sex","address","census_register","email","other"};

	/**fname, ftel, age, sex, address,census_register, email, other
	 * 
	 * 将Excel 中的数据导入到List<Map<String, Object>>中 说明：只支持 xls后缀结尾的excel文件（Excel 2003）
	 * @param input
	 *            指定excel文件输入流
	 * @param index
	 *            工作博的序号 (从0开始)
	 * @param columnName
	 *            (注意：顺序需要保持一致) : 列名称（对应数据库中的字段） 如果想用excel中原始的列名称，只需传入null即可
	 */

	public static List<Map<String, Object>> getDataFromExcel(InputStream input, Integer index, String[] columnName) {
		// 定义文本簿
		Workbook rwb = null;
		// 定义容器
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 定义容器存储列名称
		List<String> columnList = new ArrayList<String>();
		try {
			rwb = Workbook.getWorkbook(input);
			if (index == null || index > rwb.getSheets().length || index < 0) {
				index = 0;
			}
			// 获得第一个工作表对象
			Sheet sheet = rwb.getSheet(index);
			int rows = sheet.getRows();
			int columns = sheet.getColumns();
			for (int i = 1; i < rows; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int j = 0; j < columns; j++) {
					// 表示获取第i行第j列
					Cell cell = sheet.getCell(j, i);
					String result = cell.getContents();
					// 存储列名称
					if (i == 0 && columnName == null) {
						columnList.add(result);
					} else {
						if (columnName == null) {
							map.put(columnList.get(j), result);
						} else {
							map.put(columnName[j], result);
						}
					}
				}
				if (i != 0) {
					list.add(map);
				}
			}
		} catch (BiffException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rwb != null) {
				rwb.close();
			}
		}
		return list;
	}


}