package repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("changjin park");

        repository.save(member);

        Member result = repository.findbyId(member.getId()).get();
        assertThat(result).isEqualTo(member);

    }

    @Test
    public void findbyName(){
        Member member1 = new Member();
        member1.setName("changjin park");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("changjin park2");
        repository.save(member2);

        Member result = repository.findbyName(member1.getName()).get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("changjin park");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("changjin park2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

}
