import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        String details = "--------零钱通明细---------";

        double money = 0;
        double balance = 0;
        ;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String note = "";

        do {
            System.out.println("\n====零钱通菜单====");
            System.out.println("\t\t\t1  零钱通明细");
            System.out.println("\t\t\t2  收益入账");
            System.out.println("\t\t\t3  消费");
            System.out.println("\t\t\t4  退出");

            System.out.println("请选择(1--4)：");
            key = scanner.next();

            switch (key) {
                case "1":
                    System.out.println(details);
                    break;

                case "2":
                    System.out.println("2 收益入账金额:");
                    money = scanner.nextDouble();


                    if(money<=0)
                    {
                        System.out.println("收益入账金额需要大于0");
                        break;
                    }

                    balance += money;
                    date = new Date();//获取到当前的日期
//                    System.out.println(sdf.format(date));
//                    System.out.println(date);
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;

                    break;

                case "3":
                    System.out.println("3  消费金额:");
                    money = scanner.nextDouble();

                    if(money<=0||balance<money)
                    {
                        System.out.println("消费金额需要大于0且小于余额");
                        break;
                    }

                    System.out.println("消费说明");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();
                    details += "\n" + note + "\t-" +money+ "\t"+sdf.format(date) + "\t" + balance;

                    break;

                case "4":
                    //用户输入4退时，提示“用户是否要退出”
                    System.out.println("4   退出");
                    String choice  = "";
                    while(true){
                        System.out.println("你确定要退出吗？y/n");
                        choice = scanner.next();
                        if("y".equals(choice)||"n".equals(choice)){
                            break;
                        }
                    }//用户退出while后，进行判断

                    if(choice.equals("y")){
                        loop = false;
                    }

                    break;

                default:
                    System.out.println("选择有误，请重新选择");
            }

        } while (loop);

        System.out.println("-------退出了零钱通系统------");
    }
}
