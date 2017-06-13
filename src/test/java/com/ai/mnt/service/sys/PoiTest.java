package com.ai.mnt.service.sys;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ai.mnt.model.sec.Fxdjpgzbtx;
import com.ai.mnt.service.sec.FxdjpgzbtxService;

/*@RunWith(SpringJUnit4ClassRunner.class) //整合
@ContextConfiguration(locations={"classpath:/applicationContext.xml",
                                "classpath:/spring-mvc.xml"}) //加载配置
*/

public class PoiTest {
 public static ApplicationContext act = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        act = new ClassPathXmlApplicationContext("spring-core.xml");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


@Test
public void safeEval()throws FileNotFoundException, IOException, ParseException, IllegalArgumentException, IllegalAccessException{
    Long id = 1l;
    FxdjpgzbtxService fxdjpgzbtxService = act.getBean(FxdjpgzbtxService.class);
    Fxdjpgzbtx fxdjpgzbtx = fxdjpgzbtxService.searchOne(id);  //根据id查找到数据
    
    Class cls = (Class)fxdjpgzbtx.getClass();
    Field[] flds = cls.getDeclaredFields();  //反射获取对象的属性以及值。
    
    HSSFWorkbook wb = new HSSFWorkbook();  
    HSSFSheet sheet1=wb.createSheet("危险物料标准分");   //设置表名
    HSSFSheet sheet2=wb.createSheet("工艺参数标准分");  
    HSSFSheet sheet3=wb.createSheet("安全控制标准分");  
    sheet1.autoSizeColumn(1, true);                // 内容自适应
    sheet2.autoSizeColumn(1, true);
    sheet3.autoSizeColumn(1, true);
    HSSFRow row1 = sheet1.createRow((short)0);    //创建一行
    HSSFRow row2 = sheet2.createRow((short)0);    //创建一行
    HSSFRow row3 = sheet3.createRow((short)0);    //创建一行
    
    int curRow1 = 0;
    int curRow2 = 0;
    int curRow3 = 0;
        for ( int i = 0; i < flds.length; i++ )  
        {  
            flds[i].setAccessible(true);
            if(!flds[i].get(fxdjpgzbtx).equals("0")){
                
                if(flds[i].getName().equals("wxwlbzf")){
                    row1.createCell(curRow1++).setCellValue("危险物料标准分");
                }else if (flds[i].getName().equals("gycsbzf")) {
                    row2.createCell(curRow2++).setCellValue("工艺参数标准分");
                }else if (flds[i].getName().equals("aqkzbzf")) {
                    row3.createCell(curRow3++).setCellValue("安全控制标准分");
                    
                }else if (flds[i].getName().equals("wlwxxbzf")) {
                    row1.createCell(curRow1++).setCellValue("物料危险性标准分");
                }else if (flds[i].getName().equals("wlwxxqz")) {
                    row1.createCell(curRow1++).setCellValue("物料危险性权重");
                }else if (flds[i].getName().equals("rlwxxbzf")) {
                    row1.createCell(curRow1++).setCellValue("燃料危险性标准分");
                }else if (flds[i].getName().equals("rlwxxqz")) {
                    row1.createCell(curRow1++).setCellValue("燃料危险性权重");
                }else if (flds[i].getName().equals("bzwxxbz")) {
                    row1.createCell(curRow1++).setCellValue("爆炸危险性标准分");
                }else if (flds[i].getName().equals("bzwxxqz")) {
                    row1.createCell(curRow1++).setCellValue("爆炸危险性权重");
                }else if (flds[i].getName().equals("wzdhxbzf")) {
                    row1.createCell(curRow1++).setCellValue("物质毒害性标准分");
                }else if (flds[i].getName().equals("wzdhxqz")) {
                    row1.createCell(curRow1++).setCellValue("物质毒害性权重");
                }else if (flds[i].getName().equals("wzfsxbzf")) {
                    row1.createCell(curRow1++).setCellValue("物质腐蚀性标准分");
                }else if (flds[i].getName().equals("wzfsxqz")) {
                    row1.createCell(curRow1++).setCellValue("物质腐蚀性权重");
                    
                }else if (flds[i].getName().equals("fyrxsbzf")) {
                    row2.createCell(curRow2++).setCellValue("反应热系数标准分");
                }else if (flds[i].getName().equals("fyrxsqz")) {
                    row2.createCell(curRow2++).setCellValue("反应热系数权重");
                }else if (flds[i].getName().equals("clbzf")) {
                    row2.createCell(curRow2++).setCellValue("储量标准分");
                }else if (flds[i].getName().equals("clqz")) {
                    row2.createCell(curRow2++).setCellValue("储量权重");
                }else if (flds[i].getName().equals("wdbzf")) {
                    row2.createCell(curRow2++).setCellValue("温度标准分");
                }else if (flds[i].getName().equals("wdqz")) {
                    row2.createCell(curRow2++).setCellValue("温度权重");
                }else if (flds[i].getName().equals("ylbzf")) {
                    row2.createCell(curRow2++).setCellValue("压力标准分");
                }else if (flds[i].getName().equals("ylqz")) {
                    row2.createCell(curRow2++).setCellValue("压力权重");
                }else if (flds[i].getName().equals("llbzf")) {
                    row2.createCell(curRow2++).setCellValue("流量标准分");
                }else if (flds[i].getName().equals("llqz")) {
                    row2.createCell(curRow2++).setCellValue("流量权重");
                }else if (flds[i].getName().equals("jbslbzf")) {
                    row2.createCell(curRow2++).setCellValue("搅拌速率标准分");
                }else if (flds[i].getName().equals("jbslqz")) {
                    row2.createCell(curRow2++).setCellValue("搅拌速率权重");
                }else if (flds[i].getName().equals("hylbzf")) {
                    row2.createCell(curRow2++).setCellValue("氧含量标准分");
                }else if (flds[i].getName().equals("hylqz")) {
                    row2.createCell(curRow2++).setCellValue("氧含量权重");
                }else if (flds[i].getName().equals("qtcsbzf")) {
                    row2.createCell(curRow2++).setCellValue("其它参数标准分");
                }else if (flds[i].getName().equals("qtcsqz")) {
                    row2.createCell(curRow2++).setCellValue("其它参数权重");
                }
                else if (flds[i].getName().equals("wdcsbjbzf")) {
                    row3.createCell(curRow3++).setCellValue("温度参数报警标准分");
                }else if (flds[i].getName().equals("wdcsbjqz")) {
                    row3.createCell(curRow3++).setCellValue("温度参数报警权重");
                }else if (flds[i].getName().equals("jlblkzbzf")) {
                    row3.createCell(curRow3++).setCellValue("进料比例控制标准分");
                }else if (flds[i].getName().equals("jlblkzqz")) {
                    row3.createCell(curRow3++).setCellValue("进料比例控制权重");
                }else if (flds[i].getName().equals("jjlqxtbzf")) {
                    row3.createCell(curRow3++).setCellValue("紧急冷却系统标准分");
                }else if (flds[i].getName().equals("jjlqxtqz")) {
                    row3.createCell(curRow3++).setCellValue("紧急冷却系统权重");
                }else if (flds[i].getName().equals("jbwdkzbzf")) {
                    row3.createCell(curRow3++).setCellValue("搅拌温度控制标准分");
                }else if (flds[i].getName().equals("jbwdkzqz")) {
                    row3.createCell(curRow3++).setCellValue("搅拌温度控制权重");
                }else if (flds[i].getName().equals("aqxfxtbzf")) {
                    row3.createCell(curRow3++).setCellValue("安全泄放系统标准分");
                }else if (flds[i].getName().equals("aqxfxtqz")) {
                    row3.createCell(curRow3++).setCellValue("安全泄放系统权重");
                }else if (flds[i].getName().equals("krydqtjcbzf")) {
                    row3.createCell(curRow3++).setCellValue("可燃有毒气体检测标准分");
                }else if (flds[i].getName().equals("krydqtjcqz")) {
                    row3.createCell(curRow3++).setCellValue("可燃有毒气体检测权重");
                }else if (flds[i].getName().equals("jjtczzbzf")) {
                    row3.createCell(curRow3++).setCellValue("紧急停车装置标准分");
                }else if (flds[i].getName().equals("jjtczzqz")) {
                    row3.createCell(curRow3++).setCellValue("紧急停车装置权重");
                }else if (flds[i].getName().equals("qtaqkzbzf")) {
                    row3.createCell(curRow3++).setCellValue("其它安全控制标准分");
                }else if (flds[i].getName().equals("qtaqkzqz")) {
                    row3.createCell(curRow3++).setCellValue("其它安全控制标权重");
                }
            }
        }
        
        FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
        wb.write(output);
        output.close();
        
        /*OutputStream output=response.getOutputStream();
        response.reset();   // 浏览器弹出保存框，前端不要用ajax，会占用流，
        response.setHeader("Content-disposition", "attachment; filename=details_"+String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", System.currentTimeMillis()) + ".xls");  
        response.setContentType("application/vnd.ms-excel;charset=gb2312 ");
        wb.write(output);
        output.close();*/
}

public void calExecel(){
    Workbook wb = null;
   // WorkbookFactory.create()

}

}
