package ACE;


import java.util.List;

import ACE.dao.Moviedao;
import ACE.dao.Reservedao;
import ACE.dao.Viewerdao;
import ACE.vo.MovieVo;
import ACE.vo.MovieReserveVo;



public class MovieApp {
    private Viewerdao viewerDao = new Viewerdao();
    private Reservedao reserveDao = new Reservedao();
    private Moviedao movieDao = new Moviedao();
    private String viewerid = null;
    private String viewerpasswd = null;
    public static void main(String[] args) {
        MovieApp app = new MovieApp();
        app.start();
    }

    public void start() {
        
        System.out.println("★ Almond Cinema★ 에 오신걸 환영합니다. 간편 로그인으로 서비스를 이용해주세요.");
        System.out.print("아이디 입력 __");
        viewerid = System.console().readLine();
        System.out.print("비밀번호 입력 __");
        viewerpasswd = System.console().readLine();
        
        boolean run = true;
        while (run) {       

            boolean chk = loginid(viewerid);
            boolean chk2 = loginpasswd(viewerid,viewerpasswd);
            while (true) {
                if (chk && chk2 == true) {System.out.println(String.format("%s님 환영합니다\n.", viewerid,viewerpasswd));
                break;
                }
                else{
                    System.out.println("없는 ID 및 비밀번호가 맞지 않습니다.다시 입력해주세요.");
                    System.out.print("아이디 입력 __");
                    viewerid = System.console().readLine();
                    System.out.print("비밀번호 입력 __");
                    viewerpasswd = System.console().readLine();
                    chk = loginid(viewerid);
                    chk2 = loginpasswd(viewerid,viewerpasswd);
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
                showmovielist(viewerid);
                System.out.println("\n");
                resCartMovies(viewerid);
                    break;
                case "D","d":
                showMyReserve(viewerid);
                deleteReserve();
                    break;
                case "L","l":
                System.out.println("계정을 로그아웃합니다.");
                start();
                    break;
                case "C","c":
                showMyReserve(viewerid);
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

    private boolean loginid(String viewerid){
        boolean chk = false;
        if(viewerDao.checkId(viewerid)==1)
             chk=true;

        return chk;
    }

    private boolean loginpasswd(String viewerid,String viewerpasswd){
        boolean chk2 = false;
        if(viewerDao.checkpasswd(viewerid,viewerpasswd)==1)
             chk2=true;

        return chk2;
    }


    private void showMenu() {
        System.out.println("★".repeat(70));
        System.out.println(".".repeat(70));
        System.out.println("[G] 장르별 영화 조회      [T] 제목명 검색      [M]나의 예매내역");
        System.out.println("[R] 예매하기   [D] 예매 취소  [C] 예매 영화 변경  [X] 예매 종료 [L] 로그아웃");
        System.out.println(".".repeat(70));
        System.out.println("★".repeat(70));
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

    private void deleteReserve(){
        System.out.print("취소할 예매 번호를 입력하세요. __ ");
        int chk = Integer.parseInt(System.console().readLine());
        System.out.println("예매 번호 >>>>>");
            if(reserveDao.selAll(viewerid).getRes_idx() == chk && reserveDao.delete(chk)==1){
                    System.out.println("삭제성공");
            }else{
                System.out.println("권한이 없거나 없는 예매번호 입니다.");
            }      
    }


    private void showMyReserve(String viewerid) {
        List<MovieReserveVo> result = reserveDao.selectViewerReserveList(viewerid);
                    for(MovieReserveVo vo : result)  
                            System.out.println(vo);
    }

    private void modifyMovie(){
        System.out.print(" 수정할 예매 번호를 입력하세요. __ ");
                int res_idx = Integer.parseInt(System.console().readLine());
                if(reserveDao.selAll(viewerid).getRes_idx() == res_idx){
                    if(reserveDao.delete(res_idx)==1){
                    }
                }else{
                    System.out.println("권한이 없거나 없는 예매번호 입니다.");
                    return;
                }
                System.out.print(" 변경할 영화제목을 새로 입력하세요. __ ");
                String title = System.console().readLine();

                MovieReserveVo vo = new MovieReserveVo(res_idx, null, title, null);
                
                if(reserveDao.update(vo)==1)
                    System.out.println("정상적으로 수정되었습니다.");
                else
                    System.out.println("없는 구매번호 입니다.");
    }
    
    private void showmovielist (String viewerid) {
        List<MovieVo> result = movieDao.Movielist(viewerid);
                    for(MovieVo vo : result)  
                            System.out.println(vo);
    }

    private void resCartMovies(String custom_id){
        System.out.print("[예매할 영화 제목 입력] : ");
        String title = System.console().readLine();
        if (reserveDao.checkAgeLimit(custom_id, title)) {
            System.out.println("나이 더 먹고와 애송아");
        }else{
            MovieReserveVo rvo = new MovieReserveVo(0, custom_id, title, null);
        if (reserveDao.reserve(rvo)==1) {
            System.out.println(String.format("[%s] 예매완료.", title));
        }else{
            System.out.println("예매를 실패하였습니다.");
        }
        }
    }

}