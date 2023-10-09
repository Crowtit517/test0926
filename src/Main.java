import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
public class Main {
    //public static void main(String[] args) {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        temp();

        Test a = new Test(); //Test 생성자는 조상으로 부터 상속받고 count 라는 함수를 추가하였다.
        Test b = new Test();
        Test c = new Test();
        System.out.println(Test.count);
        //a.array_test();
        //a.string_test();
        //a.method_test();
        //a.exception_test();
        a.filereadwrite_test();

    }
    static void temp(){
        System.out.println("temp");
    }

}
class Test { //test 클래스 안에서는 this.??? 가능 | 클래스 밖에서는 a.???라 사용가능 | test()가 생성자 함수이다

    void filereadwrite_test() throws Exception{ //throws 집어던지다 Exception 호출자에게
        FileInputStream fis = new FileInputStream("data1.txt");
        FileOutputStream fos = new FileOutputStream("data2.txt");

        int ch;

        while ((ch = fis.read()) != -1){// -1 - end of file 파일이 끝났다
            System.out.print((char) ch);
            fos.write((byte) ch);


        }
    }

    void exception_test(){
        int[] aa = new int[3];
        try{
            aa[2] = 100 / 0;
            aa[3] = 100;
        } /*catch (ArrayIndexOutOfBoundsException e){ //e - 에러 메세지를 담고있는 인스턴스
            System.out.println("배열 점자가 배열 크기보다 켜요 ~~");
        } catch (ArithmeticException e){
            System.out.println("0으로 나누는 등의 오류에요 ~~");
        }*/
        catch (Exception e) { //Exception 가 부모이기 떄문에 하나로 예외 처리가 가능하다
            System.out.println("에러입니다 ~~");
        }
        finally {
            System.out.println("이 부분은 무조건 나와요 ~~");
        }
    }

    int local_var;
    static int static_var, count = 0;

    Test(){ // 생성자함수
        count ++;
    }

    int plus(int v1, int v2){
        int result;
        result = v1 + v2;
        return result;
    }
    void method_test(){
        int hap;
        hap = this.plus(100, 200);
        System.out.printf("100과 200의 plus() 메소드 결과는 : %d\n", hap);

        local_var = 1000;
        System.out.printf("로컬변수 : %d\n", this.local_var);

        static_var = 2000;
        System.out.printf("전역변수 : %d\n", Test.static_var);
    }
    void string_test(){
        Scanner s = new Scanner(System.in);
        String str;//엔터까지 입력을 받는다.

        System.out.print("문자열 입력 ==> ");
        str = s.nextLine();

        System.out.print("출력 문자열==> ");
        for (int i = 0 ; i < str.length() ; i++){ //str.length() - 문자열의 길이 까지
            if(str.charAt(i) == 'o')
                System.out.printf("%c", '$');
            else
                System.out.printf("%c", str.charAt(i));
        }
    }


    void array_test(){
        Scanner s = new Scanner(System.in);
        int[] aa = new int[4];
        //int[] aa = new int[]{1,2,3,4};
        int hap = 0, i;

        for (i =0 ; i<=3 ; i++){
            System.out.printf("%d번째 숫자를 입력하세요:", i +1);
            aa[i] = s.nextInt();
        }
        //hap = aa[0] + aa[1] + aa[2] + aa[3];
        for (i = 0 ; i <=3 ; i++){
            hap = aa[i] + hap;
        }

        System.out.printf("합계 ==> %d \n", hap);

        s.close();
    }
}