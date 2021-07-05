
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class DccnClient {
    static Socket sr;
    static Scanner  inp = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[2004];
        byte[] b2 = new byte[2004];
        byte[] b3 = new byte[2004];

        sr = new Socket("localhost", 4444);
        System.out.println("Connected to the server.");
        InputStream i = sr.getInputStream();
        File file = new File("ground.txt");

        InputStream in = new FileInputStream(file);
        OutputStream out = sr.getOutputStream();

        int i1;
        while ((i1 = in.read(b)) >0    ) {
            out.write( b , 0 , i1);
        }
        while ((i1 = in.read(b2)) >0    ) {
            out.write( b2 , 0 , i1);
        }
        while ((i1 = in.read(b3)) >0    ) {
            out.write( b3 , 0 , i1);
        }
        in.close();

        String[] ground = new String[200];
        String[] memb = new String[200];
        String[] book = new String[200];
        for(int k=0 ; k<ground.length; k+=4) {
            if(ground[k]!=null)
                System.out.println(ground[k] + " " + ground[k + 1] + " " + ground[k + 2] + " " + ground[k + 3]);
        }
        System.out.println("-----WELCOME TO Sport Complex MANAGEMENT SYSTEM----");
        while (true) {
            while (true) {
                filetoarray(ground, "ground.txt");
                filetoarray(memb, "member.txt");
                filetoarray(book, "books.txt");
                int index = indexfinder(ground);
                int index2 = indexfinder(memb);
                int index3 = indexfinder(book);
                if (index != -1 && index2 != -1 && index3 != -1) break;
                ground = dynamic(ground);
                memb = dynamic(memb);
                book = dynamic(book);
            }
            int choice;
            while (true) {
                System.out.println("============================================");
                try {
                    System.out.println("For ground information enter 1 \nFor member record enter 2 \nFor Sales menu enter 3 \nTo exit press 4");
                    choice = inp.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("add integer only");
                    inp.nextLine();
                }
            }
            if (choice == 4) {
                System.out.println("exiting");
                break;
            }
            switch (choice) {
                case 1:
                    record("ground information", ground, memb, book);
                    break;
                case 2:
                    record("members", memb, book, ground);
                    break;
                case 3:
                    record("booking", book, memb, ground);
                    break;
                default:
                    System.out.println("invalid input");
            }
        }
    }
    public static void record(String s , String[] s1,String[] s2,String[] s3) throws IOException{
        if(s.equals("ground information") || s.equals("members")){
        while(true){
            int choice ;
            while(true){
                System.out.println("====================================");
                try{
                    System.out.printf("To add %s press 1 \nTo view %s press 2 \nTo edit %s press 3 \nTo Search %s press 4 \nTo delete %s press 5 \nTo exit press 6\n",s,s,s,s,s);
                    choice = inp.nextInt();
                    break;
                }
                catch(Exception e){
                    System.out.println("enter integer only");
                    inp.nextLine();
                }
            }
            if (choice == 6){System.out.println("exiting");break;}
            switch(choice){
                case 1 : add(s,s1);break;
                case 2 : view(s,s1);break;
                case 3 : edit(s,s1);break;
                case 4 : search(s,s1);break;
                case 5 : delete(s,s1);break;
                default: System.out.println("invalid input");break ; 
             }
        }
        }
        else{
            while(true){
            int choice ;
            while(true){
                try{
                    System.out.printf("To add %s press 1 \nTo view %s press 2 \nTo exit press 3\n",s,s);
                    choice = inp.nextInt();
                    break;
                }
                catch(Exception e){
                    System.out.println("enter integer only");
                    inp.nextLine();
                }
            }
            if (choice == 3){System.out.println("exiting");break;}
            switch(choice){
                case 1 : add2(s,s1,s2,s3);break;
                case 2 : view2(s1);break;
                default: System.out.println("invalid input");break ; 
             }
        }
            
        }
    }
    public static void add(String s , String[] s1) throws IOException{
        int i = indexfinder(s1);
        switch(s){
            case "ground information":
                while(true){
                    String ID , name , num;
                    inp.nextLine();
                    while(true){
                        while(true){
                            System.out.println("enter ground ID");
                            ID=inp.nextLine();
                            if(numcheck(ID))break;
                            else System.out.println("Enter numbers only");
                        }
                    if(counter(ID,s1,0)==0)break;
                    else System.out.println("ID already present enter again");
                    }
                    s1[i]=ID;
                    while(true){
                            System.out.println("enter ground name");
                            name=inp.nextLine();
                            name=name.replaceAll(" ", "");
                            if(alphacheck(name))break;
                            else System.out.println("Enter Alphabets only");
                        }
                    s1[i+1]=name;
                    while(true){
            System.out.println("enter slots available");
            num=inp.nextLine();
            if(numcheck(num))break;
            else System.out.println("Enter numbers only");
        }
                    s1[i+2]=num;
                    while(true){
            System.out.println("enter ground price");
            num=inp.nextLine();
            if(numcheck(num))break;
            else System.out.println("Enter numbers only");
        }
                    s1[i+3]=num;
                    writeMGfile(s1,"ground.txt");
                    i+=4;
                    
                    int k ;
                    while(true){
                try{
                    System.out.println("enter 0 to exit or other to continue");
                    k = inp.nextInt();
                    break;
                }
                catch(Exception e){
                    System.out.println("add integer only");
                    inp.nextLine();
                }
            }
                    if(k==0)break;
                };break;
            case "members":
                while(true){
                    String ID,name,num;
                    inp.nextLine();
                    while(true){
                    while(true){
                            System.out.println("enter member ID");
                            ID=inp.nextLine();
                            if(numcheck(ID))break;
                            else System.out.println("Enter numbers only");
                        }
                    if(counter(ID,s1,0)==0)break;
                    else System.out.println("ID already present enter again");
                    }
                    s1[i]=ID;
                   while(true){
                            System.out.println("enter member name");
                            name=inp.nextLine();
                            name=name.replaceAll(" ", "");
                            if(alphacheck(name))break;
                            else System.out.println("Enter Alphabets only");
                        }
            s1[i+1]=name;
            while(true){
            System.out.println("enter member age");
            num=inp.nextLine();
            if(numcheck(num))break;
            else System.out.println("Enter numbers only");
        }
                    s1[i+2]=num;
                    while(true){
                            System.out.println("enter member city");
                            name=inp.nextLine();
                            name=name.replaceAll(" ", "");
                            if(alphacheck(name))break;
                            else System.out.println("Enter Alphabets only");
                        }
                    s1[i+3]=name;
                    i+=4;
                    writeMGfile(s1,"member.txt");
                    int k ;
                    while(true){
                try{
                    System.out.println("enter 0 to exit or other to continue");
                    k = inp.nextInt();
                    break;
                }
                catch(Exception e){
                    System.out.println("add integer only");
                    inp.nextLine();
                }
            }
                    if(k==0)break;
                };break;
            default : System.out.println("invlid");
        }
    }
    public static void add2(String s , String[] s1,String[] s2,String[] s3) throws IOException{
        if(indexfinder(s2)!=0 && indexfinder(s3)!=0){
            int i = indexfinder(s1);
            while(true){
                String ID,num,bill;
                inp.nextLine();
                while(true){
                    while(true){
                        System.out.println("enter member ID");
                        ID=inp.nextLine();
                        if(numcheck(ID))break;
                        else System.out.println("Enter numbers only");
                    }
                    if(counter(ID,s2,0)==1)break;
                    else System.out.println("ID not found");
                }
                s1[i]=ID;
                int in = index(s1[i],s2);
                s1[i+1]=s2[in+1];
                while(true){
                    while(true){
                        System.out.println("enter ground ID");
                        ID=inp.nextLine();
                        if(numcheck(ID))break;
                        else System.out.println("Enter numbers only");
                    }
                    if(counter(ID,s3,0)==1)break;
                    else System.out.println("ID not found");
                }
                s1[i+2]=ID;
                in = index(s1[i+2],s3);
                s1[i+3]=s3[in+1];
                while(true){
                    System.out.println("enter slots to book");
                    num=inp.nextLine();
                    if(numcheck(num)){
                        bill=bill(in,num,s3);
                        if(bill.equals("out of stock")){
                            System.out.println("reduce your entered slots \nTime slot available="+s3[in+2]);
                        }
                        else break;
                    }
                    else System.out.println("Enter numbers only");
                }
                s1[i+4]=num;
                System.out.println("bill = "+bill);
                s1[i+5]=bill;
                writeBookfile(s1,"books.txt");
                i+=6;
                int k ;
                    while(true){
                try{
                    System.out.println("enter 0 to exit or other to continue");
                    k = inp.nextInt();
                    break;
                }
                catch(Exception e){
                    System.out.println("add integer only");
                    inp.nextLine();
                }
            }
                if(k==0)break;
            }
        }
        else System.out.println("Add member and ground Record first");
    }
    
    public static void view(String s , String[] s1){
        if(indexfinder(s1)!=0){
        if(s.equals("ground information")){
            System.out.println(" ID | ground Name    | slots | price");
            String[] s2 = sorter(s1);
            for (int i = 0 ; i<indexfinder(s1)-1 ; i+=4){
                if(s1[i].equals("xxx")==false){
                System.out.printf("%3s | %12s |   %4s   | %4s\n",s2[i],s2[i+1],s2[i+2],s2[i+3]);}}
        } 
        if(s.equals("members")){
            System.out.println(" ID  | first Name |  age |    city");
            String[] s2 = sorter(s1);
            for (int i = 0 ; i<indexfinder(s1)-1 ; i+=4){
                if(s1[i].equals("xxx")==false){
                System.out.printf("%3s  |%10s  | %3s  |%10s\n",s2[i],s2[i+1],s2[i+2],s2[i+3]);
                }
            } 
        }
    }
        else System.out.println("Enter Record First");
    }
    public static void view2( String[] s1){
         if(indexfinder(s1)!=0 ){
         System.out.println(" member |   member   |  ground |    ground    | slots  |     ");
         System.out.println("   ID   |     Name   |   ID    |     name     | booked | Bill");
            for (int i = 0 ; i<indexfinder(s1)-1 ; i+=6){
                if(s1[i].equals("xxx")==false){
                    System.out.printf("   %3s  |%10s  |   %3s   | %12s |  %3s   |%5s\n",s1[i],s1[i+1],s1[i+2],s1[i+3],s1[i+4],s1[i+5]);}}
     }
         else System.out.println("Add Sales Record first");
     }

    public static void edit(String s , String[] s1) throws IOException{
        if(indexfinder(s1)!=0 ){
        inp.nextLine();
        String ID ;
        while(true){
            System.out.printf("Enter ID of %s to edit\n",s);
            ID=inp.nextLine();
            if(numcheck(ID))break;
            else System.out.println("Enter numbers only");
        }
        int i = index(ID,s1);
        if(i!=-1 && s.equals("ground information")){
            String name,num;
            while(true){
                            System.out.println("enter ground name");
                            name=inp.nextLine();
                            name=name.replaceAll(" ", "");
                            if(alphacheck(name))break;
                            else System.out.println("Enter Alphabets only");
                        }
                    s1[i+1]=name;
                    while(true){
            System.out.println("enter slots");
            num=inp.nextLine();
            if(numcheck(num))break;
            else System.out.println("Enter numbers only");
        }
                    s1[i+2]=num;
                    while(true){
            System.out.println("enter ground price");
            num=inp.nextLine();
            if(numcheck(num))break;
            else System.out.println("Enter numbers only");
        }
                    s1[i+3]=num;
                    writeMGfile(s1,"ground.txt");
        }
        else if(i!=-1 && s.equals("members")){
            String name,num;
            while(true){
                            System.out.println("enter member name");
                            name=inp.nextLine();
                            name=name.replaceAll(" ", "");
                            if(alphacheck(name))break;
                            else System.out.println("Enter Alphabets only");
                        }
            s1[i+1]=name;
            while(true){
            System.out.println("enter member age");
            num=inp.nextLine();
            if(numcheck(num))break;
            else System.out.println("Enter numbers only");
        }
                    s1[i+2]=num;
                    while(true){
                            System.out.println("enter member city");
                            name=inp.nextLine();
                            if(alphacheck(name))break;
                            else System.out.println("Enter Alphabets only");
                        }
                    s1[i+3]=name;
                    writeMGfile(s1,"member.txt");
        }
        else System.out.println("invalid ID");
        }
        else System.out.println("Enter Record First");
        
    }
    public static void search(String s , String[] s1){
        if(indexfinder(s1)!=0){
        inp.nextLine();
        String ID ;
        while(true){
            System.out.printf("Enter ID of %s to search\n",s);
            ID=inp.nextLine();
            if(numcheck(ID))break;
            else System.out.println("Enter numbers only");
        }
        int i = index(ID,s1);
        if(i!=-1 && s.equals("ground information")){
            System.out.println("ground  Name     = "+s1[i+1]);
            System.out.println("ground  slots = "+s1[i+2]);
            System.out.println("ground  price    = "+s1[i+3]);
        }
        else if(i!=-1 && s.equals("members")){
            System.out.println("member Name = "+s1[i+1]);
            System.out.println("member Age  = "+s1[i+2]);
            System.out.println("member city = "+s1[i+3]);
        }
        else System.out.println("Invalid ID");
    }
        else System.out.println("Enter Record first");
    }
    public static void delete(String s , String[] s1) throws IOException{
        if(indexfinder(s1)!=0 ){
        inp.nextLine();
        String ID ;
        while(true){
            System.out.printf("Enter ID of %s to delete record",s);
            ID=inp.nextLine();
            if(numcheck(ID))break;
            else System.out.println("Enter numbers only");
        }
        int i = index(ID,s1);
        if(i!=-1 ){
            s1[i]="xxx";
            s1[i+1]="xxx";
            s1[i+2]="xxx";
            s1[i+3]="xxx";
            //shifter(s1);
            if(s.equals("members")){
                
                writeMGfile(s1,"member.txt");
            }
            else{
                writeMGfile(s1,"ground.txt");
            }
            System.out.println("Record Deleted");
        }
        else System.out.println("Invalid ID");
    }
        else System.out.println("Enter Record first");
    }
    public static void filetoarray(String[] s1,String fx) throws IOException{
        String line = "";
        String[] values={};
        try{
            int i=0,j;
            BufferedReader br  = new BufferedReader(new FileReader(fx));
            while((line = br.readLine())!= null ){
                j=0;
                values = line.split("\t");
                for(;i<300&&j<values.length;i++) {
                    if(values[j]!=null)
                        s1[i]=values[j];
                    j++;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
     }
 
    public static int indexfinder(String[] s1 ){
        for (int i = 0 ; i<s1.length ; i++){
            if(s1[i]==null)return i;
        }
        return -1;
    }
    public static String[] dynamic(String [] s){
        String[] s1 = new String[s.length+360];
        for(int i = 0 ; i < s.length ; i++){
            s1[i]=s[i];
        }
        return s1;
        
    }
    public static int index(String s,String[] s1){
        for(int i = 0; i <s1.length ; i+=4){
            if(s.equals(s1[i]))return i ; 
        }
        return -1;
    }
    public static void writeMGfile(String[] s1,String fx) throws IOException{
        File f = new File(fx);
        BufferedWriter bf = new BufferedWriter(new FileWriter(f));
        if (f.exists()) {
            for (int i = 0; i < s1.length; i += 7) {
                if (s1[i] == null) {
                    continue;
                } else {
                     bf.write(s1[i] + "\t");
                        bf.write(s1[i + 1] + "\t");
                        bf.write(s1[i + 2] + "\t");
                        bf.write(s1[i + 3] + "\t");
                        bf.newLine();
                }
            }
        }
        bf.close();
    }
    public static void writeBookfile(String[] s1,String fx) throws IOException{
        File f = new File(fx);
        BufferedWriter bf = new BufferedWriter(new FileWriter(f));
        if (f.exists()) {
            for (int i = 0; i < s1.length; i += 7) {
                if (s1[i] == null) {
                    continue;
                } else {
                    bf.write(s1[i]+"\t");
                    bf.write(s1[i+1]+"\t");
                    bf.write(s1[i+2]+"\t");
                    bf.write(s1[i+3]+"\t");
                    bf.write(s1[i+4]+"\t");
                    bf.write(s1[i+5]);
                    bf.newLine();
                }
            }
        }
        bf.close();
    }
    public static String bill(int i ,String s, String [] s1) throws IOException{
    int demand , supply , bill , price;
    demand = Integer.parseInt(s);
    supply = Integer.parseInt(s1[i+2]);
    price = Integer.parseInt(s1[i+3]);
    if(supply>=demand){
        s1[i+2]=Integer.toString(supply-demand);
        bill = price * demand;
        writeMGfile(s1,"ground.txt");
    }
    else return "out of stock";
    
    return Integer.toString(bill);
}
    public static int counter(String s , String[] s1,int i){
        int count=0;
        if(i==s1.length){
            return count;
        }
        if(s.equals(s1[i]))count++;
        count+=counter(s,s1,i+4);
        return count;
    }
    public static boolean alphacheck(String s){
    String s2 = s.toUpperCase();
    boolean result = true;
    for(int i = 0 ; i<s.length();i++){
        if((s2.charAt(i)>=48 && s2.charAt(i)<=57) || ((s2.charAt(i))<65 || s2.charAt(i)>90) ){
            result=false;
            break;
        }
        
    }
    return result;
    
}
    public static boolean numcheck(String s){
    String s2 = s.toUpperCase();
    boolean result = true;
    for(int i = 0 ; i<s.length();i++){
        if(s2.charAt(i)>=48 && s2.charAt(i)<=57){
        } else {
            result=false;
            break;
        }
    }
    return result;
}
    public static String[] sorter(String[]s1){
        String s2 []=s1;
        String temp1,temp2,temp3,temp4;
        
        for(int i = 0 ; i<indexfinder(s2)-1 ; i+=4){
            for(int j = 0 ; j<indexfinder(s2)-1 ; j+=4){
                if(s2[i].equals("xxx")||s2[j].equals("xxx")){
                }
                else {
                    if(s2[i].compareToIgnoreCase(s2[j])== 1){
                    temp1=s2[i];   s2[i]=s2[j];     s2[j]=temp1;
                    temp2=s2[i+1]; s2[i+1]=s2[j+1]; s2[j+1]=temp2;
                    temp3=s2[i+2]; s2[i+2]=s2[j+2]; s2[j+2]=temp3;
                    temp4=s2[i+3]; s2[i+3]=s2[j+3]; s2[j+3]=temp4;
                }
            }
            }
        }
        return s2;
    }
}