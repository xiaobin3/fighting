package com.xiaobin.example.springboot;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created with IntelliJ IDEA.
 * User: xiaobin3
 *
 * @author : xiaob
 * Email: xiaobin3@asiainfo.com
 * Date: 2018/5/29
 * Time: 19:22
 * To change this template use File | Settings | File Templates.
 */
public class NormalTest {

    @Test
    public void testStringSplit(){
        String sql = "select ROWID,t.* from {TABLENAME} where a=b and c in (select id from b where 1=2) and {condition}";
        sql = sql.replace("where","WHERE").replace("and","AND");
        String sqlAfter = StringUtils.substringAfter(sql,"WHERE");
        System.out.println("======截取where后面的====="+sqlAfter);
        int i = sqlAfter.lastIndexOf("and");
        System.out.println("=and="+i);
        String sqlReplace = StringUtils.substringBeforeLast(sqlAfter,"AND");
        System.out.println("====去掉分片后==="+sqlReplace);
        String newsql = "DELETE FROM TABLENAME where "+sqlReplace;
        System.out.println(newsql);
    }
}
