package ACE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ACE.dao.Moviedao;
import ACE.dao.Reservedao;
import ACE.dao.Viewerdao;
import ACE.vo.MovieVo;
import ACE.vo.MovieReserveVo;
import ACE.vo.MovieViewVo;


public class MovieApp {
    private Viewerdao viewerDao = new Viewerdao();
    private Reservedao reserveDao = new Reservedao();
    private Moviedao movieDao = new Moviedao();

    public static void main(String[] args) {
        MovieApp app = new MovieApp();
        app.start();
    }

    public void start() {
        
        System.out.println("★ Almond Cinema★ 에 오신걸 환영합니다. 간편 로그인으로 서비스를 이용해주세요.");
        System.out.print("아이디 입력 __");
        String viewerid = System.console().readLine();
        
        boolean run = true;
        while (run) {       

            boolean chk = login(viewerid);
            while (true) {
                System.out.println("---------  ----        ----    --------      |    --");
                System.out.println("|           --          --    -              |  --");
                System.out.println("|----        --        --    -               |--");
                System.out.println("|             --      --      -              |  --");
                System.out.println("|               ------         --------      |    --");
                if (chk ==true) {System.out.println(String.format("%s님 환영합니다\n.", viewerid));
                break;
                }
                else{
                    System.out.println("없는 ID입니다. 다시 입력해주세요.");
                    System.out.print("아이디 입력 __");
                    viewerid = System.console().readLine();
                    chk = login(viewerid);
                    continue;
                }
            }
        
            showMenu();
            System.out.print("선택 >>> ");
            String select = System.console().readLine();
            switch (select) {
                case "M","m":   
                showMyReserve(viewerid);
                    break;
                case "G","g":
                showMovieListByGenre();
                    break;
                case "T","t":
                searchProductListByPname();
                    break;
                case "R","r":
                reserveMovie(viewerid);
                    break;
                case "D","d":
                deleteReserve();
                    break;
                case "C","c":
                modifyMovie();
                    break;
                case "X","x":
                    run=false;
                    break;
                default:
                    break;
            }
        }

    }

    private boolean login(String viewerid){
        boolean chk = false;
        if(viewerDao.checkId(viewerid)==1)
             chk=true;

        return chk;
    }


    private void showMenu() {
        System.out.println(".".repeat(70));
        System.out.println("[G] 장르별 영화 조회      [T] 제목명 검색");
        System.out.println("[M]나의 예매내역    ");
        System.out.println("[R] 예매하기   [D] 예매 취소  [C] 예매 영화 변경  [X] 예매 종료");
        System.out.println(".".repeat(70));
    }

    private void showMovieListByGenre() {
        System.out.println("장르 목록 : | 액션 | 로맨스 | 드라마 | 공포 | 코미디 | 기타 |");
        System.out.print("장르 입력__");
        List<MovieVo> movielist = movieDao.selectByGenre(System.console().readLine());

            if (movielist.isEmpty()) {
                System.out.println("검색한 장르가 없습니다.");
                return;
            }
        
            for (MovieVo vo : movielist) {
                System.out.println(vo);
            }

      
    }

    public void searchProductListByPname() {
        System.out.print("영화 제목 검색어 입력__");
        List<MovieVo> movielist = movieDao.selectByTitle(System.console().readLine());
        
        if (movielist.isEmpty()) {
            System.out.println("검색한 영화 제목이 없습니다.");
            return;
        }
    
        for (MovieVo vo : movielist) {
            System.out.println(vo);
        }
    }    

    private void reserveMovie(String viewerid){
        System.out.print(" 영화 제목을 입력하세요. __ ");
        String title = System.console().readLine();

        MovieReserveVo vo = new MovieReserveVo(0, viewerid, title, null);
        if(reserveDao.reserve(vo)==1)
            System.out.println(String.format("[%s] 영화를 예매하였습니다", title));
        else    //참조테이블에 없는값 입력시
            System.out.println("영화제목 또는 고객 아이디 오류입니다.");
    }

    private void deleteReserve(){
        System.out.print("취소할 예매 번호를 입력하세요. __ ");
        if(reserveDao.delete(Integer.parseInt(System.console().readLine()))==1)
            System.out.println("삭제하려면 엔터, 취소는 n을 입력하세요.");
            if(System.console().readLine().equals("n"))
            System.out.println("정상적으로 취소되었습니다.");
                continue;
        else
            System.out.println("없는 예매번호 입니다.");
    }

    private void showMyReserve(String viewerid) {
        List<MovieViewVo> result = reserveDao.selectViewerReserveList(viewerid);
                    for(MovieViewVo vo : result)  
                            System.out.println(vo);
    }

    private void modifyMovie(){
        System.out.print(" 수정할 예매 번호를 입력하세요. __ ");
                int res_idx = Integer.parseInt(System.console().readLine());

                System.out.print(" 변경할 영화제목을 새로 입력하세요. __ ");
                String title = System.console().readLine();

                MovieReserveVo vo = new MovieReserveVo(res_idx, null, title, null);
                
                if(reserveDao.update(vo)==1)
                    System.out.println("정상적으로 수정되었습니다.");
                else
                    System.out.println("없는 구매번호 입니다.");
    }

}