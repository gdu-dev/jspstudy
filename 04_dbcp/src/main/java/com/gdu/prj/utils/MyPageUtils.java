package com.gdu.prj.utils;

public class MyPageUtils {

  private int total;     // 전체 게시글 개수                      (DB에서 구한다.)
  private int display;   // 한 페이지에 표시할 게시글 개수        (요청 파라미터로 받는다.)
  private int page;      // 현재 페이지 번호                      (요청 파라미터로 받는다.)
  private int begin;     // 한 페이지에 표시할 게시글의 시작 번호 (계산한다.)
  private int end;       // 한 페이지에 표시할 게시글의 종료 번호 (계산한다.)
  
  public void setPaging(int total, int display, int page) {
    
    this.total = total;
    this.display = display;
    this.page = page;
    
    begin = (page - 1) * display + 1;
    end = begin + display - 1;
    
  }
  
  total   1002
  diaplay 20
  
  page=1  1   20
  page=2  21  40
  page=3  41  60
  ..
  page=50 981  1000
  page=51 1001 1020
  
  계산
  totalPage 50
  
}
