package com.emenu.comito.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /*
        SpringDataJpa에서 제공하지 않는 메서드는 쿼리로 작성해도 된다.

        규모가 있는 프로젝트에서의 데이터 조회는 FK의 조인, 복잡한 조건 등으로 인해 이런 Entity 클래스만으로 처리하기 어려워
        조회용 프레임워크를 추가로 사용한다. 대표적 예로 querydsl, jooq, MyBatis 등이 있다.
        조회는 위 3가지 프레임워크 중 하나를 통해 조회하고, 등록/수정/삭제 등은 SpringData Jpa 를 통해 진행한다.

        - Querydsl의 장점
        1. 타입 안정성이 보장된다.
        : 단순한 문자열로 쿼리를 생성하는 것이 아니라, 메서드를 기반으로 쿼리를 생성하기 때문에 오타나 존재하지 않는 컬럼명을 명시할 경우
        IDE에서 자동으로 검출된다.
        2. 레퍼런스가 많다.

     */
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
