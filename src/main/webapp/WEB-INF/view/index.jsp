<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<main>

                <!-- 검색 기능 -->
                <div id="search_wrap">
                    <div></div>
                    <div id="search">
                        <select id="field">
                            <option value="title">제목</option>
                            <option value="nickname">작성자</option>
                        </select>
                        <div id="keyword_wrap">
                            <input id="keyword">
                            <img id="search_btn" src="../image/search_btn.png" alt="검색" onclick="search()">
                        </div>
                    </div>
                </div>

                <!-- 정렬 기능 -->
                <div id="sort_wrap">
                    <div id="newSort_wrap" style="cursor: pointer;" onclick="sort('new')">
                        <img src="../image/checkedSort.png">
                        <span style="color: #38424A;">최신</span>
                    </div>
                    <div id="hotSort_wrap" style="cursor: pointer;" onclick="sort('hot')">
                        <img src="../image/uncheckedSort.png">
                        <span style="color: #AEAEAE;">인기</span>
                    </div>
                    <div id="lookSort_wrap" style="cursor: pointer;" onclick="sort('look')">
                        <img src="../image/uncheckedSort.png">
                        <span style="color: #AEAEAE;">조회</span>
                    </div>
                </div>

                <!-- 글 쓰기 -->
                <div id="reg_wrap">
                    <a href="/contents/reg" id="reg">글 쓰기</a>
                </div>

                <!-- 컨텐츠 -->
                <div id="contents">

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title"><a href="/contents/detail?no=1">자바 데이터 타입, 변수 그리고 배열</a></div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>

                    <div class="content">
                        <div class="information">
                            <div class="info">
                                <span>Dev_Hong</span>
                                <span>❤️86</span>
                                <span><img src="../image/look.png">130</span>
                                <span class="cate">Language - JAVA</span>
                            </div>
                            <div class="reg">
                                <span>2022-10-07</span>
                            </div>
                        </div>

                        <div class="title">자바 데이터 타입, 변수 그리고 배열</div>
                        <div class="cont">
                            우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다. 우리가 주로 사용하는 값의 종류는 크게 문자와 숫자로 나눌 수 있으며 여기서 숫자는 다시 정수와 실수로 나뉜다. 기본형은 모두 8가지의 타입(자료형)이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.
                        </div>
                    </div>
                    
                </div>
                <!-- 맨 위로 -->
                <div id="screenUp_wrap">
                    <div id="screenUp" onclick="scrollToTop(); return false;">맨 위로</div>
                </div>

                <!-- 페이징 -->
                <div id="pages">
                    <span class="page">1</span>
                    <span>..</span>
                    <span class="page">6</span>
                    <span class="page">7</span>
                    <span class="myPage">8</span>
                    <span class="page">9</span>
                    <span class="page">10</span>
                    <span>..</span>
                    <span class="page">17</span>
                </div>

            </main>