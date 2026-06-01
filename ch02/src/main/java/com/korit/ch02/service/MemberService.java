package com.korit.ch02.service;

import com.korit.ch02.entity.Member;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberService {


    public List<Member> getTeamMembers(Long teamId) {
        return findByTeamId(teamId);
    }

    public List<Member> findByTeamId(Long teamId) {
        // 구현 생략
        return List.of();
    }
}
