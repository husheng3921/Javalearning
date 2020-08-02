package com.hs.pattern.callback;

import java.sql.*;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/23/0023 10:23
 * @email husheng3921@163.com
 */
public class JdbcDemo {
    public class User{
        private Long id;
        private String name;
        private String telephone;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public User() {
        }
    }
    public User queryUser(long id){
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc://127.0.0.1:3306/demo","root","hs3921");

            //创建statement类对象，用来执行SQL语句
            stmt = conn.createStatement();


            //ResultSet类，用来存放结果集
            String sql = "select * from user where id ="+id;//容易SQL注入
            String sqlPre = "select * from user where id = ?";
            preparedStatement = conn.prepareStatement(sqlPre);
            preparedStatement.setLong(1,id);//从1开始编号
            ResultSet resultSet = preparedStatement.executeQuery();
            //打印SQL语句
            /**
             * prepareStatement会对用户输入的的单引号用\反斜杆做转义，从而防止SQL注入
             * prepareStatement的setString(int parameterIndex,String x)对单引号作转义？
             */
            System.out.println("sql="+ preparedStatement.toString());

            ResultSet resultSet1 = stmt.executeQuery(sql);
            while (resultSet1.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setTelephone(resultSet.getString("telephone"));
                return user;
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.getErrorCode();
        }finally {
            if (conn != null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.getErrorCode();
                }
                if (stmt != null){
                    try {
                        stmt.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        }



        return null;
    }
}
