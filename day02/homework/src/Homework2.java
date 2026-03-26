public class Homework2 {
    public static void main(String[] args) {
        String sql1="insert into emp values(1,'李白','男',false,10456.78,'2013-10-03'),"+
                "(2,'杜甫','男',false,109873.55,'2018-12-20'),"+
                "(3,'李商隐','男',true,8023.45,'2015-09-17'),"+
                "(4,'李清照','女',false,9086.27,'2021-04-12')";
        System.out.println(DbUtil.executeUpdate(sql1));
    }

}
