<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<main>
        
            <div>
                <form action="" method="post" enctype="multipart/form-data">
                    <div id="regCategory">
                        <div>* Main Category</div>
                        <select name="mainCategory" id="mainCategory">
                            <option value=""> -- 선택해 주세요 -- </option>
                            <option value="1" selected>Language</option>
                            <option value="2">Front-End</option>
                            <option value="3">Back-End</option>
                            <option value="4">Database</option>
                            <option value="5">Project Management</option>
                            <option value="6">ETC</option>
                        </select>

                        <div>* Sub Category</div>
                        <select name="subCategory" id="subCategory">
                            <option value=""> -- 선택해 주세요 -- </option>
                            <option value="1" selected>JAVA</option>
                            <option value="2">Python</option>
                            <option value="3">C</option>
                        </select>
                    </div>

                    <hr>

                    <div id="title_wrap">
                        <div>* 제목</div>
                        <input name="title" id="title" value="자바 데이터 타입, 변수 그리고 배열">
                    </div>

                    <hr>

                    <div id="file_wrap">
                        <div class="txt">첨부 파일</div>
                        <div id="f">
                            <div class="file">·<a download href="">test.txt</a><div class="file_delete" onclick="file_delete(this)">삭제</div></div>
                            <div class="file">·<a download href="">readme.txt</a><div class="file_delete" onclick="file_delete(this)">삭제</div></div>
                        </div>
                        <div class="txt">파일 추가</div>
                        <input type="file" name="files" id="file" multiple>
                    </div>

                    <hr>

                    <div id="contents_wrap">
                        <div>* 내용</div>
                        <textarea name="contents" id="contents" cols="30" rows="10">자바 데이터 타입, 변수 그리고 배열</textarea>
                    </div>

                    <hr>

                    <div id="reg_btn">
                        <input type="button" id="reg" value="작성">
                    </div>
                </form>
            </div>
            
        </main>