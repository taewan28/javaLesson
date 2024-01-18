package collection.day11;

import java.util.ArrayList;
import java.util.List;


//1월 14일 저녁 9시까지 제출해주세요.
public class CustomerManageApp {
    private List<Customer> customers = new ArrayList<>();

        private void start(){
            //메뉴 선택 : 등록,검색(이름/그룹), 삭제, 수정, 전체출력
            initialize(); 
        System.out.println("메뉴보기 프로그램 시작합니다.~~~" + "~".repeat(30));
        while (true) {
            System.out.println("\t <메뉴를 선택하세요.>");
            System.out.println("\t 1. 고객 등록");
            System.out.println("\t 2. 고객 검색(이름/그룹)");
            System.out.println("\t 3. 고객 삭제");
            System.out.println("\t 4. 고객 수정");
            System.out.println("\t 5. 고객 목록 출력");
            System.out.println("\t 6. 프로그램 종료 ");
            System.out.print("선택 >");                               
            int select = Integer.parseInt(System.console().readLine());   

            switch (select) {
                case 1:
                Customeradd();                  
                    break;
                case 2: searchcustomer(); break;      
                case 3: removecustomer(); break;
                case 4: modifycustomer(); break;
                case 5: listCustomer(); break; 
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 선택값 입니다.");
                    //break;
            }
        }
    }


    private void initialize() {
        customers.add(new Customer("손흥민", "010-1111-2222", 1));
        customers.add(new Customer("황희찬", "010-3333-4444", 1));
        customers.add(new Customer("이강인", "010-5555-6666", 3));
        customers.add(new Customer("이천수", "010-7777-8888",2));
        customers.add(new Customer("김민재", "010-9999-0000",2));
        
    }


    private void Customeradd() {
        System.out.println("\t:: 고객 등록합니다.::");
        System.out.print("고객 이름을 입력해주세요. _");
        String name = System.console().readLine();
        System.out.print("전화 번호 입력해주세요. _");
        String phone = System.console().readLine();
        System.out.print("등급을 입력해주세요.(1:일반 2:vip 3:기타) _");
        int group = Integer.parseInt(System.console().readLine());

        customers.add(new Customer(name, phone, group));
    }



    private List<Customer> searchAllName(String name){
        List<Customer> list = new ArrayList<>(); 
        for(Customer customer : customers){
            if(customer.getName().equals(name)){
                list.add(customer);                   
            }
        }
        return list;
    }




    private List<Customer> searchAllGroup(int group){
        List<Customer> list = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getGroup()==group){
                list.add(customer);            
            }
        }
        return list;
    }

     private void searchcustomer(){
        System.out.println("\t:: 고객을 검색합니다.(고객이름 조회는 1, 고객등급 조회는2 )::");
        String find = null;
        List<Customer> list = null;
        switch (System.console().readLine()) {
            case "1":
                System.out.print("검색할 고객이름을 입력하세요._");
                find = System.console().readLine();
                list = searchAllName(find);
                break;
            case "2":
                System.out.println("검색할 그룹을 입력하세요");
                int group = Integer.parseInt(System.console().readLine()); 
                list = searchAllGroup(group);
                break;
            default:
                System.out.println("1,2 만 입력하세요");
                return;
        }
        System.out.println("\t:: 검색 결과 입니다.::");
        if(list.size()==0)  System.out.println("찾는 고객이름이 목록에 없습니다.");
        else printCustomerList(list);
    }


    private void removecustomer() {
        System.out.println("\t:: 고객을 검색합니다.::");
        System.out.print("삭제할 고객을 입력해주세요 _");
        String find = System.console().readLine();
        boolean isFind = false;
         for(int i=0; i<customers.size(); i++){
            if(customers.get(i).getName().equals(find)){
                System.out.println("고객명단" + i + "에서 이름를 찾았습니다.");
                System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요.");
                if(System.console().readLine().equals("n"))
                     continue;
                else{
                    customers.remove(i); System.out.println("고객 삭제 완료!!");
                }
            }
        }
        if(!isFind)
                System.out.println("삭제할 이름이 명단에 없습니다.");
    }

    private void modifycustomer() {
        System.out.println("\t:: 고객을 검색합니다. ::");
        System.out.print("수정할 고객을 입력해주세요: ");
        String find = System.console().readLine();
        boolean isFind = false;
        
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(find)) {
                System.out.println("고객명단 " + i + "에서 이름을 찾았습니다.");
                System.out.println(find + "의 번호를 수정하겠습니다.");
                String phonemodify = System.console().readLine();
                System.out.println(find + "의 등급을 수정하겠습니다.");
                int phonemodify2 = Integer.parseInt(System.console().readLine());
                
                if (phonemodify2 > 0 && phonemodify2 < 4) {
                    customers.get(i).modify(phonemodify, phonemodify2);
                    System.out.println("고객 정보가 수정되었습니다.");
                } else {
                    System.out.println("그룹 수정은 0보다 크고 4보다 작은 값을 입력해주세요.");
                }
                isFind = true;
            }
        }
        if (!isFind) {
            System.out.println("삭제할 이름이 명단에 없습니다.");
        }
    }


        private void printCustomerList(List<Customer>list){
            for(Customer customer : list){
            System.out.println(String.format("%-20s %-30s %-50s",customer.getName(),customer.getPhone(),customer.getGroup()));
            }
        }


        private void listCustomer() {
            System.out.println("\t:: 고객 목록 출력합니다.::");
            System.out.println(String.format("%-20s %-30s %-20s","NAME","PHONE","GROUP"));

        printCustomerList(customers);
        }


public static void main(String[] args){
    CustomerManageApp app = new CustomerManageApp();
    app.start();
}
}
    

