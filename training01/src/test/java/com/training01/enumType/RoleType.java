package com.training01.enumType;

public enum RoleType {

    ADMIN/*0*/, MEMBER/*1*/; //상수 정의(열거형)

    /* ENUM(Enumrated type)
     * 서로 연관된 상수들의 집합
     * 열거형으로 사용
     *
     * @Enumerated(EnumType.ORDINAL)
     * ---전달된 enum의 숫자를 데이터베이스에 저장한다.
     * ---ADMIN, MEMBER; 의 경우, ADMIN은 0, MEMBER는 1로 저장됨
     *
     * @Enumerated(EnumType.STRING)
     * ---전달된 enum의 문자열을 데이터베이스에 저장한다.
     * ---ADMIN, MEMBER; 의 경우, ADMIN은 ADMIN, MEMBER는 MEMBER로 저장됨 */

}