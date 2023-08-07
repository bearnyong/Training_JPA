package com.training01.table;


import com.training01.enumType.RoleType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
[ 회원 ]
- 회원의 pk는 데이터베이스에서 관리하는 전략을 사용한다. (시퀀스?)
- 회원의 닉네임의 길이는 최대 10자이다.
- 회원의 닉네임은 중복되지 않는다.
- 회원의 전화번호의 기본값은 010-0000-0000이다.
- 권한은 enumType으로 관리한다. (RoleType)
- 등록일,수정일은 날짜및 시간이 모두 저장되며
- 삭제일은 날짜만 표기한다.
- 수정일 삭제일을 제외한 모든 컬럼은 null을 허용하지 않는다.
*/

@Entity(name = "training01_member") //엔티티 객체로 만들기 위한 어노테이션 (name: 엔티티를 식별하기 위한 네임)
@Table(name = "tbl_training01_member") //데이터베이스 엑세스 시 테이블 이름을 생성하기 위한 네임
public class Member {

    @Id //PK
    @Column(name = "mem_num", nullable = false) //NOT NULL
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    private int memNum; //회원번호

    @Column(name = "mem_name", nullable = false) //NOT NULL
    private String memName; //회원이름

    @Column(name = "mem_nickname", length = 10, unique = true, nullable = false) //닉네임의 최대 길이는 10자이며, 중복되지 않는다. NOT NULL
    private String memNickname; //회원닉네임

    @Column(name = "mem_phone", columnDefinition = "default '010-0000-0000'", nullable = false) //전화번호의 기본 값 설정, NOT NULL
    private String memPhone; //전화번호

    @Column(name = "mem_postcode", nullable = false) //NOT NULL
    private String memPostcode; //우편번호

    @Column(name = "mem_general_addr", nullable = false) //NOT NULL
    private String memGeneralAddr; //일반주소

    @Column(name = "mem_detailed_addr", nullable = false) //NOT NULL
    private String memDetailedAddr; //상세주소

    @Column(name = "mem_role", nullable = false) //NOT NULL
    @Enumerated(EnumType.STRING) //enumType관리: 전달된 enum의 문자열을 데이터베이스에 저장한다.
    private RoleType memRole; //권한

    @Column(name = "mem_status", nullable = false) //NOT NULL
    private String memStatus; //상태

    @Column(name = "mem_insert_date", nullable = false) //NOT NULL
    @Temporal(TemporalType.TIMESTAMP) //날짜 및 시간을 모두 저장한다.
    private Date memInsertDate; //등록일

    @Column(name = "mem_update_date")
    @Temporal(TemporalType.TIMESTAMP) //날짜 및 시간을 모두 저장한다.
    private Date memUpdateDate; //수정일

    @Column(name = "mem_delete_date")
    @Temporal(TemporalType.DATE) //날짜를 저장한다.
    private Date memDeleteDate; //삭제일

//    @OneToMany(mappedBy = "memberNum") //해도 되고 안 해도 되는 mappedBy -> 얘를 참조하고 있는 필드명...
//    private List<Order> orderList;
//    //회원 1명 -> 주문 여러 개

    public Member() {
    }

    public Member(int memNum, String memName, String memNickname, String memPhone, String memPostcode, String memGeneralAddr, String memDetailedAddr, RoleType memRole, String memStatus, Date memInsertDate, Date memUpdateDate, Date memDeleteDate) {
        this.memNum = memNum;
        this.memName = memName;
        this.memNickname = memNickname;
        this.memPhone = memPhone;
        this.memPostcode = memPostcode;
        this.memGeneralAddr = memGeneralAddr;
        this.memDetailedAddr = memDetailedAddr;
        this.memRole = memRole;
        this.memStatus = memStatus;
        this.memInsertDate = memInsertDate;
        this.memUpdateDate = memUpdateDate;
        this.memDeleteDate = memDeleteDate;
    }

    public int getMemNum() {
        return memNum;
    }

    public void setMemNum(int memNum) {
        this.memNum = memNum;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemNickname() {
        return memNickname;
    }

    public void setMemNickname(String memNickname) {
        this.memNickname = memNickname;
    }

    public String getMemPhone() {
        return memPhone;
    }

    public void setMemPhone(String memPhone) {
        this.memPhone = memPhone;
    }

    public String getMemPostcode() {
        return memPostcode;
    }

    public void setMemPostcode(String memPostcode) {
        this.memPostcode = memPostcode;
    }

    public String getMemGeneralAddr() {
        return memGeneralAddr;
    }

    public void setMemGeneralAddr(String memGeneralAddr) {
        this.memGeneralAddr = memGeneralAddr;
    }

    public String getMemDetailedAddr() {
        return memDetailedAddr;
    }

    public void setMemDetailedAddr(String memDetailedAddr) {
        this.memDetailedAddr = memDetailedAddr;
    }

    public RoleType getMemRole() {
        return memRole;
    }

    public void setMemRole(RoleType memRole) {
        this.memRole = memRole;
    }

    public String getMemStatus() {
        return memStatus;
    }

    public void setMemStatus(String memStatus) {
        this.memStatus = memStatus;
    }

    public Date getMemInsertDate() {
        return memInsertDate;
    }

    public void setMemInsertDate(Date memInsertDate) {
        this.memInsertDate = memInsertDate;
    }

    public Date getMemUpdateDate() {
        return memUpdateDate;
    }

    public void setMemUpdateDate(Date memUpdateDate) {
        this.memUpdateDate = memUpdateDate;
    }

    public Date getMemDeleteDate() {
        return memDeleteDate;
    }

    public void setMemDeleteDate(Date memDeleteDate) {
        this.memDeleteDate = memDeleteDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memNum=" + memNum +
                ", memName='" + memName + '\'' +
                ", memNickname='" + memNickname + '\'' +
                ", memPhone='" + memPhone + '\'' +
                ", memPostcode='" + memPostcode + '\'' +
                ", memGeneralAddr='" + memGeneralAddr + '\'' +
                ", memDetailedAddr='" + memDetailedAddr + '\'' +
                ", memRole=" + memRole +
                ", memStatus='" + memStatus + '\'' +
                ", memInsertDate=" + memInsertDate +
                ", memUpdateDate=" + memUpdateDate +
                ", memDeleteDate=" + memDeleteDate +
                '}';
    }
}
