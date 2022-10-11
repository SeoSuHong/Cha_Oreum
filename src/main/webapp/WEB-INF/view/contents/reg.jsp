<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<main>
        
            <div>
                <form action="" method="post">
                    <div id="regCategory">
                        <div>* Main Category</div>
                        <select name="mainCategory" id="mainCategory">
                            <option value=""> -- 선택해 주세요 -- </option>
                            <option value="1">Language</option>
                            <option value="2">Front-End</option>
                            <option value="3">Back-End</option>
                            <option value="4">Database</option>
                            <option value="5">Project Management</option>
                            <option value="6">ETC</option>
                        </select>

                        <div>* Sub Category</div>
                        <select name="subCategory" id="subCategory">
                            <option value=""> -- 선택해 주세요 -- </option>
                            <option value="1">JAVA</option>
                            <option value="2">Python</option>
                            <option value="3">C</option>
                        </select>
                    </div>

                    <hr>

                    <div id="title_wrap">
                        <div>* 제목</div>
                        <input name="title" id="title">
                    </div>

                    <hr>

                    <div id="file_wrap">
                        <div>첨부 파일</div>
                        <input type="file" name="files" id="file" multiple>
                    </div>

                    <hr>

                    <div id="contents_wrap">
                        <div>* 내용</div>
                        <textarea name="contents" id="contents" cols="30" rows="10"></textarea>
                    </div>

                    <hr>

                    <div id="reg_btn">
                        <input type="button" id="reg" value="작성">
                    </div>
                </form>
            </div>
            
        </main>