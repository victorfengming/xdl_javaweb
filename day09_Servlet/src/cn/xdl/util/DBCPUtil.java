package cn.xdl.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtil {

	private static DataSource dataSource;

	static {
		//在类加载时, 读取配置文件, 配置连接池
		//1.	创建Properites对象
		Properties ppt = new Properties();
		//2.	读取配置文件,
		InputStream is = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
		//3.	将配置文件 加载到Properties对象中
		try {
			ppt.load(is);
		//4.	通过连接池工厂类, 创建连接池
			dataSource = BasicDataSourceFactory.createDataSource(ppt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用于从连接池中 获取一个连接对象
	 * @return 连接对象 , 如果获取失败返回null
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 用于释放资源
	 * @param conn	连接对象
	 * @param state 执行环境
	 * @param result 结果集
	 */
	public static void close(Connection conn , Statement state ,ResultSet result) {
		if(result!=null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(state!=null) {
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




}
