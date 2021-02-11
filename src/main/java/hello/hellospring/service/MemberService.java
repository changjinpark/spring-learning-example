package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    /*
    회원 가입
    */
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){

        validate_duplication(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validate_duplication(Member member) {
        memberRepository.findbyName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    전체 회원 조회
    */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findbyId(memberId);
    }

}
