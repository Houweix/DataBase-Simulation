import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *  数据库主函数
 *  数据字典的组成：
     1、数据项
     2、数据结构
     3、数据流
     4、数据存储
     5、处理过程

 */



public class DBMain {

    //创建
    String sqlcreate = "create table \\w+ \\(.+\\)";
    //插入
    String sqlinsert = "insert into (\\w+) \\((.+)\\) values\\((.+)\\)";
    //修改
    String sqlupdate = "update .+set .+(where .+)?";
    //删除
    String sqldelete = "delete from (\\w+) where .+";
    //显示数据库结构和内容
    String sqlselect = "select \\* from (\\w+)";


    /*
    *   测试语句
    *   create table student (s_name char,id int)
    *   insert into student (s_name,id) values('houwei','2015')
    *
    *
    *
    * */


    public static void main(String[] args) throws IOException {
        System.out.println("欢迎使用数据库系统");
        while(true) {
            BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
            String sql = brd.readLine();
            if(sql.matches("quit")||sql.matches("QUIT")){
                System.out.println("欢迎下次使用，再见！\n");
                break;
            }
            DBMain db = new DBMain();
            db.login(sql);
        }
    }

    public void login(String s) throws IOException{

        if(s.matches(sqlcreate)){
            Create.Create(s);
        }else if(s.matches(sqlinsert)){
            Insert.Insert(s);
        }else {
            System.out.println("输入的语句有错误");
        }
    }
}