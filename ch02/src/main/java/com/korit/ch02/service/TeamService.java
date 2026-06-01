package com.korit.ch02.service;

import com.korit.ch02.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    public Team getTeamOfMember(Long memberId) {
        return findTeamByMemberId(memberId);
    }
    public Team findTeamByMemberId(Long memberId) {
        return null;
    }

}
