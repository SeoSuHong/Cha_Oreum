<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<main>
        
            <div>
                <div id="information">
                    <span id="category"><span>Language</span> - <span>JAVA</span></span>
                    <span id="regDate">2022-10-08</span>
                </div>
                <div id="nickname">Dev_Hong</div>
                <div id="title">자바 데이터 타입, 변수 그리고 배열</div>
                <div id="files">
                    <div id="file">첨부 파일</div>
                    <div class="file">
                        <div><a download href="" class="fileName">test.txt</a> | <span class="fileSize">4,096Byte</span></div>
                        <div><a download href="" class="fileName">test.txt</a> | <span class="fileSize">4,096Byte</span></div>
                    </div>
                </div>
                <div id="contents">
                    국무총리는 국회의 동의를 얻어 대통령이 임명한다. 국가의 세입·세출의 결산, 국가 및 법률이 정한 단체의 회계검사와 행정기관 및 공무원의 직무에 관한 감찰을 하기 위하여 대통령 소속하에 감사원을 둔다. 국민의 모든 자유와 권리는 국가안전보장·질서유지 또는 공공복리를 위하여 필요한 경우에 한하여 법률로써 제한할 수 있으며, 제한하는 경우에도 자유와 권리의 본질적인 내용을 침해할 수 없다. 대통령의 임기가 만료되는 때에는 임기만료 70일 내지 40일전에 후임자를 선거한다. 누구든지 체포 또는 구속을 당한 때에는 적부의 심사를 법원에 청구할 권리를 가진다. 국가는 법률이 정하는 바에 의하여 재외국민을 보호할 의무를 진다.

대통령은 헌법과 법률이 정하는 바에 의하여 국군을 통수한다. 선거와 국민투표의 공정한 관리 및 정당에 관한 사무를 처리하기 위하여 선거관리위원회를 둔다. 모든 국민은 헌법과 법률이 정한 법관에 의하여 법률에 의한 재판을 받을 권리를 가진다. 형사피의자 또는 형사피고인으로서 구금되었던 자가 법률이 정하는 불기소처분을 받거나 무죄판결을 받은 때에는 법률이 정하는 바에 의하여 국가에 정당한 보상을 청구할 수 있다. 국회의원은 현행범인인 경우를 제외하고는 회기중 국회의 동의없이 체포 또는 구금되지 아니한다. 국가원로자문회의의 의장은 직전대통령이 된다. 다만, 직전대통령이 없을 때에는 대통령이 지명한다.

공무원인 근로자는 법률이 정하는 자에 한하여 단결권·단체교섭권 및 단체행동권을 가진다. 국회는 법률에 저촉되지 아니하는 범위안에서 의사와 내부규율에 관한 규칙을 제정할 수 있다. 국무총리 또는 행정각부의 장은 소관사무에 관하여 법률이나 대통령령의 위임 또는 직권으로 총리령 또는 부령을 발할 수 있다. 모든 국민은 인간으로서의 존엄과 가치를 가지며, 행복을 추구할 권리를 가진다. 국가는 개인이 가지는 불가침의 기본적 인권을 확인하고 이를 보장할 의무를 진다. 법원은 최고법원인 대법원과 각급법원으로 조직된다. 군인은 현역을 면한 후가 아니면 국무총리로 임명될 수 없다. 모든 국민은 사생활의 비밀과 자유를 침해받지 아니한다.
                </div>
            </div>

            <div id="guest">
                <div>
                    <div id="hart"><!-- 🤍 -->❤️</div><div id="like">좋아요</div>
                </div>
                <div onclick="comment_focus()">
                    <img src="../image/comment.png" id="comment_img"><div id="comment_btn">댓글 쓰기</div>
                </div>
            </div>

            <!-- comment -->
            <div>
                <div id="comments">
                    <div class="mainComment">
                        <div class="nickname">Dev_Kim</div>
                        <div class="comment">댓글 입니다.</div>
                        <div class="commRegDate"><span>2022-10-08</span><span class="reply_btn">답글 쓰기</span></div>
                    </div>
                    <div class="reply">
                        <form name="replyForm" action="" method="post">
                            <div>
                                <textarea name="reply" class="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
                                <div class="reply_btn_wrap">
                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(comment_no)">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Kim</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                    </div>

                    <div class="mainComment">
                        <div class="nickname">Dev_Kim</div>
                        <div class="comment">댓글 입니다.</div>
                        <div class="commRegDate"><span>2022-10-08</span><span class="reply_btn">답글 쓰기</span></div>
                    </div>
                    <div class="reply">
                        <form name="replyForm" action="" method="post">
                            <div>
                                <textarea name="reply" class="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
                                <div class="reply_btn_wrap">
                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(comment_no)">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Kim</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                    </div>

                    <div class="mainComment">
                        <div class="nickname">Dev_Kim</div>
                        <div class="comment">댓글 입니다.</div>
                        <div class="commRegDate"><span>2022-10-08</span><span class="reply_btn">답글 쓰기</span></div>
                    </div>
                    <div class="reply">
                        <form name="replyForm" action="" method="post">
                            <div>
                                <textarea name="reply" class="reply_txt" cols="30" rows="10" placeholder="답글을 입력해 주세요."></textarea><hr>
                                <div class="reply_btn_wrap">
                                    <input type="button" class="reply_send" value="입력" onclick="sendReply(comment_no)">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Kim</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                        <div class="subComment">
                            <div class="nickname">Dev_Hong</div>
                            <div class="comment">답글 입니다.</div>
                            <div class="commRegDate">2022-10-08</div>
                        </div>
                    </div>
                </div>
                <div id="writeComment">
                    <form name="commentForm" action="" method="post">
                        <div id="comment_nick">Dev_Hong</div>
                        <div id="comment_wrap">
                            <textarea name="comment" id="comment_txt" cols="30" rows="10"></textarea><hr>
                            <div id="comment_btn_wrap">
                                <input type="button" id="comment_send" value="입력">
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <!-- 수정, 삭제 -->
            <div id="update_wrap">
                <form name="updateForm" method="post">
                    <input type="button" name="" id="update" value="수 정" onclick="location.href='/contents/edit'">
                    <input type="button" name="" id="delete" value="삭 제">
                </form>
            </div>

        </main>