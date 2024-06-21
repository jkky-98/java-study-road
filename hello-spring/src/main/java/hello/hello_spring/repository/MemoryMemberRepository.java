package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                // member를 파라미터로 한다.
                // stream내에는 많은 member들이 존재한다.
                // 각각의 member.getName().equals(name)으로부터 boolean을 얻는다.
                // filter는 boolean를 기준으로 true인 member만 재 구성한다.
                .findAny();
                // findAny로 재 구성된 stream중 하나를 return한다.
                // stream에는 member가 없을 수도, 1개가 존재할 수도 있다.
                // findAny는 값이 없어도 빈 Optinal을 뱉기에 ofNullable사용이 필요없다.


    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
